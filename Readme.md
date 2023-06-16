# Task Management System

This project is a Task Management System API built with Java and Spring Boot. It provides user management functionalities, allowing users to register, login, and perform various actions related to task boards and cards.

## Features

- User registration: Users can register in the system with a username and password. The password is stored securely in the database using encryption.
- User login: After successful login, the system generates a bearer token, which should be included in the "Authorization" header of each request for authentication.
- Board management: Users can create, edit, read, and delete boards.
- Card management: Boards can contain one or more cards. Users can add, edit, read, and delete cards. Cards can also be assigned or unassigned to members (users).
- Search functionality: Users can search for cards by card title and filter cards by members.
- Sorting functionality: Users can retrieve cards sorted by the modified on timestamp.

## Technologies Used

- Java
- Spring Boot
- Spring Data MongoDB
- MongoDB
- JWT (JSON Web Tokens)
- Maven

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Docker (for running MongoDB in a container)

### Setup

1. Clone the repository:


2. Navigate to the project directory:


3. Build the application using Maven:


### Running the Application

1. Start the MongoDB container using Docker:


The application will start on http://localhost:8080.

### API Documentation

The API documentation can be accessed using Swagger UI. After running the application, open your web browser and go to http://localhost:8080/swagger-ui.html to view and interact with the API endpoints.

### Configuration

The MongoDB connection details can be configured in the `application.properties` file located in the `src/main/resources` directory. Modify the properties to match your MongoDB setup.


### Usage

Refer to the API documentation for the available endpoints and their usages.

### Contributing

Contributions are welcome! If you find any issues or would like to add new features, please open an issue or submit a pull request.

