import logging
QUEUE_ENDPOINT = 'http://172.16.49.80:8161/api/message/source.queue?type=queue&clientId=consumerA'
TOPIC_ENDPOINT = 'http://172.16.49.80:8161/api/message/response.topic?type=topic'#&clientId=consumerA'
GET_MSG_REQ = 'curl -X delete {0}'
POST_MSG_REQ = 'curl -d "body={0}" {1}'
MESSAGE_KEYS = ['methodName', 'hostName', 'requestUrl', 'headers', 'queryString', 'payLoad']

LOG_LEVEL_CONSOLE = logging.INFO
LOG_LEVEL_FILE = logging.DEBUG
LOG_FILE_NAME = 'log_{0}.txt'
MAX_LOG_BYTES = 1000000
MAX_LOG_BACKUP_COUNT = 5