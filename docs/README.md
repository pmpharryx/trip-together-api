# Trip Together API Services

A Spring Boot API services for the Trip Together application, facilitating group travel planning and coordination.

## Table of Contents

- [Project Structure](#project-structure)
  - [Top-level Structure](#top-level-structure)
  - [Documentation and Design](#documentation-and-design)
  - [Source Code](#source-code)
  - [Application Configuration](#application-configuration)
  - [Test Script](#test-script)
- [Installation](#installation)
- [Usage](#usage)

---

## Project Structure

This project has an organized project structure, let explore their information below.

### Top-level Structure

A brief overview of the main components found in the root directory of the project.

    .
    ├── .mvn                                    # Maven configuration files
    ├── docs                                    # Documentation and design files
    ├── src                                     # Source code and test script files
    ├── target                                  # Compiled and packaged files
    ├── .gitignore                              # Specifies intentionally untracked files that Git should ignore
    ├── mvnw                                    # Maven wrapper Unix executable script
    ├── mvnw.cmd                                # Maven wrapper Windows command script
    └── pom.xml                                 # Information about the project and configuration details

### Documentation and Design

A centralized location for all project documentation, including data descriptions, design diagrams, guidelines, 
and specifications.

**Directory:** `./docs`

    docs
    │
    ├── data                                    # Project's data related information
    │   ├── data-dictionary.md                  # Detailed description of data entities and their attributes
    │   └── database-schema.md                  # SQL script defining the database schema for all data entities
    │
    ├── design                                  # Project's design diagram files
    │   ├── entity-relationship-diagram.md      # Diagram illustrating entity relationships
    │   └── sequence-diagram.md                 # Diagram illustrating sequence of each API actions
    │
    ├── guideline                               # Project's design and development guideline files
    │   ├── git-commit-convention.md            # Guidelines for writing Git commit messages
    │   └── git-workflow.md                     # Guidelines for managing Git workflows
    │
    ├── specification                           # Project's technical specification files
    │   ├── api-specification.yaml              # Swagger API specification
    │   └── response-code.md                    # List of all services response codes and meanings
    │
    └── README.md                               # Project's main overview information file

### Source Code

Adopting a **package-by-feature** approach organizes the source code to enhance modularity and scalability. 
Each feature package encapsulates its specific components, such as constants, controllers, DTOs, models, repositories, 
services, and validators, making the codebase easier to navigate and maintain. Shared components are centralized in the 
`common` package to avoid duplication and ensure consistency across features.

This design promotes **high cohesion** and **low coupling**, where each feature is self-contained with closely related 
functionalities, reducing dependencies between features and improving maintainability and flexibility.

**Directory:** `./src/main/java/com/triptogether/api`

    src/main/java/com/triptogether/api
    │
    ├── common                                  # Shared components package
    │   ├── constant                            # Globally used constants
    │   ├── dto                                 # Shared data transfer objects
    │   ├── model                               # Shared data models/entities
    │   ├── repository                          # Repositories for common operations
    │   ├── utility                             # Utility classes and helper functions
    │   └── validator                           # Shared validators
    │
    ├── feature1                                # Components package specific to Feature 1
    │   ├── constant                            # Constants specific to Feature 1
    │   ├── controller                          # Controllers handling requests for Feature 1
    │   ├── dto                                 # Data transfer objects specific to Feature 1
    │   ├── model                               # Data models/entities specific to Feature 1
    │   ├── repository                          # Repositories for models/entities specific to Feature 1
    │   ├── service                             # Service layer containing business logic for Feature 1
    │   └── validator                           # Validators specific to Feature 1
    │
    ├── feature2                                # Components package specific to Feature 2
    │   ├── constant                            # Constants specific to Feature 2
    │   ├── controller                          # Controllers handling requests for Feature 2
    │   ├── dto                                 # Data transfer objects specific to Feature 2
    │   ├── model                               # Data models/entities specific to Feature 2
    │   ├── repository                          # Repositories for models/entities specific to Feature 2
    │   ├── service                             # Service layer containing business logic for Feature 2
    │   └── validator                           # Validators specific to Feature 2
    │
    ├── ...                                     # Other feature packages following the same structure
    │
    └── TripTogetherApiApplication.java         # Main application class file

### Application Configuration

A centralized location for application properties and configurations.

**Directory:** `./src/main/resources`

    src/main/resources
    │
    └── application.yaml                        # Main application configuration file

### Test Script

A centralized location for unit test scripts for testing individual units or components of the application in isolation.

The structure keeps test files organized and easy to locate, with each test package corresponding to its respective 
source package. Each test package contains tests for the components within that package, such as controllers, services, 
repositories, validators, etc.

**Directory:** `./src/test/java/com/triptogether/api`

    src/test/java/com/triptogether/api
    │
    ├── common                                  # Tests for shared components
    │
    ├── feature1                                # Tests for components in Feature 1
    │
    ├── feature2                                # Tests for components in Feature 2
    │
    ├── ...                                     # Tests for components in other features
    │
    └── TripTogetherApiApplicationTests.java    # Tests for main application class

---

## Installation

> **⚠️ Note:** This section is under construction 🚧.

---

## Usage

> **⚠️️️ Note:** This section is under construction 🚧.

---