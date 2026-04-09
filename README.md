# 🧪 Trello API Automation

Projeto de automação de testes da API do Trello utilizando **Java + RestAssured + Cucumber (BDD)**.

---

## 📌 Objetivo

Automatizar cenários de testes para a API do Trello, cobrindo:

- Autenticação (uso de key e token)
- Criação de card
- Edição de card
- Exclusão de card
- Validações de resposta da API

---

## 🛠️ Tecnologias utilizadas

- Java 11
- RestAssured
- Cucumber (BDD)
- JUnit
- Maven

---

## 🔐 Configuração

Antes de rodar o projeto, configure as variáveis de ambiente:

TRELLO_KEY=your_key  
TRELLO_TOKEN=your_token

Sem essas variáveis, os testes irão falhar.

---

## 📂 Estrutura do Projeto
trello-automation/
├── src/
│ ├── test/
│ │ ├── java/
│ │ │ ├── steps/
│ │ │ ├── utils/
│ │ │ ├── maps/
│ │ │ └── runner/
│ │ └── resources/
│ │ └── features/
├── pom.xml
└── README.md
