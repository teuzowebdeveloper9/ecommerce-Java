# E-commerce Application with Many-to-Many Relationship

## Overview

This Java application is an example of implementing a many-to-many relationship in a Spring Boot e-commerce project. It's designed to demonstrate the interaction between users, products, and orders, showcasing how to handle complex relationships in a real-world scenario.

## Key Features

- Many-to-many relationship between Users and Products
- Order management system
- RESTful API endpoints for Users, Products, and Orders
- PostgreSQL database integration
- Docker support for easy database setup

## Project Structure

The project is organized into the following main packages:

- `src/main/java/ecommerce/cache`
  - `entitys`: Contains entity classes (User, Product, Order)
  - `enums`: Enumerations used in the project
  - `services`: Service layer for business logic
  - `repositories`: Data access layer using Spring Data JPA
  - `DTOS`: Data Transfer Objects for API requests/responses
  - `controller`: REST controllers for handling HTTP requests

## Entities

1. **User**: Represents customers who can place orders
2. **Product**: Represents items available for purchase
3. **Order**: Manages the relationship between Users and Products, representing a purchase

## Learning Experience

This project was my first attempt at implementing a many-to-many relationship in a Spring Boot application. I encountered and overcame several challenges:

1. **Infinite Loop in API Responses**: Initially, when making GET requests to the `/users` endpoint, the API would enter an infinite loop, repeatedly returning the same product information. This was due to circular references in the JSON serialization process.

   **Solution**: I learned to use Jackson annotations like `@JsonManagedReference` and `@JsonBackReference` to properly manage bidirectional relationships and prevent infinite recursion.

2. **Complex Relationship Handling**: Managing the relationships between Users, Products, and Orders required careful consideration of database design and entity mappings.

   **Solution**: I implemented a junction table (`order_relation`) to manage the many-to-many relationship between Users and Products, with the Order entity serving as an intermediary.

## Database Setup

This project uses PostgreSQL as its database. To simplify the setup process, a Docker configuration is provided.

### Using Docker

1. Navigate to the `src/main/resources/docker` directory
2. Run `docker-compose up -d` to start the PostgreSQL container
3. The database will be accessible on localhost:5432

### Database Configuration

The `application.properties` file contains the necessary configuration for connecting to the PostgreSQL database:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=teuzo
spring.datasource.password=ecommerce
Running the Application
Ensure you have Java 21 and Maven installed
Start the PostgreSQL database (using Docker or a local installation)
Run mvn spring-boot:run in the project root directory
The application will start and be accessible at http://localhost:8080
API Endpoints
/users: User management
/products: Product management
/orders: Order processing
Each endpoint supports standard CRUD operations (GET, POST, etc.)

```

## Database Setup

Implement authentication and authorization
Add more comprehensive error handling
Expand test coverage
Implement caching for frequently accessed data
Conclusion
This project served as an excellent learning experience in handling complex database relationships in a Spring Boot application. It demonstrates practical solutions to common challenges in building e-commerce backends, such as managing circular dependencies and implementing many-to-many relationships.

## Feature: Caching Popular Products with Redis

To improve the performance and responsiveness of the application, I implemented a caching layer for popular products using Redis. This feature reduces the number of database queries by storing frequently accessed product data in the Redis cache.

### How It Works

- When a request for popular products is made, the application first checks the Redis cache.
- If the data is available in the cache, it is returned immediately, significantly reducing response time.
- If the data is not in the cache, the application queries the database, stores the result in Redis, and then returns the data.
- The cache is periodically refreshed or invalidated to ensure data consistency.

### Benefits

- Reduced database load and faster API responses
- Improved scalability for handling high traffic
- Demonstrates integration of Redis with Spring Boot for effective caching

This caching feature is a key optimization for enhancing user experience when browsing popular products.

## Swagger UI Implementation

### Overview

As part of improving the documentation and usability of our API, I've implemented Swagger UI in this project. This marks my first experience with creating a Swagger interface, which has been an exciting learning opportunity.

### What is Swagger UI?

Swagger UI is an open-source tool that generates a user-friendly interface for documenting and testing RESTful APIs. It provides a visual representation of the API's structure, allowing developers to understand and interact with the API's endpoints without needing to delve into the code.

### Importance of Swagger UI

1. **API Documentation**: It offers clear, interactive documentation for all API endpoints.
2. **Testing Interface**: Developers can test API calls directly from the browser.
3. **Reduces Onboarding Time**: New team members can quickly understand the API structure.
4. **Standardization**: It helps in maintaining a standard structure for API documentation.
5. **Client SDK Generation**: Swagger can auto-generate client SDKs for various programming languages.

### How to Use Swagger UI in This Project

1. Start the application as described in the "Running the Application" section.
2. Open a web browser and navigate to `http://localhost:8080/swagger-ui.html`.
3. You'll see a list of all available API endpoints grouped by controller.
4. Click on an endpoint to expand it and view detailed information.
5. You can try out API calls directly from this interface by clicking the "Try it out" button.

### Learning Experience

Implementing Swagger UI for the first time was both challenging and rewarding. Key learnings include:

- Understanding how to configure Swagger in a Spring Boot application.
- Learning to use annotations to provide detailed API documentation.
- Gaining insights into best practices for API documentation.
