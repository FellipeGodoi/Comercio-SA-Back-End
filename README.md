# Teste Muralis - Comercio SA
API RESTful para gerenciamento de Cliente e seus Contatos

### Objetivo
Demonstrar conhecimento em Java com o Framework Spring Boot, capacidade de interpretar requsitos e aplicação de boas praticas de programação e estrutura de codigo. 

## Tecnologias utilizadas
- Linguagem: Java
- Framework : Spring Boot
- Banco de dados relacional: PostgreSQL
- ORM : Hibernate

## 📦 Instalação
### Pré-Requisitos
### Clone o repositorio
### Crie o banco de dados
### Docker
```
docker  run --name ComercioSA -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password123 -e POSTGRES_DB=comercio -d -p 5432:5432 postgres
```
### Observações
### Criação e população do banco de dados


### Requisitos Funcionais 
- [ ] RF01: O sistema deve permitir o cadastro de clientes com os seguintes dados: Nome,
CPF, Data de Nascimento e Endereço;
- [ ] RF02: O sistema deve permitir a edição dos dados de um cliente cadastrado;
- [ ] RF03: O sistema deve permitir a exclusão de um cliente cadastrado;
- [ ] RF04: O sistema deve permitir a listagem de todos os clientes cadastrados;
- [ ] RF05: O sistema deve permitir a busca de um cliente pelo Nome ou CPF;
- [ ] RF06: O sistema deve permitir o cadastro de contatos para um cliente, contendo os seguintes dados: Tipo do Contato (Telefone, E-mail), Valor do Contato (número ou e-mail) e Observação;
- [ ] RF07: O sistema deve permitir a edição dos contatos de um cliente;
- [ ] RF08: O sistema deve permitir a exclusão de um contato de um cliente;
- [ ] RF09: O sistema deve permitir a listagem de todos os contatos de um cliente.
específico.
### Regras de Negocio
- [ ] RN01: Os campos Nome e CPF são obrigatórios no cadastro do cliente;
- [ ] RN02: Os campos Tipo do Contato e Valor do Contato são obrigatórios no cadastro do contato;
- [ ] RN03: O CPF informado deve ser único no sistema;
- [ ] RN04: O Nome do cliente não pode estar vazio;
- [ ] RN05: A Data de Nascimento deve ser válida;
- [ ] RN06: Um cliente pode ter mais de um contato cadastrado;
- [ ] RN07: Ao excluir um cliente, todos os seus contatos devem ser removidos do sistema;
- [ ] RN08: O sistema deve validar os dados informados antes de permitir o cadastro ou edição.

## 📂 Estrutura do codigo
```
Comercio-SA/
├── src/

```

## Video

### Referencias
https://youtu.be/GmbK-O3v3Gg?si=r-lxDhtKRwhrnrt0