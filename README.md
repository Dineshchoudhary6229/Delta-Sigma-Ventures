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
