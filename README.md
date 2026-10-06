# MaximizeCRM

MaximizeCRM is a Customer Relationship Management (CRM) application developed using **Spring Boot, Java, PostgreSQL, and a web-based frontend**. The system helps manage customers, leads, opportunities, campaigns, activities, and products through REST APIs with JWT-based authentication.

## Project Overview

The main objective of MaximizeCRM is to provide a centralized system for managing customer-related business activities.

The application supports:

- User management
- Customer management
- Lead management
- Opportunity management
- Campaign management
- Activity management
- Product management
- JWT-based authentication
- Input validation
- RESTful APIs
- PostgreSQL database integration
- Swagger/OpenAPI API documentation
- Automated build using GitHub Actions

## Technologies Used

### Backend

- Java 17
- Spring Boot 3.2.5
- Spring Web
- Spring Data JPA
- Spring Security
- JWT Authentication
- Hibernate
- Jakarta Bean Validation
- Lombok
- Maven

### Database

- PostgreSQL 17
- H2 Database for testing

### API Documentation

- Swagger / OpenAPI

### Version Control & CI

- Git
- GitHub
- GitHub Actions

## Project Structure

```text
MaximizeCRM
│
├── .github
│   └── workflows
│       └── maven-build.yml
│
├── database
│   ├── database.yml
│   ├── Project-PPT
│   └── Project-Report
│
├── MaximizeCRM Backend
│   ├── src
│   │   ├── main
│   │   └── test
│   ├── pom.xml
│   └── mvnw
│
└── MaximizeCRM Frontend
```

## Main Modules

### 1. User Management

Manages application users and their basic information.

User roles include:

- Admin
- Sales Executive
- Manager

### 2. Customer Management

Stores and manages customer information such as:

- Customer name
- Email
- Phone
- Address
- City
- Customer type

### 3. Lead Management

Manages potential customers and their requirements.

Lead information includes:

- Lead name
- Email
- Phone
- Lead source
- Lead status
- Requirements
- Assigned user

### 4. Opportunity Management

Manages sales opportunities associated with customers, leads, and users.

Opportunity information includes:

- Title
- Description
- Value
- Status
- Expected closing date

### 5. Campaign Management

Manages marketing and sales campaigns.

Campaign information includes:

- Campaign name
- Description
- Start date
- End date
- Budget
- Campaign status

### 6. Activity Management

Tracks CRM activities such as:

- Calls
- Meetings
- Follow-ups

Activities can be associated with customers, users, and products.

### 7. Product Management

Manages products with information such as:

- Product name
- Description
- Price
- Category
- Stock
- Discount
- Total value

## Authentication

MaximizeCRM uses **JWT (JSON Web Token)** authentication.

The login endpoint generates a JWT token after successful authentication.

Protected API requests require the token in the following format:

```text
Authorization: Bearer <JWT_TOKEN>
```

User registration and authentication endpoints are available without prior authentication.

## Database

The application uses **PostgreSQL** as its primary database.

Database configuration is maintained locally in the Spring Boot application configuration.

The project also contains a `database` folder with the database documentation and project submission materials.

## Running the Backend

### Prerequisites

Make sure the following are installed:

- Java 17
- PostgreSQL
- Git

### Steps

1. Clone the repository:

```bash
git clone https://github.com/Agrima0408/MaximizeCRM.git
```

2. Open the backend directory:

```bash
cd "MaximizeCRM Backend"
```

3. Configure PostgreSQL and create a database named:

```text
MaximizeCRM
```

4. Configure the database username and password in the local Spring Boot configuration.

5. Run the application using Maven Wrapper:

**Windows:**

```bash
.\mvnw spring-boot:run
```

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

The backend runs on:

```text
http://localhost:8081
```

## Swagger API Documentation

After starting the backend, Swagger UI can be accessed at:

```text
http://localhost:8081/swagger-ui/index.html
```

Swagger provides an interactive interface for viewing and testing the REST APIs.

## API Base URL

```text
http://localhost:8081/api
```

The application provides REST endpoints for:

```text
/api/users
/api/customers
/api/leads
/api/opportunities
/api/campaigns
/api/activities
/api/products
/api/auth
```

## Validation and Error Handling

The application uses Jakarta Bean Validation for validating API requests.

Examples include:

- Required fields
- Valid email addresses
- Non-negative numeric values
- Valid enum values

Validation errors are returned with an appropriate **HTTP 400 Bad Request** response.

## Relationships

The application implements relationships between major CRM entities, including:

```text
User ────────< Opportunity
User ────────< Lead
User ────────< Activity

Customer ────< Opportunity
Customer ────< Activity

Lead ────────< Opportunity
Campaign ────< Lead

Activity >────< Product
```

JPA and Hibernate are used to manage these relationships.

## Testing

The backend contains tests for application functionality, validation, authentication, and database-related operations.

H2 is used where an isolated test database is required.

The project can be verified using:

```bash
.\mvnw clean verify
```

## Continuous Integration

GitHub Actions is configured to automatically build and verify the backend whenever changes are pushed to the `main` branch or a pull request is created.

Workflow file:

```text
.github/workflows/maven-build.yml
```

The workflow:

1. Checks out the repository
2. Sets up Java 17
3. Uses Maven caching
4. Builds and verifies the backend

## Project Documentation

Additional project documentation and presentation materials are available in the:

```text
database/
```

folder.

This includes the project database documentation, presentation, and project report.

## Author

**Agrima Agarwal**

## Repository

GitHub Repository:

```text
https://github.com/Agrima0408/MaximizeCRM
```
