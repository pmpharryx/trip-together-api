# Trip Together API Services

A Spring Boot API services for the Trip Together application, facilitating group travel planning and coordination.

## Table of Contents

- [Installation Guide](#installation-guide)
  - [Prerequisites](#prerequisites)
  - [Steps to Install](#steps-to-install)
  - [Troubleshooting](#troubleshooting)
- [Documentation](#documentation)

---

## Installation Guide

This section provides a step-by-step guide to install and set up the Trip Together API services project in Spring Boot 
using Maven. Follow the instructions below to get started.

### Prerequisites

Before you begin, ensure you have the following installed on your machine:

1. **Java Development Kit (JDK) 22**: You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html).
2. **Git**: You can download it from [Git's official website](https://git-scm.com/downloads).

### Steps to Install

1. **Clone the repository**:

    ```sh
    git clone https://github.com/pmpharryx/trip-together-api.git
    cd trip-together-api
    ```

2. **Build the project**:

    - On Unix-based systems (Linux, macOS):

    ```sh
    ./mvnw clean install
    ```

    - On Windows:
    
    ```sh
    mvnw.cmd clean install
    ```

3. **Run the application**:

    - On Unix-based systems (Linux, macOS):

    ```sh
    ./mvnw spring-boot:run
    ```
    
    - On Windows:

    ```sh
    mvnw.cmd spring-boot:run
    ```

4. **Access the application**:

    - Once the application is running, the API service will be available at: `http://localhost:8080`

### Troubleshooting

- **Port Conflicts**: If the default port 8080 is already in use, you can change it in the `application.yaml` file:

    ```yaml
    server:
      port: 8081
    ```

- **Maven Issues**: Ensure that your `JAVA_HOME` environment variable is set correctly.

For any further assistance, please refer to the [Spring Boot Documentation](https://spring.io/projects/spring-boot) 
or raise an issue in the repository.

---

## Documentation

- Development Guideline
  - [Project Structure](guideline/project-structure.md)
  - [Git Workflow](guideline/git-workflow.md)
  - [Git Commit Convention](guideline/git-commit-convention.md)
- Technical Specification
  - [API Specification](http://localhost:8080/swagger-ui) (Accessible after running the application)
  - [Response Code](specification/response-code.md)
- Design
  - [Sequence Diagram](design/sequence-diagram.md)
  - [Entity Relationship Diagram](design/entity-relationship-diagram.md)
- Data
  - [Data Dictionary](data/data-dictionary.md)
  - [Database Schema](data/database-schema.md)

---