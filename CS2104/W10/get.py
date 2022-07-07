import requests
import json

URL = input('Input the URL: ')

x = requests.get(URL,
                headers = {'Accept': 'application/json'})

x_json =  x.json()

print(x_json[0]['body'])


