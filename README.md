# Simple Item Management API

A simple Spring Boot RESTful API for managing items using in-memory storage.

---

## Tech Stack
- Java 17
- Spring Boot
- Maven
- In-memory storage (ArrayList)
- Postman (API testing)

---

## API Endpoints

### 1. Add Item
**POST** `/api/items`

**Request Body**
```json
{
  "name": "iPhone 15",
  "description": "Apple smartphone"
}
Response

201 Created

2. Get Item by ID

GET /api/items/{id}

Response

200 OK

Input Validation

Name must not be blank

Invalid input returns 400 Bad Request

How to Run Locally
Prerequisites

Java 17

Maven

Run Application
mvn spring-boot:run


Application runs at:

http://localhost:8081

Deployment

Deployed using Railway
