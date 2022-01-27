# Spring-boot bootstrap project

This project is based
on [Clean Architecture](https://techsophysol.sharepoint.com/sites/TechsophyDeveloperNetwork/technology/SitePages/Clean.aspx)
concept.

## Project structure

* application - All the incoming requests like REST, GraphQL, gRPC, incoming
  events etc
* config - Application configuration
* core - Core business logic. This section will contain domain and the service
  with core business logic
* exception - Application/ Custom exception
* repository - External Repositories. Implement repositories as required
* util - Utility functions

## Unit testing

To run unit tests set `database.memory` to `true`

## Access endpints

### Save customer

```
curl --request POST \
--header "Content-Type: application/json" \
--data '{"firstName":"firstName", "middleName":"middleName","lastName":"lastName", "email":"email@demo.com"}' \
http://localhost:8080/v1/customers/
```

### Get customer by ID

```
curl --request GET \
'http://localhost:8080/v1/customers/customer/:id'
```

### Fetch all customers

```
curl --request GET \
'http://localhost:8080/v1/customers/?page=1&size=10&sort=firstName%20asc'
```

### Delete customer by ID

```
curl --request DELETE \
'http://localhost:8080/v1/customers/customer/:id'
```