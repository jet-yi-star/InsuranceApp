This is a POC (proof of concept) project, which demonstrates capabilities of migrating Monolithic architecture to Microservices architecture using Spring Boot, Spring Cloud, AWS, Kafka and etc.

Functional services

  InsuranceApp was decomposed into several core microservices. All of them are independently deployable application, organized around certain business domains

  CRUD services

Method	Path	Description
  
  GET	/users/{username}/todos	Get all the items of this user
  GET	/users/{username}/todos/{id}	Get specific item of this user

DELETE /users/{username}/todos/{id} Delete specific item of this user

PUT /users/{username}/todos/{id} Edit specific item of this user

POST	/users/{username}/todos	Register new item	of this user

Authentication service

Basic Auth  Get /basicauth

OAuth 

POST /authenticate Create Authentication Token

GET /refresh Refresh and Get Authentication Token

Then use Spring Security to implement resource control.

Infrastructure services

Spring Cloud provides powerful tools that enhance Spring Boot applications behaviour to implement those pattern.

  Auth service
    
     Authorization responsibilities are completely extracted to separate server, which grants OAuth2 tokens for the backend resource services.
     Auth Server is used for user authorization as well as for secure machine-to-machine communication inside a perimeter.
     
    
