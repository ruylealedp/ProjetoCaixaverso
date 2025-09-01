# Projeto Final - Introdução o Quarkus

Este projeto tem como objetivo a construção de uma API REST utilizando o framework Quarkus API REST utilizando o framework Quarkus. A aplicação deve permitir o cadastro e manutenção de registros em
uma base de dados, implementando as operações básicas de um CRUD completo.

---

## ✅ Objetivos do Projeto
```
- A API deve conter os seguintes endpoints para pelo menos uma entidade principal uma entidade principal:
- Método Método Rota Rota Descrição Descrição
- GET /{entidade} Retorna todos os registros
- GET /{entidade}/{id} Retorna um registro por ID
- POST /{entidade} Cria um novo registro
- PUT /{entidade}/{id} Atualiza completamente completamente um registro
- PATCH /{entidade}/{id} Atualiza parcialmente parcialmente um registro
⚠️ Substitua {entidade} pelo nome do recurso escolhido no projeto (ex: livros, produtos, etc).)
```
---

## 📂 Estrutura do Projeto
```
src/main/java/org/acme  
+-- dto/                -> Objetos de transferência de dados
+-- entity/             -> Entidades JPA
+-- exception/          -> Tratamento de Erros
+-- repository/         -> Acesso a Dados(Panache)
+-- controller/           -> Endpoints REST 
+-- services/           -> Regras de negócio
```
---
## ⚙️ Como Rodar o Projeto

### 1. Pré-requisitos
- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- [Java 21 (GraalVM ou OpenJDK)](https://www.graalvm.org/downloads/#)
- [Maven](https://maven.apache.org/)

### 2. Subir banco de dados, pgadmin e emulador do eventHubs
```bash
docker-compose up -d
```
### 3. Rodar aplicação Quarkus em dev
```bash
# No diretório do projeto
mvn quarkus:dev
```
A aplicação estará disponível em: http://localhost:8080

### 4. Acessando o PGAdmin
- Acesse http://localhost:5050/
- Entre com as seguintes credenciais
- Email: admin@admin.com
- Senha: admin
- Clique em Add New
- Adicione o nome da sua conexão: adapetshop
- Na aba Connection insira:
    - Host name/address: ada_postgres
    - Port: 5432
    - Username: postgres
    - Password: 12345678
- Ainda na mesma aba, clique em Save

---
## 📌 Endpoints Principais

### Documentação Swagger
```
http://localhost:8080/swagger-ui
```

### Manipulação da Entidade de Pet
GET /ada-petshop/v1/pet
```
http://localhost:8080/ada-petshop/v1/pet
```
POST /ada-petshop/v1/pet
```
http://localhost:8080/ada-petshop/v1/pet
```
GET /ada-petshop/v1/pet/{id}
```
http://localhost:8080/ada-petshop/v1/pet/{id}
```
PUT /ada-petshop/v1/pet/{id}
```
http://localhost:8080/ada-petshop/v1/pet/{id}
```
PATCH /ada-petshop/v1/pet/{id}
```
http://localhost:8080/ada-petshop/v1/pet/{id}
```