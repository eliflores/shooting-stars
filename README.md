# Shooting Stars

This repository contains the Backend for the `Shooting Stars` app that we built for the [Hack Like a Girl Hackathon]
(http://www.hacklikeagirl.co/).

Our Front-end code is located [here](https://github.com/mignonnesaurus/shooting-stars-web).

# How to play with our back-end.
1. Add your own API key:
    `cp src/main/resources/application.properties.sample src/main/resources/application.properties`
    
2. Request Mapping:
    `<SERVER_URL:PORT>/options?lat=<LATITUDE>&long=<LONGITUDE>&date=<DATE_IN_yyyy_MM_dd_FORMAT>`
    
    
## Tech Stack

* Java 8
* Spring Boot 1.5.7