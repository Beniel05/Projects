# Library Management System

A menu-driven console application built using Core Java to practice object-oriented programming principles. The application manages books, members, and borrowing operations while maintaining a clear separation between the presentation layer and business logic.

## Overview

This project was developed to strengthen Java OOP concepts before moving to larger applications. It focuses on designing classes, assigning responsibilities, and implementing business logic without using databases or external frameworks.

## Features

### Book Management

* Add books
* View all books
* View available books
* View borrowed books
* Search books by title, author, or genre
* Update book details

  * Title
  * Author
  * Genre
  * Pages
  * Price
  * Status
* Remove books

### Member Management

* Register members
* View all members
* Update member details

  * Name
  * Age
  * Contact Number
  * Address
* Remove members

### Borrow Management

* Borrow books
* Return books
* Prevent borrowing unavailable books
* Prevent returning already returned books
* Generate unique borrow records
* Preserve borrowing history

### Borrow Records

* View all borrow records
* View currently borrowed books of a member
* View complete borrowing history of a member

### Statistics

* Total books
* Total members
* Total borrow records
* Available books count
* Borrowed books count
* Library empty check

---

## Project Structure

```text
src
├── app
│   └── Main.java
├── model
│   ├── Book.java
│   ├── Member.java
│   ├── BorrowRecord.java
│   └── BookStatus.java
├── service
│   └── Library.java
└── test
    └── LibraryTest.java
```

---

## Class Design

### Book

Represents a library book and stores its metadata, including availability status.

### Member

Represents a registered library member.

### BorrowRecord

Represents a borrowing transaction by maintaining references to both the borrowed book and the member.

### Library

Acts as the service layer responsible for:

* Managing books
* Managing members
* Handling borrow and return operations
* Performing searches
* Updating records
* Maintaining borrow history
* Computing library statistics

---

## Technologies Used

* Java
* Eclipse IDE
* Java Collections Framework (`ArrayList`)
* Object-Oriented Programming

---

## OOP Concepts Demonstrated

* Classes and Objects
* Encapsulation
* Constructors
* Composition
* Object References
* Enums
* Collections
* Separation of Concerns
* Service Layer Design
* CRUD Operations

---

## Sample Workflow

```text
Register Member
        │
        ▼
Add Book
        │
        ▼
Borrow Book
        │
        ▼
Borrow Record Created
        │
        ▼
Return Book
        │
        ▼
Book Status Updated
        │
        ▼
Borrow History Retained
```

---

## Future Improvements

Potential enhancements for future versions include:

* Persistent storage using file handling
* JDBC integration
* MySQL database support
* Java Time API (`LocalDate`)
* Fine calculation
* Book quantity management
* Reservation system
* Authentication and authorization
* Spring Boot REST API
* Hibernate/JPA
* Unit testing with JUnit

---

## Author

**Beniel Ebenezer**
