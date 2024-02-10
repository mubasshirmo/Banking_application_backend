# Banking Application

This project is a simple Banking Application built using Spring Boot, Spring Data JPA (with Hibernate), and MySQL. It provides basic functionalities for managing bank accounts, transactions, and customers.

## Features

- **Account Management**: Create, update, and delete bank accounts.
- **Transaction Handling**: Perform deposit, withdrawal, and transfer transactions.
- **Customer Management**: Manage customer information associated with bank accounts.

## Technologies Used

- **Spring Boot**: For rapid application development and easy setup.
- **Spring Data JPA**: For data access layer abstraction.
- **Hibernate**: As the JPA provider for mapping Java objects to database tables.
- **MySQL**: As the relational database management system.

## Setup Instructions

### Prerequisites

- JDK 8 or higher installed on your machine.
- MySQL database server installed locally or accessible remotely.
- Maven installed on your machine for building the project.

### Steps to Run

1. **Clone the repository**:

    ```bash
    git clone https://github.com/your-username/banking-application.git
    ```

2. **Navigate to the project directory**:

    ```bash
    cd banking-application
    ```

3. **Update application properties**:

    Open `src/main/resources/application.properties` file and configure the database connection properties according to your MySQL setup.

4. **Build the project**:

    ```bash
    mvn clean package
    ```

5. **Run the application**:

    ```bash
    java -jar target/banking-application.jar
    ```

6. **Access the application**:

    Once the application is running, you can access it at `http://localhost:8080` in your web browser.

## Contributing

Contributions are welcome! Feel free to open issues or pull requests for any improvements or features you'd like to see added.

## License

This project is licensed under the [MIT License](LICENSE).
