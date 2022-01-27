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

## In  this application
* _ICustomRestServicePort_ is an input REST adapter
* _ICustomerService_ is an interface that exposes core service
* _ICustomRepositoryPort_ is an interface which defines how the service will 
  interact with a repository
* _InMemoryCustomerRepositoryPort_ is an implementation of memory repository

The _ICustomerController_ exposes four REST service
* `/v1/customers` (POST with json body) -> Add a customer
* `/v1/customers` (GET) -> Fetch all customers
* `/v1/customers/customer/{id}` (GET) -> Fetch customer by ID
* `/v1/customers/customer/{id}` (DELETE) -> Delete customer by ID


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