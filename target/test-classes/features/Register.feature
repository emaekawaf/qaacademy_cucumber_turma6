#language:pt
@Register
Funcionalidade: (Feature) Como usuário do site Register
    Eu desejo realizar um cadastro
    Para validar se foi cadastrado com sucesso

 @Test001
  Cenario: (Scenario) Validar cadastro com sucesso no site Register
    Dado que eu acesso o site Register
    Quando preencho o campo nome com valor "Elaine"
    E o campo sobrenome com valor "Maekawa"
    E o endereço com o valor "Rua Agostinho Gomes, 1326 Apto 1074"
    E o email com o valor "emaekawaf@hotmail.com"
    E o telefone com o valor "13997072607"
    E clico na opção de sexo feminino
    E seleciono a segunda checkbox de hobbies
    E seleciono "Java" dentro do dropdown de skills
    E seleciono um país da lista
    E seleciono o ano "1994", o mês "March" e o dia "14"