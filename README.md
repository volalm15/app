# Spring Cloud Playground 
### Service Build Status 
[![Build data-service](https://github.com/volalm15/app/actions/workflows/data-service.yml/badge.svg)](https://github.com/volalm15/app/actions/workflows/data-service.yml)
[![Build config-service](https://github.com/volalm15/app/actions/workflows/config-service.yml/badge.svg)](https://github.com/volalm15/app/actions/workflows/config-service.yml)
[![Build discovery-service](https://github.com/volalm15/app/actions/workflows/discovery-service.yml/badge.svg)](https://github.com/volalm15/app/actions/workflows/discovery-service.yml)
[![Build edge-service](https://github.com/volalm15/app/actions/workflows/edge-service.yml/badge.svg)](https://github.com/volalm15/app/actions/workflows/edge-service.yml)

This is a playground for Spring Cloud. It is a simple web application that allows you to experiment with Spring Cloud features.
## How to use?
## Available Environment Variables for deployment

APP_PROFILE [default = 'dev' / exception config-service: 'native']
HOST_NAME [default = 'localhost']

### ⚡Edge Service
- KEYCLOAK_URL - [default = 'http://localhost:8080']
- KEYCLOAK_CLIENT_SECRET
 Discovery Service
- DISCOVERY_SERVICE_URL - [default = 'http://localhost:8760/eureka/']
- DISCOVERY_LEASE_RENEWAL - [default = 1]
- DISCOVERY_LEASE_EXPIRATION - [default = 3]

 ### ⚡Config Service
- CONFIG_SERVICE_MAX_ATTEMPTS - [default = 20]
- CONFIG_SERVICE_MAX_INTERVALL - [default = 10000]
- CONFIG_SERVICE_INITIAL_INTERVALL - [default = 3000]
- CONFIG_SERVICE_MULTIPLIER - [default = 1.3]

### ⚡Keycloak Docker
- KEYCLOAK_POSTGRES_USER
- KEYCLOAK_POSTGRES_PASSWORD
- KEYCLOAK_ADMIN_USER
- KEYCLOAK_ADMIN_PASSWORD
