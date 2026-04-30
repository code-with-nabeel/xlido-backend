# XLIDO - Event Management Backend System

## Overview

XLIDO is a backend system built using Java to manage users, events, and interactions. It follows clean architecture principles and implements design patterns like the Command Pattern to handle different operations.

---

## Features

* 👤 User Management (Create Users)
* 📅 Event Creation & Deletion
* 🙋 User Participation
* 💬 Question & Reply System
* 🔼 Upvote Questions
* 🧩 Command Pattern Implementation
* 🧪 Unit Testing using AppTest

---

## Tech Stack

* **Language:** Java
* **Build Tool:** Gradle
* **Architecture:** Layered Architecture
* **Design Pattern:** Command Pattern
* **Testing:** JUnit

---

## 📂 Project Structure

```id="structure1"
src/
 ├── main/java/com/crio/xlido/
 │    ├── commands/      # Command Pattern implementation
 │    ├── model/         # Entity classes (User, Event, etc.)
 │    ├── repository/    # Data handling layer
 │    ├── service/       # Business logic
 │    └── App.java       # Entry point
 │
 ├── test/java/com/crio/xlido/
 │    └── AppTest.java   # Unit tests
```

---

## ⚙️ How to Run

```id="run1"
./gradlew build
./gradlew run
```

---

## 📊 Key Learnings

* Implemented Command Design Pattern for scalable operations
* Built modular backend architecture using Java
* Separated concerns using service and repository layers
* Wrote unit tests to validate application behavior

---

## Future Improvements

* Add REST APIs (Spring Boot)
* Add database integration (MySQL)
* Add exception handling layer
* Add authentication system

---

## 👨‍💻 Author

**Nabeel Khan**
GitHub: https://github.com/code-with-nabeel
