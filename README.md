# Quote-API-with-Rate-Limiting
A Spring Boot REST API that returns motivational quotes with customizable rate limiting. Each endpoint can have its own request limit per IP. Exceeding the configured limit returns a 429 Too Many Requests error.


# Features
- Returns a motivational quote via "/getquote/{requestLimit}" endpoint
- Implements rate limiting.
- Supports custom rate limits per endpoint
- Responds with 429 status code if limit exceeded
- Built using Spring Boot and Java
  # Exceution Process
  In Controller class we are storing ip address and evaluting the timestamps wth this we can count howmant times same ip is requested.
  In service layer there is logic for random quote by using RandomGenerator we achived this.


  # Postman
  End Point
  localhost:8080/getquote/2
   we are passing custom limit.
  when limit excced it will Responds 429 Too many requests.
  
