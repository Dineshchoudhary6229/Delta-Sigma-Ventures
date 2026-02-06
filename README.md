# Simple Item Management API

A simple Spring Boot RESTful API for managing items using in-memory storage (ArrayList).

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
```

**Response**
- `201 Created`

---

### 2. Get Item by ID
**GET** `/api/items/{id}`

**Response**
- `200 OK`

---

## Input Validation
- `name` must not be blank
- Invalid input returns `400 Bad Request`

---

## How to Run Locally

### Prerequisites
- Java 17
- Maven

### Run Application
```bash
mvn spring-boot:run
```

Application runs at:
```
http://localhost:8081
```

---

## Deployment
- Deployed using **Railway**
- Supports dynamic port configuration:
```properties
server.port=${PORT:8081}
```

## API Testing Screenshots

Screenshots of API testing using Postman are available in the `Delta-Sigma-Ventures
/Screenshots-Postman/` folder.

