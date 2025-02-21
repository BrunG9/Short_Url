# Encurtador de URL

Este projeto é uma implementação simples de um encurtador de URL, que permite que os usuários insiram URLs longas e obtenham uma versão curta para facilitar o compartilhamento.

## Funcionalidades

- **Encurtar URLs:** Gera uma versão curta para URLs longas inseridas pelo usuário.
- **Redirecionamento:** O usuário pode acessar a URL original ao acessar o link curto gerado.
  
## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Spring Boot**: Framework utilizado para construir a API.
- **Maven**: Gerenciador de dependências e construção do projeto.

## Como Rodar o Projeto

1. Clone o repositório:

    ```bash
    git clone https://github.com/BrunG9/Short_Url.git
    ```

2. Navegue até a pasta do projeto:

    ```bash
    cd Short_Url
    ```

3. Instale as dependências e compile o projeto com o Maven:

    ```bash
    mvn clean install
    ```

4. Execute a aplicação:

    ```bash
    mvn spring-boot:run
    ```

A API estará disponível em `http://localhost:8080`.

## Como Usar

- Enviar uma requisição `POST` para `/shorten` com o corpo contendo a URL longa.
- A resposta será a URL curta correspondente.
