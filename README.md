# teste-dxc

JAVA '11'
Maven 3+
H2 Database (Dados em memória)
Authentication: oAuth2 

IDE utilizada para rodar: 'intellij community edition'

IDE de testes das APIs: Postman

Senário de teste:
Gerar token para acessar as APIs do sistema: 

URL: localhost:8080/oauth/token 'POST'

Body -> {form-data:
grant_type : password
username : Toni
password : 123
}

Headers {
grant_type : password
username : Toni
password : 123
}


Listagem de Clientes: localhost:8080/cliente-api/list  'GET'

Autenticação: Authorization -> Bearer Token(add o token que retorna da API oauth).


Cadastro ou Update de Cliente: localhost:8080/cliente-api/cadastro-update  'POST'

Autenticação: Authorization -> Bearer Token(add o token que retorna da API oauth).


Request:
Body -> raw: JSON:

Exemplo request Cadastro:
{
    "nome":"teste Cadastro",
    "cpf":"1111111111333",
    "dataNascimento":"2000-03-01",
    "telefone":"99995555666",
    "email":"teste@teste",
    "endereco":"aldeia, Cameta, PA"
}

Exemplo request Update:
{
    "id":4,
    "nome":"teste update",
    "cpf":"1111111111333",
    "dataNascimento":"2000-03-10",
    "telefone":"99995555666",
    "email":"teste@teste",
    "endereco":"aldeia, pacaja"
}



Delete Cliente: localhost:8080/cliente-api/delete 'DELETE'

Autenticação: Authorization -> Bearer Token(add o token que retorna da API oauth).


Request:
Body -> raw: JSON:

Exemplo request Cadastro:
{
    "id":4,
    "nome":"teste Cadastro",
    "cpf":"1111111111333",
    "dataNascimento":"2000-03-01",
    "telefone":"99995555666",
    "email":"teste@teste",
    "endereco":"aldeia, Cameta, PA"
}


Ambos precisam do token de Autenticação: Authorization -> Bearer Token(add o token que retorna da API oauth).

Buscar Cliente por CPF: localhost:8080/cliente-api/get-by-cpf?cpf=00000000000   'GET'

Buscar Cliente por ID: localhost:8080/cliente-api/get-by-id?id=4   'GET'

