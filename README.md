# Fishing Management System

The Fishing Management System is a web application that allows users to manage their fishing records. 
Users can add new fish entries, update existing ones, delete entries, view the biggest caught fish overall, 
see how many fishes they have caught so far, and track various details such as bait, location, and weather.

## Table of Contents

- [Project status](#projectstatus)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Technologies](#technologies)
- [Dependencies](#dependencies)
- [Contributing](#contributing)

## Project Status

This project is currently under development. While it provides basic functionality for managing fishing records, there are plans to add more features and improvements in the future. Some of the planned enhancements include:

- Adding comprehensive tests for improved test coverage.
- Implementing additional validations to ensure data integrity and input correctness.
- Introducing an administrative role that has permissions to add, update, and delete users.
- Restricting user access so that each user can only view and manage their own fishing records.

Please note that the project is a work in progress, and contributions or suggestions are welcome. Feel free to open issues or submit pull requests for any improvements or bug fixes you'd like to contribute.

## Installation

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Install the required dependencies using the package manager of your choice (e.g., npm, yarn).
4. Configure the database connection in the application properties file.
5. Run the application

## Usage

1. Access the application through the provided URL or by running it locally.
2. Register for a new account or log in if you already have one.
3. Once logged in, you will be directed to the home page.
4. From the home page, you can perform the following actions:
   - Add a new fish entry: Provide details such as fish name, weight, image, bait information, location, and weather conditions.
   - Update a fish entry: Modify the details of an existing fish entry, including fish name, weight, image, bait information, location, and weather conditions.
   - Delete a fish entry: Remove a fish entry from your records.
   - View the biggest caught fish overall: See the largest fish caught so far.
   - See the total number of fish caught: Check the total count of fish caught by all users.

## Features

- User registration and authentication system.
- Create, update, and delete fish entries.
- Store details of bait used, including bait name, size, and image URL.
- Track location information, including country, town, and water body.
- Capture weather details such as air temperature, season, and weather description.
- Display the biggest caught fish overall.
- Show the total number of fish caught so far.

## Technologies

The Fishing Management System is built using the following technologies and tools:

- Java
- Spring Boot
- Spring Security
- Thymeleaf
- Bootstrap
- Intellij IDEA (IDE)

- ## Dependencies

- Spring Boot Data JPA
- Spring Boot Security
- Spring Boot Thymeleaf
- Thymeleaf Layout Dialect
- Snakeyaml
- Spring Boot Validation
- Spring Boot Web
- Thymeleaf Extras Spring Security
- MySQL Connector/J
- Lombok

## Contributing

Contributions are welcome! If you'd like to contribute to the Fishing Management System, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Implement your changes.
4. Write tests to ensure the functionality is working correctly.
5. Commit your changes and push them to your forked repository.
6. Create a pull request, explaining your changes and their benefits.

All the best !

