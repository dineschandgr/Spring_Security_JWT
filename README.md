# Spring_Security_JWT
Spring Boot, Spring Security using JWT


Requirements

1. Download the pom.xml to download all the required dependencies
2. Create 2 tables in mysql DB named Users and Authorities
3. 2 Entity classes are used for persistence
4. Users and Authorities have one to many mapping


Steps to execute

1. Make a post request to localhost:8080/authenticate using postman with the application/json header and body as
{
  username:user
  password:pass
}
2. Once the user credentials are authenticated with database values, the JWT token is generated by the method  jwtTokenUtil.generateToken
3. Then the JWT is sent in the response in the format eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
7. Then make a get request to localhost:8080/hello with the following header
key :Authorization_Header
value : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

8. Now the JwtrequestFilter intercepts the request and obtains the JWT from the authorization header
9. Then the extracted JWT is validated with the wtUtil.validateToken(jwt, userDetails) method in the filter
10. Once validated, the filter chaining continues and the user can access other urls as the JWT is validated
11. This JWT validation is doe only once per request by the JwtrequestFilter as it extends OncePerRequestFilter
12. The Application is made stateless in the configure(HttpSecurity http) method of SecurityConfiguration class
13. This will enable the application not to store session id. Instead it is the responsibility of the client to send the signed JWT every time to the server