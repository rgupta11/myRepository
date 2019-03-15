import subprocess
import config
import shlex
import json
import urllib2
import sys
import base64
import urllib

from logger import setup_loggers


def read_msg_from_queue(end_point):
    logger.info('Reading the message')
    cmd = config.GET_MSG_REQ.format(end_point)
    result = execute_req(cmd)
    return result[0]


def send_msg_to_queue(message, end_point):
    logger.info('Sending the message')
    logger.info(message)
    cmd = config.POST_MSG_REQ.format(message, end_point)
    result = execute_req(cmd)
    return result[0]


def execute_req(cmd):
    logger.info('Executing the command {0}'.format(cmd))
    p = subprocess.Popen(shlex.split(cmd), stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    (stdout, stderr) = p.communicate()
    logger.info(stdout)
    return (stdout, stderr)


def validate_message(msg):
    for key in config.MESSAGE_KEYS:
        if key not in msg:
            logger.info('{0} is missing in message'.format(key))
            return False
    logger.info('Message is valid')
    return True


def handle_request(message):
    url = message['requestUrl']
    if message['queryString']:
        url += '?' + message['queryString']
    request = urllib2.Request(url)
    headers = message['headers'] if message['headers'] else {}
    for key, val in headers.items():
        request.add_header(key.encode('utf-8'), val.encode('utf-8'))
    payload = message['payLoad']

    if payload:
        if headers and 'content-type' in headers \
                and 'json' in headers['content-type']:
            logger.info('adding data')
            payload = urllib.urlencode(json.loads(payload))
        request.add_data(payload)
    result = None
    try:
        result = urllib2.urlopen(request)
        headers = base64.b64encode(json.dumps(dict(result.headers)))
        body = base64.b64encode(result.read())
        status_code = result.code
        response = generate_the_response(body, headers, status_code)
    except Exception as e:
        logger.error(e)
        response = generate_the_response(base64.b64encode(str(e)), '', 500)
    finally:
        if result:
            result.close()
    return response


def generate_the_response(body, headers, status_code):
    return {
        'body': body,
        'headers': headers,
        'statusCode': status_code,
    }


if __name__ == '__main__':
    logger = setup_loggers(sys.argv[1])
    count = 100
    while count:
        msg = read_msg_from_queue(config.QUEUE_ENDPOINT)
        if msg:
            msg = json.loads(msg)
            logger.info('Processing message {0}'.format(msg))
            if validate_message(msg):
                response = handle_request(msg)
                if 'migrationId' in msg:
                    response['migrationId'] = msg['migrationId'].encode('utf-8')
                logger.info('sending message to topic ' + str(msg))
                send_msg_to_queue(response, config.TOPIC_ENDPOINT)
                logger.info('Done message processing')
            else:
                logger.info('Message is invalid')
        count -= 1