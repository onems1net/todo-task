# TODO-Task

This application project contains following features...

## 1. Validating the completeness of the brackets i.e. parentheses, brace and square bracket

Access URL: 
protocol://dns:port/test/1.0/validateBrackets
   
Method: POST as GET request doesn't support for brace and square bracket as query parameter

Request body media type: text/plain

Response body media type: application/json

Validation: On the input lenght restrication. Validation error appear in response body

## 2. Add/View/Updaate TODO items

Operation: Add TODO item

Access URL: protocol://dns:port/test/1.0/todo/add
   
Method: POST

Request body media type: application/json

Response body media type: application/json

Validation: On the input lenght restrication. Validation error appear in response body

Operation: View TODO item

Access URL: protocol://dns:port/test/1.0/todo/{id}
   
Method: GET

Response body media type: application/json

Validation: On the validity of the id

Operation: Update TODO item

Access URL: protocol://dns:port/test/1.0/todo/{id}
   
Method: PATCH

Request body media type: application/json

Response body media type: application/json

Validation: On the validity of the id

Application run on following profiles

## 1. test: To run application unit test

## 2. http-https: To host application on both HTTP (8080) and HTTPS (5000) port locally (localhost)

Bracket validation:
```

http://localhost:8080/test/1.0/tasks/validateBrackets

https://localhost:5000/test/1.0/tasks/validateBrackets
```

TODO item addition:
```
http://localhost:8080/test/1.0/todo/add

https://localhost:5000/test/1.0/todo/add
```

## 3. aws-ebs: Profile used to currently host the application on AWS cloud (EBS)

DNS: TodoTask-env.97whddbesp.ap-southeast-2.elasticbeanstalk.com
   
Port: 5000

e.g. the URL for application access on AWS will be
   
Bracket validation:
```   
http://TodoTask-env.97whddbesp.ap-southeast-2.elasticbeanstalk.com/test/1.0/tasks/validateBrackets
```
   
TODO item addition:
```
   
http://todotask-env.97whddbesp.ap-southeast-2.elasticbeanstalk.com/test/1.0/todo/add
```

## Testing: Unit testing are defined using REST Assured and integration testing using Postman

## Incomplete features:

1. Swagger API documentation

2. Endpoint for testing and status check


