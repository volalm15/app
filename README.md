# Spring Cloud Playground 

### Service Build Status 
[![Build data-service](https://github.com/volalm15/app/actions/workflows/data-service.yml/badge.svg?branch=main)](https://github.com/volalm15/app/actions/workflows/data-service.yml)
[![Build config-service](https://github.com/volalm15/app/actions/workflows/config-service.yml/badge.svg)](https://github.com/volalm15/app/actions/workflows/config-service.yml)
[![Build discovery-service](https://github.com/volalm15/app/actions/workflows/discovery-service.yml/badge.svg?branch=main)](https://github.com/volalm15/app/actions/workflows/discovery-service.yml)
[![Build edge-service](https://github.com/volalm15/app/actions/workflows/edge-service.yml/badge.svg?branch=main)](https://github.com/volalm15/app/actions/workflows/edge-service.yml)

## How to use?
This is a playground for Spring Cloud. It is a simple web application that allows you to experiment with Spring Cloud features.

### Prerequisites
- Java 17
- Docker
- Docker Compose

After cloning the repository, you can run the application using the following command:
`docker compose --env-file prod.env up`

Don't forget to set the environment variables in the `prod.env` file. You can find the list of required variables in the `prod.env.example` example file.
OAUTH2_DATA_SERVICE_AUDIENCE:http://localhost:8761/data-service

## Available environment variables for deployment provided by microservices
| Variable                         | Description                                | Default value                                                             | Service                    |
|----------------------------------|--------------------------------------------|---------------------------------------------------------------------------|----------------------------|
| APP_PROFILE                      | profile                                    | dev / native (=config service for fetching native config in default mode) | all                        |
| -                                |                                            |                                                                           |                            |
| OAUTH2_ISSUER_URI                | url to oauth2 instance                     | http://localhost:8080                                                     | edge-service, data-service |
| OAUTH2_CLIENT_SECRET             | secret of oauth2 client                    | -                                                                         | edge-service               |
| OAUTH2_CLIENT_ID                 | id of oauth2 client                        | always spring.application.name                                            | edge-service               |
| OAUTH2_DATA_SERVICE_AUDIENCE     | audience of data-service                   | http://localhost:8761/data-service                                        | edge-service, data-service |
| REDIS_URL                        | url for redis instance                     | localhost                                                                 | edge-service               |
| REDIS_PORT                       | port for redis instance                    | 6379                                                                      | edge-service               |
| -                                |                                            |                                                                           |                            |
| DISCOVERY_SERVICE_HOST_NAME      | hostname for discovery service             | localhost                                                                 | discovery-service          |
| DISCOVERY_SERVICE_URL            | url for discovery service                  | http://localhost:8761/eureka                                              | all                        |
| DISCOVERY_LEASE_RENEWAL          | lease renewal interval                     | 1                                                                         | all                        |
| DISCOVERY_LEASE_EXPIRATION       | lease expiration interval                  | 3                                                                         | all                        |
| -                                |                                            |                                                                           |                            |
| CONFIG_SERVICE_MAX_ATTEMPTS      | max attempts for config service fetch      | 20                                                                        | all                        |
| CONFIG_SERVICE_MAX_INTERVALL     | max intervall for config service fetch     | 10000                                                                     | all                        |
| CONFIG_SERVICE_INITIAL_INTERVALL | initial intervall for config service fetch | 3000                                                                      | all                        |
| CONFIG_SERVICE_MULTIPLIER        | multiplier for config service fetch        | 1.3                                                                       | all                        |


### ⚡Docker Environment Instances
