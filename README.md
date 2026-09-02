# 🤖 Personalized AI Assistant using Spring AI

A personalized AI chatbot built using **Java, Spring Boot, and Spring AI**. The application provides AI-powered conversational capabilities and uses organization-specific information, including **company details and IT course information**, to generate relevant and domain-specific responses.

## 🚀 Project Overview

**My Assistant** is a Spring AI-based chatbot designed to answer user questions using an AI model together with application-specific knowledge.

The application loads information from PDF documents available in the application's resources and processes that information through dedicated data-loading and data-transformation components.

The chatbot can provide information about:

- 🏢 Company details
- 📚 IT courses
- 💰 Course prices
- 🏷️ Course discounts
- 📝 Course descriptions
- 🎓 Training information
- 🤖 AI-powered responses

---

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Application development |
| Spring Boot | Backend application framework |
| Spring AI | AI / LLM integration |
| Spring Web | REST API development |
| Maven | Build and dependency management |
| PDF Documents | Application knowledge source |
| OpenAI | AI model integration |

---

## 🏗️ Application Architecture

```text
                         ┌─────────────────────┐
                         │    User / Client    │
                         └──────────┬──────────┘
                                    │
                                    │ HTTP Request
                                    ▼
                         ┌─────────────────────┐
                         │    AiController     │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │      AiService      │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │      Spring AI      │
                         │                     │
                         │      Chat Model     │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │      AI Model       │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │    AI Response      │
                         └─────────────────────┘


       Application Knowledge
                 │
                 ▼
        ┌─────────────────────┐
        │      PDF Files      │
        │                     │
        │ company_details.pdf │
        │ courses_info.pdf    │
        │ IT_Courses.pdf      │
        └──────────┬──────────┘
                   │
                   ▼
             ┌───────────┐
             │ DataLoader │
             └─────┬─────┘
                   │
                   ▼
          ┌─────────────────┐
          │ DataTransformer │
          └────────┬────────┘
                   │
                   ▼
           Application Data
                   │
                   ▼
               AiService
```

---

## 📁 Project Structure

```text
src
└── main
    ├── java
    │   └── com.substring.assistant
    │       │
    │       ├── config
    │       │   └── AiConfig.java
    │       │
    │       ├── controller
    │       │   └── AiController.java
    │       │
    │       ├── payload
    │       │   ├── AiRequest.java
    │       │   └── AiResponse.java
    │       │
    │       ├── service
    │       │   ├── impl
    │       │   ├── AiService.java
    │       │   ├── DataLoader.java
    │       │   └── DataTransformer.java
    │       │
    │       └── MyAssistantApplication.java
    │
    └── resources
        ├── application.properties
        ├── company_details.pdf
        ├── courses_info.pdf
        └── IT_Courses.pdf
```

---

## 🔍 Component Responsibilities

### `AiController`

Exposes the REST API through which clients communicate with the AI assistant.

```text
Client
  ↓
AiController
  ↓
AiService
```

It receives the user's request and returns the AI-generated response.

### `AiService`

Contains the main business logic for interacting with the AI model.

Responsibilities include:

- Processing user requests
- Preparing prompts
- Calling Spring AI
- Processing AI responses
- Providing relevant application context

### `AiConfig`

Contains configuration required for Spring AI and the AI model integration.

### `DataLoader`

Responsible for loading application-specific information from the PDF resources.

```text
PDF
 ↓
DataLoader
 ↓
Application Data
```

### `DataTransformer`

Transforms loaded information into a format suitable for processing by the application and AI service.

```text
Loaded Data
     ↓
DataTransformer
     ↓
Processed Data
     ↓
AiService
```

### `AiRequest`

Request DTO used to receive user input.

Example:

```json
{
  "message": "What courses are available?"
}
```

### `AiResponse`

Response DTO used to return the AI-generated response.

Example:

```json
{
  "response": "Iru Institute of Technology provides various IT courses..."
}
```

---

## 📚 Knowledge Sources

The application contains three PDF files under `src/main/resources`.

### `company_details.pdf`

Contains information about the company/institute.

### `courses_info.pdf`

Contains course-related information.

### `IT_Courses.pdf`

Contains detailed IT course information such as:

- Course name
- Course description
- Price
- Discount
- Training information

These documents provide domain-specific information that can be used by the AI assistant.

---

## 🔄 Application Flow

```text
                 User Question
                      │
                      ▼
                AiController
                      │
                      ▼
                  AiService
                      │
                      ├───────────────┐
                      │               │
                      ▼               ▼
              Application Data   User Question
                      │               │
                      └───────┬───────┘
                              │
                              ▼
                         AI Prompt
                              │
                              ▼
                          Spring AI
                              │
                              ▼
                            LLM
                              │
                              ▼
                      Generated Response
                              │
                              ▼
                         AiResponse
                              │
                              ▼
                            User
```

---

## 🤖 Spring AI Integration

Spring AI provides the abstraction layer between the Spring Boot application and the underlying AI model.

The basic flow is:

```text
Spring Boot
     │
     ▼
  Spring AI
     │
     ▼
  ChatClient
     │
     ▼
 Chat Model
     │
     ▼
    LLM
```

This approach allows the application to integrate AI capabilities without tightly coupling business logic to a specific model implementation.

---

## 💬 Example Questions

Users can ask questions such as:

```text
What courses do you provide?
```

```text
Tell me about Java courses.
```

```text
What is the price of the Spring Boot course?
```

```text
Which course should I take to learn Microservices?
```

```text
Do you provide Kubernetes training?
```

```text
What is the discount on Java courses?
```

```text
Tell me about the institute.
```

---

## 💡 Example Conversation

```text
User:
What courses does the institute provide?

Assistant:
Iru Institute of Technology provides a wide range of IT
courses covering Java, Spring Boot, Microservices, Cloud,
DevOps, Kubernetes, React, AI and other technologies.
```

Another example:

```text
User:
Tell me about Java courses.

Assistant:
The institute provides Java-focused training covering
Java programming, advanced Java, Spring Boot, Spring
Security, Spring Data JPA and Microservices.
```

---

## 📦 Maven Dependencies

Spring AI model integration:

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-model-openai</artifactId>
</dependency>
```

Spring Web:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Use the exact versions configured in the project's `pom.xml`.

---

## ⚙️ Configuration

The AI API key should be provided using an environment variable.

Example:

```properties
spring.ai.openai.api-key=${OPENAI_API_KEY}
```

Set the API key as an environment variable.

### Windows PowerShell

```powershell
$env:OPENAI_API_KEY="your-api-key"
```

### Linux/macOS

```bash
export OPENAI_API_KEY="your-api-key"
```

> Never commit your actual API key to GitHub.

---

## ▶️ Running the Application

### Prerequisites

Install:

- Java 21
- Maven
- Git

Check Java:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

### Clone the Repository

```bash
git clone <your-repository-url>
```

Navigate to the project:

```bash
cd <project-directory>
```

### Run the Application

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

---

## 🔌 API Usage

The chatbot exposes its API through `AiController`.

Example request:

```http
POST /api/ai
Content-Type: application/json
```

Request body:

```json
{
  "message": "What Java courses are available?"
}
```

Example response:

```json
{
  "response": "Iru Institute of Technology offers Java-focused courses..."
}
```

> Update the endpoint above with the exact `@RequestMapping` and `@PostMapping` values from `AiController`.

---

## 🧪 Testing

Run the test suite:

```bash
./mvnw test
```

Build the application:

```bash
./mvnw clean package
```

Windows:

```powershell
.\mvnw.cmd clean package
```

---

## 🔐 Security

Do not store sensitive credentials directly in source code.

Use:

```text
Environment Variables
        or
Secret Management
```

For example:

```properties
spring.ai.openai.api-key=${OPENAI_API_KEY}
```

Sensitive configuration files should be excluded from Git where appropriate.

---

## 🎯 Key Learning Outcomes

This project demonstrates practical implementation of:

```text
Java 21
   ↓
Spring Boot
   ↓
Spring AI
   ↓
AI / LLM Integration
   ↓
Prompt Processing
   ↓
PDF Data Loading
   ↓
Data Transformation
   ↓
Domain-Specific AI Assistant
```

The project provides hands-on experience integrating **Generative AI with a Java Spring Boot application**.

---

## 🚀 Future Enhancements

Potential enhancements include:

- Conversation memory
- Chat history
- RAG (Retrieval-Augmented Generation)
- Embeddings
- Vector databases
- PostgreSQL + pgvector
- Semantic search
- Document chunking
- Streaming AI responses
- Tool calling
- AI agents
- JWT authentication
- Redis-based memory
- Docker deployment
- Kubernetes deployment
- CI/CD pipeline
- Monitoring and observability

---

## 🎓 Training Areas

The associated training content covers:

```text
Java
Spring Boot
Spring Framework
Spring Security
Spring Data JPA
Microservices
Apache Kafka
PostgreSQL
Docker
Kubernetes
AWS
Google Cloud
React
JavaScript
DevOps
System Design
Software Architecture
Spring AI
Generative AI
RAG
Data Structures & Algorithms
Software Testing
```

---

## 👨‍💻 Trainer / Developer

### Shoaib Hasan

Java Backend / Full Stack Developer

Technical areas:

- Java
- Spring Boot
- Spring AI
- Microservices
- REST APIs
- Apache Kafka
- PostgreSQL
- Docker
- Kubernetes
- Cloud
- DevOps
- Generative AI

---

## 🏢 Company

### Iru Institute of Technology

Iru Institute of Technology provides practical and industry-oriented IT training focused on modern software development technologies.

### Training Areas

```text
Java
Spring Boot
Microservices
Spring AI
Generative AI
Cloud
DevOps
Kubernetes
React
Databases
System Design
Software Testing
```

---

## ⭐ GitHub Repository Description

> Personalized AI Assistant built using Java, Spring Boot, and Spring AI, capable of providing domain-specific responses using company and IT course information loaded from PDF documents.

---

## 🏷️ GitHub Topics

```text
java
spring-boot
spring-ai
generative-ai
ai
chatbot
ai-assistant
llm
openai
rest-api
maven
pdf
prompt-engineering
rag
backend
spring
```

---

## 📄 License

This project is intended for **demonstration purposes**.
