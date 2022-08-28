# Spring Cloud Playground
This is a playground for Spring Cloud. It is a simple web application that allows you to experiment with Spring Cloud features.
## Available Environment Variables for deployment

APP_PROFILE [default = 'dev' / exception config-service: 'native']
HOST_NAME [default = 'localhost']

### Discovery Service
- DISCOVERY_SERVICE_URL - [default = 'http://localhost:8760/eureka/']
- DISCOVERY_LEASE_RENEWAL - [default = 1]
- DISCOVERY_LEASE_EXPIRATION - [default = 3]

### Config Service
- CONFIG_SERVICE_MAX_ATTEMPTS - [default = 20]
- CONFIG_SERVICE_MAX_INTERVALL - [default = 10000]
- CONFIG_SERVICE_INITIAL_INTERVALL - [default = 3000]
- CONFIG_SERVICE_MULTIPLIER - [default = 1.3]
