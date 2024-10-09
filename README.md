# To-Do List Application

This is a full-stack to-do list application where users can add, mark as complete, delete, and view tasks. It uses ReactJS and Bootstrap for the frontend, Java Spring Boot for the backend, and MySQL for persistent data storage.

## Technologies Used

- *Frontend*: ReactJS, Bootstrap
- *Backend*: Java Spring Boot, MySQL

## Setup Instructions

### Prerequisites

Before starting, ensure that you have the following installed on your system:

- *Java 11* or higher (e.g., 11.0.13 LTS)
- *Maven 3.8+*(optional)
- *Node.js* (for the frontend)
- *MySQL* (for database)

### Download and Install Java 11

#### Option 1: Oracle JDK 11 (LTS)

1. Go to the [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Download the version for your operating system (Windows, macOS, or Linux).
3. Follow the installation instructions for your platform.

#### Option 2: OpenJDK 11 (Free and Open Source)

1. Visit the [AdoptOpenJDK page](https://adoptopenjdk.net/) or [OpenJDK website](https://openjdk.java.net/install/).
2. Choose *OpenJDK 11 (LTS)* for your operating system.
3. Download and install it by following the provided instructions.

### Backend (Java Spring Boot)
1. Clone the repository: `git clone https://github.com/FabianOkucai/ToDoList.git`
2. Navigate to the `backend` directory.
3. Make sure you have java installed.
4. Update your `application.properties` file which will be under the path `backend/src/main/resources/application.properties`  with the correct database credentials.
5. Using intellJ start the project using the StarterRun `mvn spring-boot:run` to start the backend server using Maven or if you are using .

![image2](https://github.com/user-attachments/assets/9bedade3-2bee-4572-a0b7-a36c26c8e656)

### Frontend (ReactJS)
1. Navigate to the `frontend` directory.
2. Run `npm install` to install the necessary dependencies.
3. Run `npm install axios` a tool to interct with API's
4. Run `npm start` to start the frontend server.

![Image 1](https://github.com/user-attachments/assets/8b8e9039-7b50-4714-90c9-5432d1b86a18)

## Running the Application:
- The backend server will run at `http://localhost:8080`.
- The frontend will run at `http://localhost:3000`.

## Author:
- GitHub: [FabianOkucai](https://github.com/FabianOkucai)
- Email: okucaifabian@gmail.com


