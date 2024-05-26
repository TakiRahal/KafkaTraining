from kafka import KafkaProducer
import json
from data import get_registered_user
import time

def json_serialize(data):
    return json.dumps(data).encode('utf-8')

producer = KafkaProducer(bootstrap_servers)