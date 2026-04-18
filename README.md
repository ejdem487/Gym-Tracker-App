# Gym Tracker API

A REST API for tracking gym workouts built with Spring Boot and PostgreSQL.

## Overview

This project focuses on the backend API of a gym tracking application. It allows users to manage workouts, exercises, and workout entries with sets, reps, and weight.

The current scope is a backend API. The application can be explored through Swagger UI and tested with Postman.

## Features

- CRUD operations for workouts and exercises
- Add exercises to workouts
- Track sets, reps, and weight for each workout exercise
- JWT-based authentication with register and login endpoints
- Request validation and basic error handling
- Swagger UI API documentation

## Tech Stack

- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Docker Compose
- Swagger / OpenAPI

## Running the Project

### Prerequisites

- Java 17
- Docker

### Environment variables

Create a `.env` file in the project root. You can copy the example:

```bash
cp .env.example .env
```

Required variables:

```env
JWT_SECRET=your_secret_key_here
JWT_EXPIRATION=787890000
```

### Run with Docker Compose

```bash
docker compose up --build
```

This starts:

- `postgres` on `localhost:5432`
- the Spring Boot API on `localhost:8080`

### Run only the database with Docker

If you want to run the API from your IDE or with Maven, start just PostgreSQL:

```bash
docker compose up -d postgres
```

### Run the application locally

Run `GymTrackerApplication.java` from your IDE or use Maven:

```bash
./mvnw spring-boot:run
```

## API Documentation

Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

You can also test the endpoints with Postman.

![Swagger UI](swagger.png)

## Example Endpoints

- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET /api/workouts`
- `POST /api/workouts`
- `GET /api/exercises`
- `POST /api/exercises`
- `GET /api/workout-exercises/workout/{workoutId}`
- `POST /api/workout-exercises`

## Project Structure

- `controller` - REST endpoints
- `service` - business logic
- `repository` - database access
- `model` - JPA entities
- `dto` - request objects
- `exception` - global exception handling

## Roadmap

- Add filtering and workout statistics
- Add frontend client in Vue.js
- Improve automated tests
