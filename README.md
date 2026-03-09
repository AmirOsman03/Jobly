# Jobly

Jobly is a full-stack application for displaying job listings aggregated from multiple sources.  
The backend is built with **Spring Boot + PostgreSQL**, and the frontend uses **React + MUI (Material-UI)**.

## 🚀 Features

- Web scraper that collects job postings from various websites  
- Scheduler that periodically updates the database  
- REST API for jobs  
- React frontend displaying jobs in a 4-column grid  
- Light/Dark mode toggle  
- Responsive UI using MUI components

---

## 📁 Project Structure
```text
Jobly/
├── backend/   # Spring Boot Application & Scraping Logic
├── frontend/  # React.js Application & MUI Components
└── README.md
```

---

## 🛠️ Tech Stack

**Backend**
- Java
- Spring Boot
- PostgreSQL
- JPA/Hibernate

**Frontend**
- React
- MUI (Material-UI)
- Fetch/Axios for API calls

---

## 🛠️ Setting up the Backend

1. Clone the repository:
```text
git clone https://github.com/AmirOsman03/Jobly.git
cd Jobly
```

3. Navigate to the backend folder:
```text
cd backend
```

4. Set up PostgreSQL database:
- Create a database named jobly
- Configure spring.datasource.* properties in application.properties

4. Start the backend:
```text
./mvnw spring-boot:run
```
The backend will run at http://localhost:8080

---

## 🛠️ Setting up the Backend

1. Navigate to frontend folder:
```text
cd frontend
```

3. Install dependencies:
```text
npm install
```

5. Add proxy for the backend API in package.json:
```text
"proxy": "http://localhost:8080"
```

7. Start the frontend:
```text
npm start
```
The frontend will run at http://localhost:3000
