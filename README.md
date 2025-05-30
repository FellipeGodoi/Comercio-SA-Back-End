# Comercio SA
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
- JDK 17 ou superior
- Maven
- Docker ou Alguma ferramenta para manipular banco postgresql (pgAdmin por exemplo)

### Clone o repositorio e acesse o arquivo
```
git clone https://github.com/seu-usuario/ComercioSA.git
cd ComercioSA
```
### Crie o banco de dados
você pode criar esse banco com o docker ou crie um banco postgresql no pgAdmin por exemplo

### Criando no Docker
```
docker  run --name ComercioSA -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password123 -e POSTGRES_DB=comercio -d -p 5432:5432 postgres
```
### Criando com pgAdmin
1. Abra o pgAdmin
2. Adicione um novo servidor
   Clique com o botão direito em Servers > Create > Server...

3. Na aba General:
   Name: ComercioSA (pode ser qualquer nome)

4. Na aba Connection:
   Host name/address: localhost
    Port: 5432
    Username: admin
    Password: password123
    Marque a opção Save password se quiser.
5. Clique em Save

### Observações
Caso necessario altere as variaveis de conexão no arquivo application.properties

```
spring.application.name=ComercioSA
spring.datasource.url=jdbc:postgresql://localhost:5432/comercio
spring.datasource.username=admin
spring.datasource.password=password123
spring.jpa.hibernate.ddl-auto=update
```

### Criação e população do banco de dados
O banco será gerado automaticamente com auxilio do hibernate e pré-populado por script para facilitar os testes

### Observações 
Caso a tabela de contatos não esteja populada após a inicialização, basta rodar o projeto novamente. 

### Requisitos Funcionais 
- [X] RF01: O sistema deve permitir o cadastro de clientes com os seguintes dados: Nome,
CPF, Data de Nascimento e Endereço;
- [X] RF02: O sistema deve permitir a edição dos dados de um cliente cadastrado;
- [X] RF03: O sistema deve permitir a exclusão de um cliente cadastrado;
- [X] RF04: O sistema deve permitir a listagem de todos os clientes cadastrados;
- [X] RF05: O sistema deve permitir a busca de um cliente pelo Nome ou CPF;
- [X] RF06: O sistema deve permitir o cadastro de contatos para um cliente, contendo os seguintes dados: Tipo do Contato (Telefone, E-mail), Valor do Contato (número ou e-mail) e Observação;
- [X] RF07: O sistema deve permitir a edição dos contatos de um cliente;
- [X] RF08: O sistema deve permitir a exclusão de um contato de um cliente;
- [X] RF09: O sistema deve permitir a listagem de todos os contatos de um cliente.
específico.
### Regras de Negocio
- [X] RN01: Os campos Nome e CPF são obrigatórios no cadastro do cliente;
- [X] RN02: Os campos Tipo do Contato e Valor do Contato são obrigatórios no cadastro do contato;
- [X] RN03: O CPF informado deve ser único no sistema;
- [X] RN04: O Nome do cliente não pode estar vazio;
- [X] RN05: A Data de Nascimento deve ser válida;
- [X] RN06: Um cliente pode ter mais de um contato cadastrado;
- [X] RN07: Ao excluir um cliente, todos os seus contatos devem ser removidos do sistema;
- [X] RN08: O sistema deve validar os dados informados antes de permitir o cadastro ou edição.

## 📂 Estrutura do codigo
```
Comercio-SA/
src/
└── main/
    ├── java/
    │   └── br/com/muralis/comercio/
    │       ├── config/         # Configurações gerais da aplicação
    │       ├── controller/     # Controladores REST
    │       ├── dto/            # Data Transfer Objects
    │       │   ├── clientDTO/  # DTOs específicos para Cliente
    │       │   └── error/      # DTOs para tratamento de erros
    │       ├── entity/         # Entidades JPA (modelos do banco de dados)
    │       ├── exception/      # Manipulação global de exceções
    │       ├── repository/     # Interfaces JPA para acesso ao banco
    │       ├── script/         # Scripts de inicialização de dados
    │       └── service/        # Lógica de negócio da aplicação
    └── resources/
        ├── static/             # Arquivos estáticos (CSS, JS, imagens)
        ├── templates/          # Templates (ex: Thymeleaf)
        └── application.properties  # Configurações da aplicação

```

## SQL
O codigo sql é gerado diretamente pelo Hibernate e populado através de um script em java mas caso tenha necessidade esse é o sql para criação das tabelas 

```postgresql
create table client
(
    id              bigint generated by default as identity
        primary key,
    cpf             varchar(14)  not null
        constraint ukplnstg0h55xcbwkkf8iehxo71
            unique,
    data_nascimento date         not null,
    endereco        varchar(255),
    nome            varchar(100) not null
);

alter table client
    owner to admin;

create table contact
(
    id         bigint generated by default as identity
        primary key,
    observacao varchar(255),
    tipo       varchar(50)  not null,
    valor      varchar(100) not null,
    client_id  bigint
        constraint fkt0lxtgfimywi23cewqbmgdu62
            references client
);

alter table contact
    owner to admin;
```

----------------

## Requisições de Cliente
### Cadastro de cliente
```
url: localhost:8080/clients
```
Corpo da requisição
```json
{
    "nome":"exemplo",
    "cpf": "123.123.123-44",
    "dataNascimento": "2001-12-15",
    "endereco": "exemplo"
}
```

### Atualização de cliente
```
- Url:  localhost:8080/clients/1
```
Corpo da requisição
```json
{
    "nome":"exemplo",
    "cpf": "123.123.123-44",
    "dataNascimento": "2001-12-15",
    "endereco": "exemplo"
}
```

### Exclusão de cliente

Basta adicionar o id ao final da url
```
localhost:8080/clients/1
```
- Todos os contatos de um cliente são excluidos juntamente com ele.

### Busca de todos os Clientes
a busca de todos os clientes pode ser realizada sem filtro, adicionando parte de um nome ou parte de um cpf 
```
localhost:8080/clients
localhost:8080/clients?filter=123456789
localhost:8080/clients?filter=exemplo
```
### Busca de um cliente por id
Basta adicionar o id ao final da url
```
localhost:8080/clients/1
```
----------------
## Requisições de Contatos
### Buscar contato por id
```
localhost:8080/contacts/1
```
### Criar contato
Para criar um contato passe o id cliente pela url e corpo do objeto da requisição
```
localhost:8080/contacts/1 #Esse numero "1" é o id do cliente
```
```json
{
    "tipo":"telefone",
    "valor": "99999-9999",
    "observacao": "não obrigatorio"
}
```
### Atualizar contato
Para atualizar, passe o id do contato e o corpo do objeto na requisição
```
localhost:8080/contacts/1   #Esse numero "1" é o id do contato
```
```json
{
    "tipo":"telefone",
    "valor": "99999-9999",
    "observacao": "não obrigatorio"
}
```
### excluir contato
Passe o id do contato na url utilizando o metodo delete
```
localhost:8080/contacts/1 
```
------

