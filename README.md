# Agendamento de Transferências Backend

Este backend foi desenvolvido utilizando Spring Boot, JPA, H2 e Lombok para fornecer uma API REST para agendamento de transferências bancárias. Ele permite que os usuários agendem transferências especificando a conta de origem, conta de destino, valor e data da transferência.

## Tecnologias Utilizadas

*   **Java 17:** Linguagem de programação utilizada.
*   **Spring Boot:** Framework Java para desenvolvimento rápido de aplicações Spring.
*   **JPA (Java Persistence API):** Interface para acesso e gerenciamento de bancos de dados relacionais.
*   **H2:** Banco de dados relacional embutido para desenvolvimento e testes.
*   **Lombok:** Biblioteca Java para reduzir o código boilerplate (repetitivo).
*   **IntelliJ IDEA:** IDE utilizada para o desenvolvimento.
*   **Maven:** Ferramenta de gerenciamento de dependências e construção de projetos Java.

## Funcionalidades

*   **Agendamento de Transferências:** Permite agendar transferências especificando a conta de origem, conta de destino, valor e data da transferência.
*   **Listagem de Transferências:** Permite listar as transferências agendadas.

## Como executar

1.  Clone o repositório do backend do GitHub.
2.  Abra o projeto no IntelliJ IDEA.
3.  Execute a aplicação a partir da classe principal (`Application.java`).

## Endpoints da API

*   **POST /transferencias:** Agendamento de transferência.
    *   **Request Body:**

    ```json
    {
      "contaOrigem": "123456",
      "contaDestino": "654321",
      "valor": 100.00,
      "dataTransferencia": "2024-03-15"
    }
    ```

    *   **Response:**

    ```json
    {
      "id": 1,
      "contaOrigem": "123456",
      "contaDestino": "654321",
      "valor": 100.00,
      "dataTransferencia": "2024-03-15",
      "dataAgendamento": "2024-03-10"
    }
    ```

*   **GET /transferencias:** Listagem de transferências.
    *   **Response:**

    ```json
    [
      {
        "id": 1,
        "contaOrigem": "123456",
        "contaDestino": "654321",
        "valor": 100.00,
        "dataTransferencia": "2024-03-15",
        "dataAgendamento": "2024-03-10"
      },
      {
        "id": 2,
        "contaOrigem": "987654",
        "contaDestino": "102030",
        "valor": 50.00,
        "dataTransferencia": "2024-03-20",
        "dataAgendamento": "2024-03-10"
      }
    ]
    ```
