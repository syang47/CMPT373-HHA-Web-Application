To run project, make sure you are in "back-end" folder, then type

    1. ./gradlew build
    2. java -jar ./build/libs/app.jar

or if you want to run back end and front end separately:

    1. go to back-end, build gradle and run \src\main\java\hha\website\Application.java
    2. go to front-end folder in terminal and type "npm run serve"

hard-coded users:

1. admin with username: *admin* and password: *admin* with role *ROLE_ADMIN*

If you want to register new users, use terminal (or postman) until we have register page:

    curl -i -H "Content-Type: application/json" -X POST -d '{"username": "username","password": "password","role": "ROLE_USER"}' localhost:8080/api/register

After a user is registered, must access **/api/login** to get JWT:

    curl -i -H "Content-Type: application/json" -X POST -d '{"username": "username","password": "password"}' localhost:8080/api/login

Then you can access **localhost:8080/user** using this:

    curl -i -H "Authorization: Bearer INSERT JWT HERE" -X GET localhost:8080/api/user

e.g. 

    curl -i -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzQWRtaW4iOnRydWUsImV4cCI6MTYzMzQwOTIwNywiaWF0IjoxNjMzNDA1NjA3fQ.8dpK_-L6HpkKZrilSED5GjQKXi-px8s35ZAEgBhp_3g" -X GET localhost:8080/api/user


Currently uses in-memory authentication, but need to switch to external database (MySQL, MS-SQL) once we get VM working.

