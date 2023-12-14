# Temperature Monitoring Application

### Overview

This Git repository contains the source code for a temperature monitoring application developed as a challenge for a company using the Quarkus framework, Kafka, PostgreSQL, Docker, and Docker Compose. The application consists of two microservices: a Producer and a Consumer.

### Microservices

#### Producer

The Producer microservice is responsible for collecting temperature data from two distant cities at regular intervals, utilizing an external API to obtain the temperature information. It sends the collected data to a Kafka topic. Each message sent to the topic includes details about the city, temperature, and date-time.

#### Consumer

The Consumer microservice consumes temperature data from the Kafka topic in real-time and stores it in a PostgreSQL database. This ensures that the temperature information is readily available for later analysis.

### Technologies Used

- Quarkus (Java)
- Kafka
- PostgreSQL
- Docker
- Docker Compose

### Project Structure

```
temperature-monitoring-app/
│
├── temperature-producer/
│   ├── src/
│   ├── Dockerfile
│   ├── application.properties
│   └── ...
│
├── temperature-consumer/
│   ├── src/
│   ├── Dockerfile
│   ├── application.properties
│   └── ...
│
├── docker-compose.yml
├── README.md
└── ...
```

### Getting Started

To run the application locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/temperature-monitoring-app.git`
2. Navigate to the project root: `cd temperature-monitoring-app`
3. Start the application using Docker Compose: `docker-compose up`

Refer to individual microservice READMEs for additional setup and configuration instructions.

### Contributors

Gustavo Oliveira

### License

This project is licensed under the [License Name] - see the LICENSE file for details.
