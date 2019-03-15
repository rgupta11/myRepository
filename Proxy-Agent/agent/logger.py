import logging
from logging.handlers import RotatingFileHandler
from config import LOG_LEVEL_CONSOLE, LOG_LEVEL_FILE, LOG_FILE_NAME, MAX_LOG_BYTES, \
    MAX_LOG_BACKUP_COUNT


def setup_loggers(count):
    logger = logging.getLogger('agent')
    formatter = logging.Formatter('[%(asctime)s] {%(filename)s:%(lineno)d} %(levelname)s - %(message)s')

    file_name = LOG_FILE_NAME.format(count)
    file_handler = RotatingFileHandler(file_name, maxBytes=MAX_LOG_BYTES, backupCount=MAX_LOG_BACKUP_COUNT)
    file_handler.setFormatter(formatter)
    file_handler.setLevel(LOG_LEVEL_CONSOLE)

    console_handler = logging.StreamHandler()
    console_handler.setFormatter(formatter)
    console_handler.setLevel(LOG_LEVEL_FILE)

    logger.addHandler(file_handler)
    logger.setLevel(logging.DEBUG)
    logger.addHandler(console_handler)
    return logger


if __name__ == '__main__':
    logger = setup_loggers(LOG_LEVEL_CONSOLE)
    logger.info('info')
    logger.debug('debug')
    logger.warning('warning')

