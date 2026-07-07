# Tours & Travels Management System

A full-stack tour booking platform with role-based access for admins and customers, secure authentication, and integrated payments — built with Spring Boot, PostgreSQL, React, and Redux.

## Features

- **Tour Booking Platform** — End-to-end booking flow for customers, with a dedicated admin experience for managing tours, bookings, and users.
- **Role-Based Access Control** — Separate permissions and views for admin and customer roles, enforced via Spring Security.
- **Authentication** — JWT-based authentication plus Google OAuth2 login for a smoother sign-in experience.
- **Payments** — Stripe API integration for secure, end-to-end payment processing on bookings.
- **Image Storage** — Cloudinary integration for tour image uploads and delivery.
- **API Documentation** — Fully documented REST API (~28 endpoints) via Swagger/OpenAPI.

## Tech Stack

**Backend**
- Java, Spring Boot
- Spring Security (JWT, OAuth2)
- Spring Data JPA / Hibernate
- PostgreSQL

**Payments & Storage**
- Stripe Payment API
- Cloudinary

**Frontend**
- React.js
- Redux Toolkit

**Documentation**
- Swagger / OpenAPI

## Architecture Overview

```
┌─────────────┐      REST API (~28 endpoints)     ┌──────────────────┐
│   React     │ ────────────────────────────────▶ │   Spring Boot     │
│  Redux App  │ ◀──────────────────────────────── │   Backend         │
└─────────────┘                                    └─────────┬─────────┘
                                                              │
                     ┌────────────────────────┬───────────────┼───────────────────┐
                     ▼                        ▼                                   ▼
             ┌───────────────┐      ┌──────────────────┐              ┌────────────────────┐
             │  PostgreSQL   │      │  Spring Security  │              │  Stripe / Cloudinary│
             │  (bookings,   │◀────▶│  (JWT + OAuth2)   │              │  (payments, images)  │
             │   users)      │      └──────────────────┘              └────────────────────┘
             └───────────────┘
```

## Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL 15+
- Node.js & npm
- Stripe account (API keys)
- Cloudinary account (API keys)
- Google OAuth2 credentials (Client ID/Secret)

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/kamal991/<repo-name>.git
   cd <repo-name>
   ```

2. **Configure environment variables**

   Update `application.properties` / `application.yml` (backend) with:
   ```
   SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/tours_travel_db
   SPRING_DATASOURCE_USERNAME=your_db_username
   SPRING_DATASOURCE_PASSWORD=your_db_password

   JWT_SECRET=your_jwt_secret

   GOOGLE_CLIENT_ID=your_google_client_id
   GOOGLE_CLIENT_SECRET=your_google_client_secret

   STRIPE_API_KEY=your_stripe_secret_key
   STRIPE_PUBLISHABLE_KEY=your_stripe_publishable_key

   CLOUDINARY_CLOUD_NAME=your_cloud_name
   CLOUDINARY_API_KEY=your_cloudinary_api_key
   CLOUDINARY_API_SECRET=your_cloudinary_api_secret
   ```

3. **Run the backend**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Run the frontend**
   ```bash
   cd frontend
   npm install
   npm start
   ```

5. Access the app at `http://localhost:3000` (frontend) and the API at `http://localhost:8080`.
   API docs available at `http://localhost:8080/swagger-ui.html`.

## API Overview

| Endpoint | Method | Description |
|---|---|---|
| `/api/auth/login` | POST | Authenticate user, issue JWT |
| `/api/auth/google` | POST | Google OAuth2 login |
| `/api/tours` | GET / POST | List or create tours (admin) |
| `/api/tours/{id}` | GET / PUT / DELETE | Retrieve, update, or delete a tour |
| `/api/bookings` | GET / POST | List or create bookings |
| `/api/bookings/{id}` | GET / DELETE | Retrieve or cancel a booking |
| `/api/payments/checkout` | POST | Create Stripe checkout session |
| `/api/users` | GET | Admin: list registered users |

*(Adjust endpoint names/paths to match your actual controller mappings.)*

## Project Structure

```
├── src/main/java/com/tourstravel
│   ├── controller/     # REST controllers
│   ├── service/        # Business logic (bookings, payments, auth)
│   ├── repository/     # Spring Data JPA repositories
│   ├── model/          # Entity classes
│   ├── security/        # JWT & OAuth2 configuration
│   └── config/          # App-level configuration
├── src/main/resources/
│   └── application.yml
├── frontend/            # React + Redux application
└── README.md
```

## Roadmap / Future Improvements

- Add automated test coverage (JUnit 5) for booking and payment flows
- Add email notifications for booking confirmations
- Support multi-currency pricing for international tours

## License

This project is for personal/portfolio use.

## Author

**Kamaldas Balerao**
[GitHub](https://github.com/kamal991) | [LinkedIn](https://linkedin.com/in/kamal-balerao-0a238a23b)
