# Task Manager API - README

## Overview

The **Task Manager API** provides a comprehensive set of endpoints to manage tasks, projects, teams, and users efficiently. It includes user authentication, project and task management, team collaboration, and search/filter capabilities.

### Key Features:
- **User Authentication**: Secure registration and login using JWT.
- **Project Management**: CRUD operations for managing projects.
- **Task Management**: CRUD operations with advanced filtering and searching options.
- **Team Management**: Add users to teams and manage team members.
- **User Management**: CRUD operations for user data.

---

## API Endpoints

### **Authentication**
#### Base URL: `/api/auth`

1. **Register User**
    - **Endpoint**: `POST /register`
    - **Request Body**: `User` object
    - **Response**: `201 Created` - User registered successfully.

2. **Login**
    - **Endpoint**: `POST /login`
    - **Request Body**: `LoginRequest` object (username, password)
    - **Response**: `200 OK` - Returns a JWT for authentication.

---

### **Home**
#### Base URL: `/`
1. **Home Page**
    - **Endpoint**: `GET /`
    - **Response**: Welcome message.

---

### **Project Management**
#### Base URL: `/api/projects`

1. **Create Project**
    - **Endpoint**: `POST /`
    - **Request Body**: `Project` object
    - **Response**: `201 Created` - Created project.

2. **Get Project By ID**
    - **Endpoint**: `GET /{id}`
    - **Response**: `200 OK` - Project data, or `404 Not Found`.

3. **Get All Projects**
    - **Endpoint**: `GET /`
    - **Response**: List of all projects.

4. **Update Project**
    - **Endpoint**: `PUT /{id}`
    - **Request Body**: Updated `Project` object
    - **Response**: `200 OK` - Updated project data.

5. **Delete Project**
    - **Endpoint**: `DELETE /{id}`
    - **Response**: `204 No Content`.

---

### **Task Management**
#### Base URL: `/api/tasks`

1. **Create Task**
    - **Endpoint**: `POST /`
    - **Request Body**: `Task` object
    - **Response**: `200 OK` - Created task.

2. **Get Task By ID**
    - **Endpoint**: `GET /{id}`
    - **Response**: `200 OK` - Task data, or `404 Not Found`.

3. **Get All Tasks**
    - **Endpoint**: `GET /`
    - **Response**: List of all tasks.

4. **Update Task**
    - **Endpoint**: `PUT /{id}`
    - **Request Body**: Updated `Task` object
    - **Response**: `200 OK` - Updated task data.

5. **Delete Task**
    - **Endpoint**: `DELETE /{id}`
    - **Response**: `204 No Content`.

#### Additional Endpoints:
- **Filter Tasks By Status**: `GET /status?completed=true/false`
- **Search Tasks By Keyword**: `GET /search?keyword={value}`
- **Filter Tasks By Date Range**: `GET /date-range?startDate={YYYY-MM-DD}&endDate={YYYY-MM-DD}`
- **Get Tasks By User ID**: `GET /user/{userId}`

---

### **Team Management**
#### Base URL: `/api/teams`

1. **Add User to Team**
    - **Endpoint**: `POST /{teamId}/addUser/{userId}`
    - **Response**: `200 OK` - User added to the team, or `404 Not Found`.

---

### **User Management**
#### Base URL: `/api/users`

1. **Create User**
    - **Endpoint**: `POST /`
    - **Request Body**: `User` object
    - **Response**: `201 Created` - Created user.

2. **Get User By ID**
    - **Endpoint**: `GET /{id}`
    - **Response**: `200 OK` - User data, or `404 Not Found`.

3. **Get All Users**
    - **Endpoint**: `GET /`
    - **Response**: List of all users.

4. **Update User**
    - **Endpoint**: `PUT /{id}`
    - **Request Body**: Updated `User` object
    - **Response**: `200 OK` - Updated user data.

5. **Delete User**
    - **Endpoint**: `DELETE /{id}`
    - **Response**: `204 No Content`.

---

## Technologies Used

- **Java Spring Boot**: Backend framework.
- **JWT**: Secure user authentication.
- **Spring Security**: Authentication and authorization.
- **Spring Data JPA**: Database interaction.
- **REST API**: Modular and scalable architecture.

---

## Setup Instructions

1. Clone the repository.
2. Configure database properties in `application.properties`.
3. Run the application using `mvn spring-boot:run`.
4. Use a REST client (e.g., Postman) to interact with the API.

---

## Future Enhancements

- Add OAuth2 support for third-party authentication.
- Implement detailed audit logging for user actions.
- Introduce notifications for task updates and deadlines.