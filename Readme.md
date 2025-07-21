# 🏥 Apkadr.in – Doctor Appointment Booking Platform

This is a Spring Boot REST API for managing doctors in a healthcare system.  
The API supports full CRUD operations (Create, Read, Update, Delete), proper validations, and structured error handling.

> ✅ Developed for **Xynerotech Backend Internship - Week 1 Task** by **Ahmad Raza**

---

## 📌 Project Overview

This backend service is part of **Apkadr.in**, a doctor appointment booking platform.  
The focus of this task is to implement clean and modular **CRUD APIs** for managing doctors, including:

- Adding doctors
- Viewing doctor profiles
- Updating specific fields
- Deleting records
- Handling validation and errors in a user-friendly way

---

## ✅ Features

- 🔁 Full CRUD functionality for Doctor entity
- 🔐 Field-level validation using annotations
- 💬 Meaningful error messages and HTTP status codes
- 🧹 Clean architecture with DTOs, service layers, and mappers
- 🌐 RESTful API design following best practices
- 📦 Wrapper response using `ApiResponse<T>`

---

## 🧪 Technologies Used

| Tool         | Purpose                    |
|--------------|-----------------------------|
| Java 17      | Primary language             |
| Spring Boot  | REST API framework           |
| Spring Web   | Web layer                    |
| Spring Validation | Input validations       |
| Lombok       | Boilerplate remover          |
| Postman      | API testing                  |

---

## 📁 Folder Structure

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


---

## 🔗 API Endpoints (Doctor CRUD)

| Method | Endpoint               | Description                 | Request Body | Response Type |
|--------|------------------------|-----------------------------|---------------|----------------|
| `POST` | `/api/doctor`          | ➕ Add a new doctor          | ✅ Required   | DoctorResponseDto |
| `GET`  | `/api/doctors`         | 📄 Get all doctors           | ❌ No         | List<DoctorResponseDto> |
| `GET`  | `/api/doctor/{id}`     | 🔍 Get doctor by ID          | ❌ No         | DoctorResponseDto |
| `PUT`  | `/api/doctor/{id}`     | 🖊️ Update doctor (partial)   | ✅ Optional   | DoctorUpdateDto |
| `DELETE` | `/api/doctor/{id}`   | ❌ Delete doctor             | ❌ No         | ApiResponse<Void> |

---

## 📥 Sample Request & Response

### 🔸 Add Doctor – `POST /api/doctor`

**Request:**
```json
{
  "name": "Dr. Ahmad Raza",
  "specialization": "Dermatologist",
  "contact": "9876543210"
}


Response:

{
  "message": "Doctor added successfully.",
  "data": {
    "id": 1,
    "name": "Dr. Ahmad Raza",
    "specialization": "Dermatologist",
    "contact": "9876543210"
  },
  "timeStamp": "2025-07-20T18:00:00",
  "statusCode": 201
}

🔸 Get All Doctors – GET /api/doctors
Response:

json
Copy
Edit
[
  {
    "id": 1,
    "name": "Dr. Ahmad Raza",
    "specialization": "Dermatologist",
    "contact": "9876543210"
  },
  {
    "id": 2,
    "name": "Dr. Ali Khan",
    "specialization": "Cardiologist",
    "contact": "9876512345"
  }
]
🔸 Update Doctor – PUT /api/doctor/1
Request:

json
Copy
Edit
{
  "contact": "9999999999"
}
Response:

json
Copy
Edit
{
  "message": "Doctor details updated successfully.",
  "data": {
    "id": 1,
    "name": "Dr. Ahmad Raza",
    "specialization": "Dermatologist",
    "contact": "9999999999"
  },
  "timeStamp": "2025-07-20T18:10:00",
  "statusCode": 200
}
🔸 Delete Doctor – DELETE /api/doctor/1
Response:

json
Copy
Edit
{
  "message": "Doctor deleted successfully.",
  "data": null,
  "timeStamp": "2025-07-20T18:20:00",
  "statusCode": 200
}
🛡️ Validation Rules
Field	Validation
name	Must not be blank
specialization	Must not be blank
contact	Must be 10-digit number
Update Request	At least one field must be sent

⚠️ Error Handling
Handled centrally using @ControllerAdvice. Sample error:

json
Copy
Edit
{
  "message": "Contact must be a valid 10-digit number.",
  "data": null,
  "timeStamp": "2025-07-20T18:30:00",
  "statusCode": 400
}
▶️ How to Run Locally
Clone the repo:

bash
Copy
Edit
git clone https://github.com/yourusername/doctor-api.git
cd doctor-api
Run the project (Maven):

bash
Copy
Edit
mvn spring-boot:run
Test the APIs using Postman or any REST client.

✅ Final Checklist
 CRUD APIs for doctors working

 Field-level validation added

 DTO-layer mapping used

 Global exception handling done

 Response wrapped with message + metadata

 Code is modular and well-structured

 README with API documentation

🙌 Developed By
Ahmad Raza
Backend Intern @ Xynerotech

📧 mustafaraza03898@gmail.com
📞 +91-8107951977
🔗 GitHub Profile





