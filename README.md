# CMPT 373: Hope Health Action
Group Project 

<br/>

## Team Members + Roles (for Project Iteration 1)
 - **[Dr. Brian Fraser](mailto:bfraser@sfu.ca)** *as the Instructor*
 - **[Navid Rahimi](mailto:navidr@sfu.ca)** *as Teaching Assistant*
 - **[Aliasghar Khani](mailto:aka225@sfu.ca)** *as Teaching Assistant*
 - **[Pranjal Keshari](mailto:pkeshari@sfu.ca)** *as the Scrum Master*
 - **[Li Liang](mailto:lianglil@sfu.ca)** *as a Repo Manager*
 - **[Justin Gregg](mailto:jmgregg@sfu.ca)** *as the Product Owner*
 - **[Shan Ying Yang](mailto:syy7@sfu.ca)** *as the Team Member*
 - **[Brandon Ong](mailto:bong@sfu.ca)** *as the Team Member*
 - **[ZiYang Jiang](mailto:zyjiang@sfu.ca)** *as the Team Member*

 
<br/>


To run project, make sure you are in "back-end" folder, then type

    1. ./gradlew build
    2. java -jar ./build/libs/app.jar

or if you want to run back end and front end separately:

    1. go to back-end, build gradle and run \src\main\java\hha\website\Application.java
    2. go to front-end folder in terminal and type "npm run serve"

hard-coded users:

1. admin with username: *admin* and password: *admin* with role *ROLE_ADMIN*
2. admin with username: *user* and password: *user* with role *ROLE_USER*

There are two endpoints only registered users can see: **localhost:8080/admin** and **localhost:8080/user**

For testing purposes, admin can access these two endpoints, but user cannot access /admin endpoint.

If you want to register new users, use terminal (or postman) until we have register page:

    curl -i -H "Content-Type: application/json" -X POST -d '{"username": "username","password": "password","role": "ROLE_USER"}' localhost:8080/api/register

After a user is registered, must access **/api/login** to get JWT:

    curl -i -H "Content-Type: application/json" -X POST -d '{"username": "username","password": "password"}' localhost:8080/api/login

Then you can access **localhost:8080/user** using this:

    curl -i -H "Authorization: Bearer INSERT JWT HERE" -X GET localhost:8080/api/user

e.g. 

    curl -i -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzQWRtaW4iOnRydWUsImV4cCI6MTYzMzQwOTIwNywiaWF0IjoxNjMzNDA1NjA3fQ.8dpK_-L6HpkKZrilSED5GjQKXi-px8s35ZAEgBhp_3g" -X GET localhost:8080/api/user

This should return a data in response object saying "User Content."

Currently uses in-memory authentication, but need to switch to external database (MySQL, MS-SQL) once we get VM working.


