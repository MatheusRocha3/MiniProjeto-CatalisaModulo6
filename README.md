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
}
url :
localhost:8080/usuarios

para visualizar a lista de usuários acesse a requisição get insira a url:
localhost:8080/usuarios

requisição delete:
para deletar incira a url:
localhost/usuarios/1
(O número posterior à barra após a palavra usuários é referente ao id do usuário a ser buscado),
para deletar por id,
localhost/usuarios/1
(O número posterior à barra após a palavra usuários é referente ao id do usuário a ser buscado),


requisição patch:
para atualizar insira a url mais o id correspondente à ser atualizado.
localhost/usuarios/1
(O número posterior à barra após a palavra usuários é referente ao id do usuário a ser buscado),

corpo :
{
"atributo" : "valor" 
}

para visualizar uma embalagem por id 
requisição get:
localhost/embalagem/1
(O número posterior à barra após a palavra embalagens é referente ao id da embalagem à ser buscada),

para cadastrar:
requisição post:
{
"estadoDeCadastro" : "SAO_PAULO",
"numeroDeSerie" : "12345",
"marca" : "DORITOS",
}
url: 
localhost/embalagens/11111111111
(O número posterior à barra após a palavra embalagens é referente ao cpf da embalagem à ser buscado e verificado para então ser efetuado um cadastro),

Para deletar um usuário por cpf:
requisição delete
url:
localhost:/deletebycpf/11111111111
(O número posterior à barra após a palavra usuarios é referente ao cpf do usuário à ser buscado, para então, se encontrado ser deletado),

Para buscar um usuário por cpf:
requisição get:
url
localhost/11111111111

Equipe: Ana Clara ficou responsável pelas excessões e pela DTO.
Luiz Fernando ficou responsável pelos testes unitários.
Max William ficou responsável pelos cálculos e pelo corpo do api.
Matheus Felipe ficou responsável pela base do código, pelos testes no Postman e por manuntenções 




