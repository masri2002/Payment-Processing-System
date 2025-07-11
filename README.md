# Payment Processing System

A core payment system built using **Java** and **Spring Boot**, following a **microservices** architecture. 

---

## 🚀 Features

- **Microservices Architecture** – Decoupled, service-oriented design for payment processing and provider-specific logic.  
- **Asynchronous Processing** – Uses ActiveMQ for background communication within the system.  
- **Error Handling** – Custom error codes and Spring Exception Handling for resilience.

---

## 🎯 Responsibilities / Approach

- Designed RESTful APIs for payment flows (initiate, confirm, refund).  
- Implemented payment-status tracking to ensure 100% transaction reliability.  
- Encapsulated business logic in modular, provider-specific microservices.  
- Developed custom error codes and exception layers.  
- Integrated ActiveMQ to decouple synchronous logic.  

---

## 🧰 Tech Stack

| Layer              | Technologies |
|-------------------|--------------|
| Language/Framework | Java, Spring Boot, REST APIs |
| Database           | H2 (Spring JDBC) |
| Messaging          | ActiveMQ |
| Build              | Maven |
| Logging            | Log4J  |

---

## 🏆 Key Learnings & Achievements

- Hands-on exposure to asynchronous architecture with ActiveMQ.  
- Improved system reliability via robust error handling and design patterns.  

---

## 📦 Prerequisites & Setup

### Requirements

- Java 11+  
- Maven    
- ActiveMQ  

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
- ActiveMQ messaging tutorials  

---



