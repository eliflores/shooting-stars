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

* [Java 8](https://www.java.com/en/download/faq/java8.xml)
* [Spring Boot 1.5.7](https://spring.io/blog/2017/09/12/spring-boot-1-5-7-available-now)

### Libraries
* [Jackson 2.7.3](https://github.com/FasterXML/jackson)
* [Joda Time 2.9.9](http://www.joda.org/joda-time/)