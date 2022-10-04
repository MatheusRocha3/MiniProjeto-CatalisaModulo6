# MiniProjeto-CatalisaModulo6
API que gerencia uma plataforma de registro de usuário e embalagens para acúmulo de
pontos e troca por prêmios.
Para cadastrar um usuário o Endpoint post, com o path
requisição post:
corpo:
{
"nomeUsuario": "nome",
"cpf": "11111111111",
"email": "nome@dominio.com",
}
“URL” :
localhost:8080/usuarios
para visualizar a lista de usuários acesse a requisição get insira a “URL”:
localhost:8080/usuarios
requisição delete:
para deletar incira a url:
localhost:8080/usuarios/11111111111
(O número posterior à barra após a palavra usuários é referente ao “CPF” do usuário a
ser buscado)
requisição patch:
para atualizar insira a url mais o “CPF” correspondente a ser atualizado.
localhost/usuarios/11111111111
(O número posterior à barra após a palavra usuários é referente ao “CPF” do usuário a
ser buscado).Corpo:
{
"atributo" : "valor"
}
para visualizar uma embalagem por número de série
requisição get:
localhost/embalagem/12345
(O número posterior à barra após a palavra embalagens é referente ao número de série
da embalagem à ser buscada),
para cadastrar:
requisição post:
{
"estadoDeCadastro" : "SAO_PAULO",
"numeroDeSerie" : "12345",
"marca" : "DORITOS",
}
url:
localhost:8080/usuario/11111111111/embalagem
(O número posterior à barra após a palavra usuario é referente ao “CPF” do usuário
proprietário da embalagem à ser buscada e verificada para então ser efetuado um
cadastro),
Para buscar um usuário por cpf:
requisição get:
“URL”
Localhost:8080/11111111111
Equipe:
Ana Clara ficou responsável pelas exceções e pela DTO.
Luiz Fernando ficou responsável pelos testes unitários.
Max William ficou responsável pelos cálculos e pelo corpo da API.Matheus Felipe ficou responsável pela base do código, pelos testes no Postman e por
manutenções 
 
 