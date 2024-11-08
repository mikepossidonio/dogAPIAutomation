# language: pt

Funcionalidade: Listar todas as raças de cães

  Cenário: Solicitar a lista de raças com sucesso
    Dado que eu tenha Uma url válida da dogAPI
    Quando envio uma solicitação para listar todas as raças
    Então o código de status da resposta deve ser 200
    E a resposta deve conter uma lista de raças
    E a resposta deve ter a chave status como "success"

  Cenário: Tentar listar raças usando um endpoint incorreto
    Dado que eu tenha Uma url inválida da dogAPI
    Quando envio uma solicitação para um endpoint incorreto
    Então o código de status da resposta deve ser 404
    E a resposta deve ter a chave status como "error"

  Cenário: Tentar listar raças usando o método POST
    Dado que eu tenha Uma url válida da dogAPI
    Quando envio uma solicitação POST para listar todas as raças
    Então o código de status da resposta deve ser 405
    E a resposta deve ter a chave status como "error"

  Cenário: Verificar tempo de resposta para listar todas as raças
    Dado que eu tenha Uma url válida da dogAPI
    Quando envio uma solicitação para listar todas as raças
    Então o código de status da resposta deve ser 200
    E o tempo de resposta deve ser menor que 2 segundos
