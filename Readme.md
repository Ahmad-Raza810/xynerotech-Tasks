
# 🏥 Apkadr.in – Doctor Appointment Booking Platform

This is a Spring Boot REST API for managing doctors in a healthcare system.  
The API supports full **CRUD** operations (Create, Read, Update, Delete), proper validations, and structured error handling.

> ✅ Developed for **Xynerotech Backend Internship - Week 1 Task** by **Ahmad Raza**

---

## 📌 Project Overview

This backend service is part of **Apkadr.in**, a doctor appointment booking platform.  
The goal is to implement clean and modular **CRUD APIs** for managing doctors, including:

- Adding doctors  
- Viewing doctor profiles  
- Updating specific fields  
- Deleting records  
- Providing user-friendly validation and error responses

---

## ✅ Features

- 🔁 Full CRUD functionality for the Doctor entity  
- 🔐 Field-level validation using annotations  
- 💬 Meaningful error messages with proper HTTP status codes  
- 🧹 Clean architecture with DTOs, service layers, and mappers  
- 🌐 RESTful API design following best practices  
- 📦 Consistent API responses using `ApiResponse<T>`

---

## 🧪 Technologies Used

| Technology          | Purpose                          |
|---------------------|----------------------------------|
| Java 17             | Primary programming language     |
| Spring Boot         | Web application framework        |
| Spring Web          | RESTful API development          |
| **Spring Data JPA** | Database operations (ORM)        |
| **Spring Validation** | Input & field validation       |
| Lombok              | Reduces boilerplate code         |
| Postman             | API testing                      |

---

## 📁 Folder Structure

```
src/
└── main/
    └── java/
        └── com.xynerotech.task.doctor_appointment_booking_platform
            ├── controller
            ├── dto
            ├── entity
            ├── repository
            ├── service
            ├── exception
            └── response
```

---

## 🔗 API Endpoints (Doctor CRUD)

| Method   | Endpoint             | Description                | Request Body     | Response Type             |
|----------|----------------------|----------------------------|------------------|---------------------------|
| `POST`   | `/api/doctor`        | ➕ Add a new doctor         | ✅ Required       | DoctorResponseDto         |
| `GET`    | `/api/doctors`       | 📄 Get all doctors          | ❌ No             | List<DoctorResponseDto>   |
| `GET`    | `/api/doctor/{id}`   | 🔍 Get doctor by ID         | ❌ No             | DoctorResponseDto         |
| `PUT`    | `/api/doctor/{id}`   | 🖊️ Update doctor (partial)  | ✅ Optional       | DoctorUpdateDto           |
| `DELETE` | `/api/doctor/{id}`   | ❌ Delete doctor            | ❌ No             | ApiResponse<Void>         |

---

## 📥 Sample Requests & Responses

### 🔸 Add Doctor – `POST /api/doctor`

**Request:**
```json
{
  "name": "Dr. Aakash Gupta",
  "specialization": "Dermatologist",
  "contact": "9876543210"
}
```

**Response:**
```json
{
  "message": "Doctor added successfully.",
  "data": {
    "id": 1,
    "name": "Dr. Aakash Gupta",
    "specialization": "Dermatologist",
    "contact": "9876543210"
  },
  "timeStamp": "2025-07-20T18:00:00",
  "statusCode": 201
}
```

---

### 🔸 Get All Doctors – `GET /api/doctors`

**Response:**
```json
[
  {
    "id": 1,
    "name": "Dr. Aakash Gupta",
    "specialization": "Dermatologist",
    "contact": "9876543210"
  },
  {
    "id": 2,
    "name": "Dr. Arvind Sisodia",
    "specialization": "Cardiologist",
    "contact": "9876512345"
  }
]
```

---

### 🔸 Update Doctor – `PUT /api/doctor/1`

**Request:**
```json
{
  "contact": "9999999999"
}
```

**Response:**
```json
{
  "message": "Doctor details updated successfully.",
  "data": {
    "id": 1,
    "name": "Dr. Aakash Gupta",
    "specialization": "Dermatologist",
    "contact": "9999999999"
  },
  "timeStamp": "2025-07-20T18:10:00",
  "statusCode": 200
}
```

---

### 🔸 Delete Doctor – `DELETE /api/doctor/1`

**Response:**
```json
{
  "message": "Doctor deleted successfully.",
  "data": null,
  "timeStamp": "2025-07-20T18:20:00",
  "statusCode": 200
}
```

---

## 🛡️ Validation Rules

| Field           | Validation Rule                  |
|------------------|----------------------------------|
| `name`           | Must not be blank                |
| `specialization` | Must not be blank                |
| `contact`        | Must be a 10-digit number        |
| `Update payload` | At least one field is required   |

---

## ⚠️ Error Handling

Errors are handled centrally using `@ControllerAdvice`.  
Example error response:
```json
{
  "message": "Contact must be a valid 10-digit number.",
  "data": null,
  "timeStamp": "2025-07-20T18:30:00",
  "statusCode": 400
}
```

---

## ▶️ How to Run Locally

**Clone the Repository:**
```bash
git clone https://github.com/Ahmad-Raza810/xynerotech-Tasks.git
cd doctor-api
```

**Run the Project using Maven:**
```bash
mvn spring-boot:run
```

Use Postman or Swagger UI to test the APIs.

---

## ✅ Final Checklist

- ✅ CRUD APIs for doctors working  
- ✅ Field-level validation added  
- ✅ DTO-layer mapping implemented  
- ✅ Global exception handling with `@ControllerAdvice`  
- ✅ Response wrapped with message, timestamp & status  
- ✅ Code is modular and well-structured  
- ✅ API documented in README

---

## 🙌 Developed By

**Ahmad Raza**  
Backend Intern @ Xynerotech ✔️  
📧 mustafaraza03898@gmail.com  
📞 +91-8107951977  
🔗 https://github.com/Ahmad-Raza810
