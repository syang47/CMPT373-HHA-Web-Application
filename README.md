# CMPT 373: Hope Health Action

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
## Project Introduction

**[Hope Health Action](https://www.hopehealthaction.org/)** has been working with Haiti, supporting the hospitals believing that every person has the right to quality health-case without discrimination. 
However, there are still hardships, such as storing data on paper and difficulty collecting stories. Our team will be building a web application for staff members of Hope Health Action.
This application will focus on easing the process of storing, verifying, and analyzing MSPP related data, providing consistency between departments, and collecting/showcasing impactful stories.
We will also implement a leaders board as a fun way for staff between departments to interact with each other.


## Directory Structure

This project is split into two main parts: the front-end and back-end.

The back-end will be using a Spring framework implemented in Java coupled with JPA Repositories stored in an external database.

The front-end will be implemented Vue.js alongside Typescript as the framework for the application.

## Build Directions (and Dependencies)
To build the project and produce a .jar file:

If you already ran 'npm install', skip to step 2.

1.Go to the front-end and install all dependencies needed to run the Vue application.More specifically:

    $ cd /prj/front-end
    $ npm install

2.Now you can use the build.gradle file which produces a .jar.

    $ cd ..
    $ cd back-end
    $ ./gradlew build

## Run Instructions

Assuming the user is in the back-end folder:

    $ java -jar ./build/libs/app.jar

or if you want to run back end and front end separately:

    1. go to back-end, build gradle and run \src\main\java\hha\website\Application.java
    2. go to front-end folder in terminal and type "npm run serve"

hard-coded users:

1. admin with username: *admin* and password: *admin* with role *ROLE_ADMIN*

Currently uses in-memory authentication, but need to switch to external database (MySQL, MS-SQL).


