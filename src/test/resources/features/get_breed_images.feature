# language: pt
Funcionalidade: Obter imagens de uma raça específica

  Cenário: Solicitar imagens de uma raça existente
    Dado que eu tenha Uma url válida da dogAPI
    Quando envio uma solicitação para obter imagens da raça "retriever"
    Então o código de status da resposta deve ser 200
    E a resposta deve conter uma lista de URLs de imagem

  Cenário: Solicitar imagens de uma raça inexistente
    Dado que eu tenha Uma url válida da dogAPI
    Quando envio uma solicitação para obter imagens da raça "inexistente"
    Então o código de status da resposta deve ser 404
