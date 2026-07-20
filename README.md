# Learning Management System (LMS)

## Description

This project is a Learning Management System (LMS) developed using JavaFX and MySQL. It allows instructors and students to use different dashboards based on their roles. The system helps instructors manage course materials while students can access learning resources and their grades.

---

## Features

### Student
- Register and Login
- View learning materials
- View PDF lecture slides
- Submit assignments
- Take quizzes
- View grades
- Update profile

### Instructor
- Register and Login
- Create and manage posts
- Upload PDF lecture slides
- Manage assignments
- Create quizzes
- Post grades
- Update profile

---

## Serialization

The system uses **Java Serialization** to save the logged-in user's session.

**Classes used:**
- `SessionManager`
- `User`

**Benefit:**
- Keeps the user logged in during the session.
- Stores user information without repeatedly accessing the database.

---

## SOLID Principles Used

### 1. Single Responsibility Principle (SRP)

**Classes:**
- `UserDAO`
- `SessionManager`

Each class has one responsibility.
- `UserDAO` handles database operations.
- `SessionManager` handles user sessions.

**Benefit:**
- Cleaner and easier-to-maintain code.

---

### 2. Dependency Inversion Principle (DIP)

**Classes:**
- `IUserService`
- `UserServiceImpl`
- `LoginController`

The controller depends on the `IUserService` interface instead of the implementation.

**Benefit:**
- Makes the system more flexible and easier to update.

---

## Technologies Used

- Java
- JavaFX
- MySQL
- JDBC
- Maven
- IntelliJ IDEA

---

## Developer

**Derk Reyes**

BS Information Technology
