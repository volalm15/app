# Spring Cloud Playground 

### Service Build Status 
[![Build data-service](https://github.com/volalm15/app/actions/workflows/data-service.yml/badge.svg?branch=main)](https://github.com/volalm15/app/actions/workflows/data-service.yml)
[![Build config-service](https://github.com/volalm15/app/actions/workflows/config-service.yml/badge.svg)](https://github.com/volalm15/app/actions/workflows/config-service.yml)
[![Build discovery-service](https://github.com/volalm15/app/actions/workflows/discovery-service.yml/badge.svg?branch=main)](https://github.com/volalm15/app/actions/workflows/discovery-service.yml)
[![Build edge-service](https://github.com/volalm15/app/actions/workflows/edge-service.yml/badge.svg?branch=main)](https://github.com/volalm15/app/actions/workflows/edge-service.yml)

## How to use?
This is a playground for Spring Cloud. It is a simple web application that allows you to experiment with Spring Cloud features.

## Available environment variables for deployment
| Variable                         | Description                                | Default value                                                             | Service                    |
|----------------------------------|--------------------------------------------|---------------------------------------------------------------------------|----------------------------|
| APP_PROFILE                      | profile                                    | dev / native (=config service for fetching native config in default mode) | all                        |
|                                  |                                            |                                                                           |                            |
| KEYCLOAK_URL                     | url to keycloak instance                   | http://localhost:8080                                                     | edge-service, data-service |
| KEYCLOAK_CLIENT_SECRET           | secret of keycloak client                  | -                                                                         | edge-service               |
| KEYCLOAK_CLIENT_ID               | id of keycloak client                      | always spring.application.name                                            | edge-service               |
| REDIS_URL                        | url for redis instance                     | localhost                                                                 | edge-service               |
| REDIS_PORT                       | port for redis instance                    | 6379                                                                      | edge-service               |
|                                  |                                            |                                                                           |                            |
| DISCOVERY_SERVICE_HOST_NAME      | hostname for discovery service             | localhost                                                                 | discovery-service          |
| DISCOVERY_SERVICE_URL            | url for discovery service                  | http://localhost:8761/eureka                                              | all                        |
| DISCOVERY_LEASE_RENEWAL          | lease renewal interval                     | 1                                                                         | all                        |
| DISCOVERY_LEASE_EXPIRATION       | lease expiration interval                  | 3                                                                         | all                        |
|                                  |                                            |                                                                           |                            |
| CONFIG_SERVICE_MAX_ATTEMPTS      | max attempts for config service fetch      | 20                                                                        | all                        |
| CONFIG_SERVICE_MAX_INTERVALL     | max intervall for config service fetch     | 10000                                                                     | all                        |
| CONFIG_SERVICE_INITIAL_INTERVALL | initial intervall for config service fetch | 3000                                                                      | all                        |
| CONFIG_SERVICE_MULTIPLIER        | multiplier for config service fetch        | 1.3                                                                       | all                        |


### ⚡Docker Environment Instances
| Variable                   | Description                             | Default value                                                             | Service                    |
|----------------------------|-----------------------------------------|---------------------------------------------------------------------------|----------------------------|
| KEYCLOAK_POSTGRES_USER     | postgres user for keycloak instance     | admin                                                                     | keycloak-instance          |
| KEYCLOAK_POSTGRES_PASSWORD | postgres password for keycloak instance | changeit                                                                  | keycloak-instance          |
| KEYCLOAK_ADMIN_USER        | default user for keycloak instance      | admin                                                                     | keycloak-instance          |
| KEYCLOAK_ADMIN_PASSWORD    | default password for keycloak instance  | admin                                                                     | keycloak-instance          |

