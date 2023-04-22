# AlgaLog API

AlgaLog API é um projeto de uma API REST, construída com 
[Spring](https://spring.io/), para um sistema de logística fictício. 
Desenvolvida durante o Mergulho Spring REST, da 
[AlgaWorks](https://www.algaworks.com/).

## Tecnologias

- [OpenJDK 17](https://openjdk.org/projects/jdk/17/)
- [Spring Boot 2.7.9](https://spring.io/)
- [Lombok 1.18.26](https://projectlombok.org/)
- [Swagger](https://swagger.io/)

## Content Negotiation

A API suporta JSON e XML, ou seja, pode responder em ambos formatos.

## Banco de Dados

O projeto cria e se conecta a um BD MySQL chamado 'algalog'.

Antes de rodar o projeto, informe o usuário e a senha do banco de dados.
Isso pode ser feito renomeando o arquivo `secrets.yml.example`, em 
`src/main/resources`, para `secrets.yml`, e substituindo o texto "USERNAME_HERE" 
pelo seu nome de usuário do BD, e o texto "PASSWORD_HERE", pela senha deste 
usuário. 

## Como executar

Esse projeto utiliza o Swagger para documentação. As informações de contato da 
API são recupadadas do arquivo `secrets.yml`, em `src/main/resources`. Antes de 
executar o projeto, certifique-se de que estas informações estão nesse arquivo.
O arquivo `secrets.yml.example`, no mesmo local, tem um exemplo dessas 
informações.

Para rodar o projeto, use o [Apache Maven](https://maven.apache.org/), com o 
seguinte comando:

`$ mvn spring-boot:run`

Caso tenha problemas com a porta 8080, na qual o tomcat é inicializado, mude a 
porta, no arquivo `aplication.yml`, em `src/main/resources`, como no exemplo abaixo:
```yml
server:
  port : 8081
```

