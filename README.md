# MiniProjeto-CatalisaModulo6

API que permite cadastro de usuário e  embalagens para acúmulo de pontos.
As embalagens podem ser trocadas por pontos e os pontos podem ser usados em "compras" de produtos.
Para cadastrar um usuário o endpoint post, com o path
requisição post:
corpo:

{
"nomeUsuario": "nome",
"cpf": "11111111111",
"email": "nome@dominio.com",
"pontos": 0
}
url :
localhost:8080/usuarios

para acessar a lista de usuários acesse a requisição get insira a url:
localhost:8080/usuarios
requisição delete:
para deletar incira a url:
localhost:8080/usuarios/1
mais seu id:
localhost:8080/usuarios/1
requisição patch:
para atualizar insira a url mais o id correspondente da atualização:
localhost:8080/usuarios/1
corpo :
{
"atributo" : "valor" 
}

requisição get:
para buscar o usuário e ver sua pontuação insira requisição get e a url com o id:
localhost:8080/usuarios/1

O recurso de cadastrar embalagem ainda não está funcionando por razões desconhecidas, bug a ser resolvido.
para visualizar uma embalagem
requisição get:
localhost:8080/embalagem/1

para cadastrar:
requisição post:
{
"estadoDeCadastro" : "SAO_PAULO",
"numeroDeSerie" : "12345",
"marca" : "DORITOS",
"usuario" : "id" : 1
}
}
'
}

Equipe: Ana Clara ficou responsável pelas excessões e pela DTO.
Luiz Fernando ficou responsável pelos testes unitários.
Max William ficou responsável pelos cálculos e pelo corpo do api.
Matheus Felipe ficou responsável pela base do código, pelos testes no Postman e por manuntenções 




