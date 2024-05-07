## Compiled using java 21

## Database
- Before running the app : ensure that there's database schema called 'bank'
- username: root and password : password
- using liquibase: We will create a table and add one entry

## Dependencies
- Swagger : for the end point to be access using the browser. 
- After running the application successfully, can check if the swagger is accessible - http://localhost:8484/swagger-ui/index.html#/
- Also added actuator dependency that can be used for monitoring. Once the app is running, you can check the health check here - http://localhost:8484/actuator

## To Test
- run this curl command:
- curl -X 'PUT' \
  'http://localhost:8484/bank/withdraw?accountId=1000025362&amount=1' \
  -H 'accept: */*'
  
  
## Improvement needed
- add unit test
- improve error handling
- add the reason and the code why failed or successfully. 
