# Payment Processing System

A core payment system built using **Java** and **Spring Boot**, following a **microservices** architecture. Integrates with **Stripe** and **Razorpay** to offer a reliable, secure, and scalable payment experience.

---

## 🚀 Features

- **Stripe & Razorpay Integration** – Seamlessly handles payments, notifications, and statuses via API integrations.  
- **Microservices Architecture** – Decoupled, service-oriented design for payment processing and provider-specific logic.  
- **High Performance** – Utilizes thread pools and optimized error-handling for reliability.  
- **Robust Security** – Implements Stripe authentication and Spring security to safeguard payment data.  
- **Asynchronous Processing** – Uses ActiveMQ for background communication within the system.  
- **Error Handling** – Custom error codes and Spring Exception Handling for resilience.

---

## 🎯 Responsibilities / Approach

- Designed RESTful APIs for payment flows (initiate, confirm, refund).  
- Analyzed Stripe docs and collaborated on integration strategy.  
- Implemented payment-status tracking to ensure 100% transaction reliability.  
- Encapsulated business logic in modular, provider-specific microservices.  
- Built the Stripe notification listener with unit tests.  
- Developed custom error codes and exception layers.  
- Applied Factory and Builder design patterns for modularity.  
- Managed persistence with MySQL via Spring JDBC.  
- Deployed on AWS EC2 using Secrets Manager for credential security.  
- Integrated ActiveMQ to decouple synchronous logic.  

---

## 🧰 Tech Stack

| Layer              | Technologies |
|-------------------|--------------|
| Language/Framework | Java, Spring Boot, REST APIs |
| Database           | MySQL (Spring JDBC) |
| Messaging          | ActiveMQ |
| Cloud              | AWS EC2, AWS Secrets Manager |
| Testing            | JUnit, Mockito |
| Build              | Maven |
| IDE & Tools        | Eclipse, DBeaver, Postman, Git, SonarLint, Lombok |
| Logging            | Log4J / Logback |
| Methodology        | Agile / Scrum with Jira |

---

## 🏆 Key Learnings & Achievements

- Practical experience integrating Stripe and Razorpay in Spring-based microservices.  
- Hands-on exposure to asynchronous architecture with ActiveMQ.  
- Strengthened cloud deployment and security best practices on AWS.  
- Improved system reliability via robust error handling and design patterns.  
- Recognized as **STAR Performer of the Month** for delivery and teamwork.

---

## 📦 Prerequisites & Setup

### Requirements

- Java 11+  
- Maven  
- MySQL  
- ActiveMQ  
- AWS account or local equivalents (for developing/deployment)

### Running Locally

```bash
git clone https://github.com/masri2002/Payment-Processing-System.git
cd Payment-Processing-System
# Set up config (application.properties / env vars) for DB, Stripe/Razorpay keys, ActiveMQ, AWS
mvn clean install
mvn spring-boot:run
```

---

## 📚 Resources

- Official Stripe API docs  
- Razorpay developer documentation  
- AWS SDK & EC2 deployment guides  
- ActiveMQ messaging tutorials  

---

## ✅ License

This project is open-source. Please update with the applicable license (e.g., MIT, Apache 2.0) as needed.

---

### 🧡 Acknowledgments

Inspired by real-world e-commerce payment systems, this project demonstrates an end-to-end, secure, and scalable approach to processing payments.
