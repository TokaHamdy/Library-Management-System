# 📚 Library Management System

A comprehensive library management system designed to streamline the process of managing library resources and user interactions.

---

## ✨ Features
- **User Authentication**: Secure login and registration with role-based access control (Admin, Librarian, and Member).
- **Book Management**: Add, update, delete, and search for books.
- **Borrowing System**: Manage book borrowing and return processes with due dates.
- **Member Management**: Add and manage library members.
- **Fine Calculation**: Automatically calculates fines for overdue returns.
- **API Documentation**: Integrated Swagger UI for API testing and exploration.

---

## 🚀 Getting Started

Follow these steps to set up and run the project on your local machine:

### 1️⃣ Prerequisites
Make sure you have the following installed:
- **Java** (JDK 17 or higher)
- **Maven** (version 3.8+)
- **MySQL** (version 8+)

### 2️⃣ Set Up the Database
- Create a MySQL database named `library`.
- Update the `application.properties` file with your database credentials:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/library
  spring.datasource.username=your-username
  spring.datasource.password=your-password

 
---
 ###  3️⃣ Build and Run the Application
 - Open the project in your favorite IDE.
 - Run the project

---
### 4️⃣ Access Swagger UI
- Open your browser and navigate to [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to explore the API documentation.

---

### 🛠️ Code Features
- **Layered Architecture**: Utilized Spring Boot’s MVC pattern for a clean separation of concerns.
- **Security**: Implemented JWT-based authentication and authorization.
- **Database Integration**: Used JPA and Hibernate for database operations.
- **Validation**: Added input validation using Hibernate Validator.
- **Error Handling**: Centralized exception handling for improved API responses.

---

### ✨ What I Learned
- Best practices for RESTful API development in Spring Boot.
- Implementing JWT for secure authentication and authorization.
- Efficient database design and operations with JPA/Hibernate.

---

### 💡 Next Steps
- Add email notifications for due date reminders.
- Implement unit and integration testing for all modules.
- Enhance UI and frontend integration for better user experience.

---

### 🛠️ Technologies Used
- **Java**: Core development language.
- **Spring Boot**: Framework for building the application.
- **MySQL**: Database for storing library data.
- **JPA/Hibernate**: ORM for database operations.
- **JWT**: Authentication and authorization.
- **Swagger UI**: API documentation and testing.
- **Maven**: Build and dependency management tool.
- **Postman**: API testing.

---

### 🤝 Contributing
Contributions are welcome! Feel free to fork this repository and submit pull requests.

---

### 📧 Contact
For inquiries or support, reach out to me via [LinkedIn](https://www.linkedin.com/in/toka-hamdy-37872420b/) or via email at [tokaahamdy.21@gmail.com](tokaahamdy.21@gmail.com) 
