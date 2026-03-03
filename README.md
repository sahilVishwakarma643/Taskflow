# TaskFlow Backend

## Overview

TaskFlow is a backend-focused Spring Boot application designed with
strict architectural discipline.\
While it functionally supports CRUD operations, the primary goal of this
project is to demonstrate:

-   Strong domain modeling
-   Controlled state transitions
-   Explicit behavior over raw mutation
-   Clear separation of responsibilities
-   Boundary-safe API design

This project reflects production-level backend engineering principles
rather than a naive CRUD implementation.

------------------------------------------------------------------------

## Architecture Philosophy

### Layered Separation

**Controller Layer** - Handles HTTP concerns only - Accepts Request
DTOs - Returns Response DTOs - Contains no business logic

**Service Layer** - Coordinates use cases - Manages transactions -
Delegates rule enforcement to the domain - Does not bypass domain
invariants

**Domain Layer (Entity-Centric)** - Entities protect their own
lifecycle - Illegal state transitions are prevented internally -
Explicit behavior methods replace uncontrolled setters - Critical fields
are not publicly mutable

**Repository Layer** - Handles persistence only - Contains no business
rules

------------------------------------------------------------------------

## Core Domain Model

-   **Task (Aggregate Root)**
-   **Status Enum**: TODO → IN_PROGRESS → DONE
-   Explicit state transition methods inside the entity
-   Domain-specific exceptions for invalid lifecycle operations

Lifecycle rules are enforced at the entity level to prevent illegal
state mutation.

------------------------------------------------------------------------

## API Boundary Discipline

-   Entities are never exposed directly
-   Request DTOs define allowed inputs
-   Response DTOs define exposed outputs
-   Sensitive fields cannot be client-controlled

DTOs represent boundary contracts, not domain models.

------------------------------------------------------------------------

## Exception Handling

-   Custom domain exceptions
-   Centralized GlobalExceptionHandler
-   Structured and consistent error responses
-   HTTP status codes reflect business intent

------------------------------------------------------------------------

## Transaction Management

-   Transactions managed at the service layer
-   Domain logic independent of transaction boundaries
-   Repositories strictly responsible for data access

------------------------------------------------------------------------

## Filters & Interceptors Awareness

-   Filters protect request boundaries
-   Interceptors observe application flow
-   Security handled at boundary level
-   Business rules remain inside the domain

------------------------------------------------------------------------

## Project Structure

controller/\
service/\
domain/\
enums/\
repository/\
dto/\
exception/\
config/\
filter/\
interceptor/

Each package maintains a single responsibility and avoids cross-layer
leakage.

------------------------------------------------------------------------

## Technologies Used

-   Java
-   Spring Boot
-   Spring Data JPA
-   Hibernate
-   MySQL
-   Spring Security (configurable)
-   Maven

------------------------------------------------------------------------

## Why This Project Matters

This project demonstrates:

-   Domain-driven backend design
-   Lifecycle protection inside entities
-   Controlled mutation principles
-   Clear architectural boundaries
