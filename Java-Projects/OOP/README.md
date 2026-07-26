# Library Management System

A console-based **Library Management System** developed using **Core Java** to practice Object-Oriented Programming (OOP), the Java Collections Framework, and clean project organization.

The application simulates the core operations of a library, including managing books, registering members, borrowing and returning books, and maintaining borrowing history. The project focuses on applying Java fundamentals to a real-world scenario through modular design and business logic implementation.

---

## Features

- Register and manage library members
- Add, update, search, and remove books
- Borrow and return books
- Track borrowing history for each member
- Prevent duplicate or invalid operations through input validation
- Maintain book availability using an enum-based status system
- Organize business logic using a service-oriented design

---

## Tech Stack

- **Language:** Java
- **Core Concepts:** Object-Oriented Programming (OOP)
- **Collections:** ArrayList
- **IDE:** Eclipse
- **Version Control:** Git & GitHub

---

## OOP Concepts Implemented

- Classes and Objects
- Encapsulation
- Constructors
- Composition
- Enums
- Static Members
- Method Overloading
- Object Relationships
- Separation of Concerns
- Modular Package Structure

---

## Project Structure

```
src
├── app
│   └── Main.java
│
├── model
│   ├── Book.java
│   ├── Member.java
│   ├── BorrowRecord.java
│   └── BookStatus.java
│
├── service
│   └── Library.java
│
├── test
│   └── LibraryTest.java
│
└── util
```

---

## Core Functionalities

### Book Management

- Add books
- Remove books
- Search by:
  - Book ID
  - Title
  - Author
  - Genre
- Update:
  - Title
  - Author
  - Genre
  - Price
  - Pages
  - Status

### Member Management

- Register members
- Remove members
- Update:
  - Name
  - Age
  - Contact
  - Address

### Borrowing System

- Borrow available books
- Return borrowed books
- Prevent borrowing unavailable books
- View books currently borrowed by a member
- View complete borrowing history

---

## Design Highlights

The project follows a simple layered architecture.

- **model** contains the application's entities.
- **service** contains the business logic.
- **app** contains the application entry point.
- **test** is used for testing application functionality.
- **util** is reserved for reusable utility classes.

The `Library` service acts as the central manager for all library operations while the model classes focus on representing data.

---

## Learning Outcomes

Through this project, I gained practical experience with:

- Designing object-oriented applications
- Applying encapsulation and composition
- Working with Java Collections
- Structuring projects into multiple packages
- Writing modular and maintainable Java code
- Implementing CRUD operations
- Validating user input
- Building a real-world console application

---

## Future Improvements

- Spring Boot REST API version
- MySQL database integration
- JDBC / Spring Data JPA
- Authentication and authorization
- Logging
- Unit testing with JUnit
- Docker deployment

---

## Author

**Beniel Ebenezer J**

GitHub: https://github.com/Beniel05
