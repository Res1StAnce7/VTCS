import requests
import json

post = input("Input a message: ")
set = {"Message": post}
json_dump = json.dumps(set)
json_object = json.loads(json_dump)

url = 'https://posthere.io/ab8d-4b0d-8cca'
x = requests.post(url, data = json_object)