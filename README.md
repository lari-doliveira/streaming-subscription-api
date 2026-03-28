# Streaming Subscription API

Mini API REST desenvolvida com Spring Boot para processamento de assinaturas de streaming.

## 🚀 Tecnologias

- Java
- Spring Boot
- Maven

---

## 📌 Funcionalidades

- Processamento de assinatura
- Suporte a planos `BASIC` e `PREMIUM`
- Cálculo de valor final com regras por tipo de plano
- Validação de dados com annotations (`@Valid`)
- Tratamento global de erros
- Resposta em JSON

---

## 🔧 Endpoint

### POST /subscriptions/process

### Exemplo de requisição

```json
{
  "customerName": "Larissa",
  "planType": "PREMIUM",
  "monthlyPrice": 59.90,
  "months": 3
}

### Exemplo de resposta

{
  "customerName": "Larissa",
  "planType": "PREMIUM",
  "finalAmount": 161.73,
  "message": "Assinatura processada com sucesso"
}

```

## ⚠️ Validações

- customerName é obrigatório
- planType deve ser BASIC ou PREMIUM
- monthlyPrice deve ser maior que zero
- months deve ser maior que zero

## 🧠 Conceitos praticados
- API REST
- Controller / Service / DTO
- Enum (PlanType)
- Strategy Pattern (PlanPolicy)
- Validação com @Valid
- Exception Handling com @RestControllerAdvice

## 📚 Objetivo
Projeto desenvolvido para prática de construção de APIs backend com Spring Boot e boas práticas de arquitetura.
