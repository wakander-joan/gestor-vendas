# Instruções para Testar o Projeto

## Requisitos

### Certifique-se de que sua máquina tenha os seguintes softwares instalados:

- Java 17 ou superior.
- Maven para gerenciamento de dependências.
- PostgreSQL configurado e em execução.
- Um cliente HTTP como o Postman.

## Passos para Rodar o Projeto


### Configure o Banco de Dados:

Crie um banco de dados no PostgreSQL com o nome especificado no application.yml.

Atualize as configurações de conexão no arquivo mencionado caso necessário (usuário, senha, URL do banco).


### Build e Execute o Projeto:

- mvn clean install
- mvn spring-boot:run

### Atributos de qualidade
- Segurança > Disponibilidade > Escalabilidade 
- Foco no back-end

### Importe a Collection do Postman:
- Disponibilizarei uma Collection online 
[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://god.gw.postman.com/run-collection/40650345-c7d939ee-829c-47e9-8694-c5301655ef0b?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D40650345-c7d939ee-829c-47e9-8694-c5301655ef0b%26entityType%3Dcollection%26workspaceId%3D2da1e20d-fa21-47c8-8d7d-51d6b6e67531)

Disponibilizarei a Collectio no repositório também. 
#### docs/postman-collection/Gestao-Vendas.postman_collection.json

- Importe-a no Postman para facilitar os testes das APIs.
- Utilize para executar as requisições disponíveis na Collection

### Acesso a API:
- A API estará disponível no endereço padrão http://localhost:8080.

### Clone o Repositório:
git clone https://github.com/wakander-joan/gestor-vendas.git


## Teste a Aplicação
- Ultilize as seguintes rotas para interagir com o sistema:
- Cadastra Cliente POST
- Cadastra Produto POST
- Abre Venda POST
- Fecha Venda PATCH
- Busca Venda GET
- Etc...

### Observações
Para feedbacks ou problemas, entre em contato por meio das issues no GitHub.

### Boa sorte ao testar a aplicação!

