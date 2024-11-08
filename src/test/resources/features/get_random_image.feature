# language: pt

Funcionalidade: Obter uma imagem aleatória de um cão

  Cenário: Solicitar uma imagem aleatória com sucesso
    Dado que eu tenha Uma url válida da dogAPI
    Quando envio uma solicitação para obter uma imagem aleatória de um cão
    Então o código de status da resposta deve ser 200
    E a resposta deve conter uma URL de imagem
    E a resposta deve ter a chave status como "success"

  Cenário: Tentar obter uma imagem aleatória usando o método PUT
    Dado que eu tenha Uma url válida da dogAPI
    Quando envio uma solicitação PUT para obter uma imagem aleatória de um cão
    Então o código de status da resposta deve ser 405
    E a resposta deve ter a chave status como "error"

  Cenário: Verificar tempo de resposta para obter imagem aleatória
    Dado que eu tenha Uma url válida da dogAPI
    Quando envio uma solicitação para obter uma imagem aleatória de um cão
    Então o código de status da resposta deve ser 200
    E o tempo de resposta deve ser menor que 1 segundo

  Cenário: Verificar o formato da URL de imagem
    Dado que eu tenha Uma url válida da dogAPI
    Quando envio uma solicitação para obter uma imagem aleatória de um cão
    Então o código de status da resposta deve ser 200
    E a URL de imagem deve começar com "https://"
