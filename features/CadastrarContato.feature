Feature: Cadastrar Contatos
	Como um usuário autenticado no sistema
	Eu quero cadastrar contatos em minha agenda
	Para que eu possa gerenciar meus contatos
	
Background: Autenticacao de Usuario
	Realizar o acesso do usuário à sua agenda de contatos
	
	Given Acessar a pagina de autenticacao de usuario
	And Informar o email de acesso "testador@outlook.com"
	And Informar a senha de acesso "@Teste123"
	When Solicitar a realizacao do acesso
	Then Entao sistema autentica o usuario com sucesso
	
Scenario Outline: Cadastro de Contatos com sucesso
	Realizar o cadastro de um contato com sucesso
	
	Given Acessar a pagina de cadastro de contatos
	And Informar o nome do contato <nome>
	And Informar a data de nascimento <datanasc>
	And Informar o telefone <telefone>
	And Informar o email <email>
	When Solicitar a realizacao do cadastro
	Then Sistema realiza o cadastro do contato com sucesso
	
	Examples:
	| nome            | datanasc     | telefone         | email                 |
	| "Ana Paula"     | "01/10/1990" | "21987650123" | "anapaula@gmail.com"     |
	| "Pedro Souza"   | "10/05/1985" | "21912330812" | "pedrosouza@gmail.com"   |
	| "Beatriz Silva" | "20/06/1992" | "21987218712" | "beatrizsilva@gmail.com" |
	