# SpracheKaiser

SpracheKaiser is a Java desktop application designed to support German language learning through practical exercises and real-life situations.

The application focuses on active language practice rather than traditional vocabulary memorization.

## Features

### Random Questions
Practice answering German questions.

Questions can be filtered by:
- language level
- theme

Each question includes:
- English meaning
- useful German phrases

### Quick Response
Practice responding quickly to common real-life situations.

Exercises can be filtered by:
- theme
- difficulty

Each exercise includes:
- a situation to respond to
- optional help
- an example answer

### Real-Life Challenges
Complete practical German exercises using objects and situations from everyday life.

Challenges can be filtered by:
- theme
- accessibility
- difficulty
- engagement

Examples include describing your room, ordering food, using a computer, giving directions, or describing everyday activities.

## Technologies

- Java
- Java Swing
- Maven
- Apache Commons CSV
- JUnit 5
- CSV files for exercise data

## Project Structure

The application follows a simple layered structure:

- `models` – application data models and filters
- `loader` – loading exercises from CSV files
- `services` – filtering and random selection logic
- `panels` – Swing user interface components

## Versions

### v1
Initial working version of the application.

- Random Questions
- Quick Response exercises
- Real-Life Challenges
- Help and example answers

### v2 – Current
Improved user experience and added exercise filtering.

- Redesigned user interface
- Added filters for Random Questions
- Added filters for Quick Response
- Added filters for Real-Life Challenges
- Added additional exercise categories

### v3 – Planned
Focus on reliability and improving the core functionality.

- Handle cases where no exercises match selected filters
- Improve random selection and prevent unnecessary repetitions
- Validate CSV data
- Expand automated tests
- Improve error handling
- Refactor duplicated code

## Running the Application

1. Clone the repository.
2. Open the project in IntelliJ IDEA or another Java IDE.
3. Make sure Maven dependencies are downloaded.
4. Run the `Main` class.

## Future Ideas

Possible future versions may include:

- spaced repetition system
- saving learning progress
- user accounts
- exercise statistics
- additional German exercises
