# 🚀 Employee Management REST API

## 📌 Overview

This project is a **secure REST API** built using Spring Boot to expose employee data for integration with the Employees-R-US SaaS platform.

It fulfills the requirements of the **ReliaQuest Entry-Level Java Challenge** by providing a **protected interface between legacy systems and external SaaS services**.

---

## 🧠 Architecture Diagram

![Architecture](architecture.png)

---

## 🏗️ Architecture Explanation

The system follows a **layered architecture**:

* **Controller Layer** → Handles incoming HTTP requests
* **Service Layer** → Contains business logic
* **DTO Layer** → Separates API contract from internal models
* **In-Memory Store** → Simulates persistence layer

### Additional Layers:

* **Validation Layer** → Ensures correct input (`@Valid`)
* **Global Exception Handler** → Centralized error handling
* **Spring Security** → Protects all endpoints

---

## 🔐 Security

All endpoints are secured using **Spring Security (HTTP Basic Authentication)**.

```text
Username: admin
Password: password
```

---

## 📚 API Documentation

Swagger UI is available for testing APIs:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 📡 Implemented Endpoints (As per Challenge)

### ✅ 1. Get All Employees

```http
GET /api/v1/employee
```

* Returns all employees (unfiltered)

---

### ✅ 2. Get Employee by UUID

```http
GET /api/v1/employee/{uuid}
```

* Returns a single employee
* Returns 404 if not found

---

### ✅ 3. Create Employee

```http
POST /api/v1/employee
```

#### Request:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "salary": 60000,
  "age": 25,
  "jobTitle": "Software Engineer",
  "email": "john.doe@example.com"
}
```

* Validates input
* Generates UUID automatically

---

## 🎯 How This Satisfies Challenge Requirements

According to the challenge description :

### ✔ Secure REST API

* Implemented using **Spring Security**
* All endpoints are protected

---

### ✔ Required Endpoints

* `getAllEmployees()` → Implemented
* `getEmployeeByUuid()` → Implemented
* `createEmployee()` → Implemented

---

### ✔ Practical Implementation

* Used **in-memory store** (as expected)
* Clean and simple design (no overengineering)

---

### ✔ Clean Code Practices

* Layered architecture
* Interface-based service design
* Proper naming conventions
* DTO separation

---

### ✔ Clear Design Methodology

* Separation of concerns
* Loose coupling
* Scalable structure

---

## 🚀 Additional Enhancements (Beyond Requirements)

* Pagination support
* Search & filtering
* DTO-based architecture
* Global exception handling
* Swagger documentation
* Logging

---

## 📦 Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Swagger (OpenAPI)
* Lombok
* Gradle

---

## ▶️ How to Run

```bash
gradlew build
gradlew bootRun
```

---

## 💯 Conclusion

This project not only satisfies all the requirements of the challenge but also enhances it with production-level features such as security, validation, and documentation.

---

⭐ *Designed with scalability, maintainability, and real-world backend practices in mind.*
