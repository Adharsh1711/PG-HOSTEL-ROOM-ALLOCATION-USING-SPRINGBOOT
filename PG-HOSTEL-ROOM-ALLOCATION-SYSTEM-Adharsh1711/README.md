# PG Hostel Room Allocation System

## How to Run the Project

### Option 1: Using the batch files
1. Double-click `run-app.bat` to start the application
2. Double-click `run-tests.bat` to run the tests

### Option 2: Using Maven commands
1. Open command prompt in the `springapp` directory
2. Run: `mvnw.cmd spring-boot:run` to start the application
3. Run: `mvnw.cmd test` to run tests

### Option 3: Using IDE
1. Import the `springapp` folder as a Maven project
2. Run the `SpringappApplication.java` main method
3. Run tests from the IDE

## API Endpoints

- Room Categories: `/api/room-categories`
- Rooms: `/api/rooms`
- Guests: `/api/guests`
- Bookings: `/api/bookings`
- Payments: `/api/payments`

## Database
The application uses H2 in-memory database by default.
Access H2 console at: http://localhost:8080/h2-console

## Port
Application runs on port 8080 by default.