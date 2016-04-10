[![Build Status](https://travis-ci.org/guliaz/spring-examples.svg?branch=master)](https://travis-ci.org/guliaz/spring-examples)

# Spring Examples

## Spring Cloud Config Server
This guide will help you set up a spring config server and a client application to use the config server. I am using a multiple gradle project here.

So we will start with our gradle dependencies & plugins:
1. plugin `java`
2. plugin `spring-boot`
3. dependency `compile('org.springframework.cloud:spring-cloud-config-server:1.0.3.RELEASE')`
    * Now this should pull in all the spring dependencies we need to get the server running.

Setting our server class:

> SpringConfigServer.java

```java
package com.barley.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigServer.class, args);
    }

}
```

Now to finish up all, we need to set up some resources:

> application.yml

```yml
# Server Port for boot server
server:
  port: 8888

# spring cloud config server git uri
spring:
  cloud:
    config:
      server:
        git:
          uri: here goes your git repo url

# Security enable/disable
security:
  basic:
    enabled: false
```

> bootstrap.yml (need to give the server name as per spring guides)

```yml
spring:
  application:
    name: configserver
```

Now we are all set up. Run the server with `java -jar spring-config-server-1.0.0.jar` and it will serve properties at [http://localhost:8888](http://localhost:8888) from the git repo as per below URIs:
