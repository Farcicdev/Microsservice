# 📧 Email Microservice (Spring Boot + RabbitMQ)

Sistema de envio de emails baseado em arquitetura de microsserviços, utilizando comunicação assíncrona com RabbitMQ.

## 🚀 Funcionalidades

- Processamento de envio de emails via fila (RabbitMQ)
- Comunicação assíncrona entre serviços (Producer/Consumer)
- Integração com SMTP (Gmail) para envio real de emails
- Persistência de dados com PostgreSQL
- Tratamento de status de envio (SUCCESS / ERROR)

---

## 🧠 Arquitetura

O sistema é dividido em dois serviços principais:

### 🔹 Producer
Responsável por enviar mensagens para a fila com os dados do email.

### 🔹 Consumer
Responsável por consumir as mensagens da fila e realizar o envio do email.

---

## 🔁 Fluxo da aplicação

1. Requisição HTTP para envio de email  
2. Producer envia mensagem para o RabbitMQ  
3. Consumer recebe a mensagem da fila  
4. Email é enviado via SMTP  
5. Status é atualizado no banco de dados  

---

## 🛠️ Tecnologias utilizadas

- Java  
- Spring Boot  
- RabbitMQ  
- Spring AMQP  
- JavaMailSender (SMTP)  
- PostgreSQL  
- Lombok  

---

## ⚙️ Configuração

### 📌 RabbitMQ
Configure as credenciais no `application.yml`:

```
yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
---
###📌 Email (SMTP Gmail)

spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: ${EMAIL_USERNAME}
    password: ${EMAIL_PASSWORD}
    properties:
      mail.smtp.auth: true
      mail.smtp.starttls.enable: true
📬 Exemplo de requisição
{
  "emailTo": "teste@email.com",
  "subject": "Teste de envio",
  "body": "Olá, este é um email de teste!"
}
