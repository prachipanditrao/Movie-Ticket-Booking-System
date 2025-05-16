# 🎟️ Movie Ticket Booking System (Spring WebFlux + MongoDB + JWT)

A reactive movie ticket booking system inspired by BookMyShow, built using **Spring WebFlux**, **MongoDB**, and **JWT-based authentication**.

---

## 🔧 Tech Stack

- **Spring WebFlux** - Reactive REST APIs
- **MongoDB Atlas** - Cloud database
- **Spring Security + JWT** - Secure authentication
- **Project Reactor** - Reactive programming
- **Lombok** - Boilerplate reduction
- **Maven** - Build tool

---

## 📂 Project Structure

```
src/
├── controller/
├── model/
├── repository/
├── service/
├── security/
├── config/
└── util/
```

---

## 🚀 Features

- 🔐 User registration and JWT-based login
- 🎬 Create and view movies, shows, screens
- 🪑 Book tickets with seat selection
- 🧾 Booking history per user
- ☁️ Hosted on Render (or localhost)
- 🌱 Pre-filled test data using `CommandLineRunner`

---

## ⚙️ Getting Started (Local)

### 1. Clone the repo

```bash
git clone https://github.com/prachipanditrao/Movie-Ticket-Booking-System.git
cd movie-ticket-booking-system
```

### 2. Add `.env` or configure `application.yml`

In `src/main/resources/application.yml`:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb+srv://<username>:<password>@cluster.mongodb.net/<dbname>?retryWrites=true&w=majority
```

### 3. Run locally

```bash
./mvnw spring-boot:run
# OR
mvn spring-boot:run
```

---

## 🧪 Test Credentials

```
username: user
password: password
```

---

## 📬 API Endpoints

| Endpoint              | Method | Description                |
|-----------------------|--------|----------------------------|
| `/auth/register`      | POST   | Register new user          |
| `/auth/login`         | POST   | Login and get JWT          |
| `/movies`             | GET    | Get all movies             |
| `/bookings/shows`     | GET    | Get all shows              |
| `/bookings`           | POST   | Book Tickets               |

---

## ✅ Todo / Improvements

- 🎟️ Payment integration (dummy gateway)
- 📱 Frontend (React/Angular)
- 📊 Admin dashboard
- 🧪 Unit and integration tests