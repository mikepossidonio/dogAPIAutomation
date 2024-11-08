
# Documentação de Configuração e Execução de Testes para o Projeto DogAPI-Automation

## 1. Introdução

Este guia fornece instruções rápidas para configurar e executar os testes no projeto `dogapi-automation`, incluindo o uso do Allure para gerar relatórios de testes.

## 2. Estrutura do Projeto

A estrutura do projeto é a seguinte:

```
dogapi-automation
│
├── pom.xml                # Arquivo de configuração do Maven
├── src
│   ├── main               # Código fonte principal 
│   └── test
│       ├── java           # Pacote de classes de teste em Java
│       │   └── com
│       │       └── dogapi
│       │           └── tests
│       │               ├── runner  # Runner dos testes
│       │               ├── steps   # Implementação dos passos de teste
│       │               └── utils   # Utilidades para os testes
│       └── resources     
│           └── features   # Arquivos de features para o Cucumber
└── allure-results          # Diretório para os resultados dos testes Allure
```

## 3. Configuração do Ambiente

Certifique-se de ter **Java 11** e **Maven** instalados e configurados no `PATH`. Verifique o arquivo `pom.xml` para confirmar as dependências e plugins necessários para o projeto, incluindo o Allure.

## 4. Executando os Testes

1. **Compile o Projeto**:
   mvn clean compile
   ```

2. **Execute os Testes**:
   mvn test
   ```

## 5. Gerando e Visualizando Relatórios Allure

1. **Visualizar Relatório Interativo**:
   - Execute o comando abaixo para iniciar o servidor Allure e visualizar o relatório interativo:
     mvn allure:serve
     ```
   - O relatório será carregado automaticamente em uma página HTML no navegador.

2. **Gerar Relatório HTML Estático**:
   - Para gerar um relatório estático, utilize:
     mvn allure:report
     ```
   - O relatório será gerado na pasta `target/site`.

## 6. Observação

Para carregar o relatório HTML estático diretamente (sem o comando `mvn allure:serve`), é necessário servir os arquivos em um servidor virtual, como **Node.js** com `http-server`, **Python** (`python -m http.server`), ou outra ferramenta de servidor local.

Esse documento fornece um resumo das etapas necessárias para a configuração e execução dos testes com relatório no Allure.
