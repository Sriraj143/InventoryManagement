Inventory Search Management System
Overview

This application provides a Search API for an Inventory Management System. The API allows users to search inventory records based on multiple optional filter criteria.

The application is built using:

Java 17
Spring Boot
Spring Data JPA
PostgreSQL
Maven
Problem Statement

Develop a search service that returns inventory records matching user-provided filter criteria.

Search Requirements
All search parameters are optional.
Users may search using one or more parameters.
Multiple filters are applied using AND conditions.
If no filter is provided, all inventory records are returned.
Pagination support is provided.
Design Approach
Layered Architecture

The application follows a standard layered architecture:

Controller Layer

Responsible for:

Receiving HTTP requests
Validating request parameters
Returning API responses
Service Layer

Responsible for:

Business logic
Constructing search criteria
Interacting with the repository layer
Repository Layer

Responsible for:

Database interaction
Executing queries using Spring Data JPA
Entity Layer

Represents database tables as Java objects.

DTO Layer

Used to transfer search filter data between layers.

API Design
Search Inventory

Method: GET

Endpoint:

/api/inventory/search

Sample Request

/api/inventory/search?category=Electronics&brand=Samsung&page=0&size=10

Supported Filters
Parameter	Description
name	Inventory Name
category	Category
subCategory	Sub Category
seller	Seller Name
location	Inventory Location
brand	Brand Name
model	Model Name
minPrice	Minimum Price
maxPrice	Maximum Price
minStock	Minimum Stock
maxStock	Maximum Stock

All parameters are optional.

Pagination

Pagination is implemented using Spring Data Page and Pageable.

Example:

/api/inventory/search?page=0&size=10

Where:

page = page number
size = number of records per page
Database Design
Inventory Table
Column
id
name
category
sub_category
manufacturing_date
expiry_date
specification
price
stock
model
seller
location
brand
status
Assumptions
Inventory ID is auto-generated.
All filters are optional.
Search is case-sensitive unless specified otherwise.
Pagination is enabled.
PostgreSQL is used as the database.
Error Handling

Global exception handling is implemented using:

@RestControllerAdvice

Handled scenarios:

Invalid request parameters
Database exceptions
Internal server errors
Validation

Basic validation is performed on incoming request parameters.

Examples:

Price values must be positive.
Stock values must be non-negative.
Testing

API testing was performed using Postman.

Test Scenarios:

Fetch all inventory records.
Search by category.
Search by brand.
Search by price range.
Search using multiple filters.
Pagination verification.
