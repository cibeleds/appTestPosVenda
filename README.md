# Projeto de Automação de Teste E2E com Java, Appium e TestNG
Este projeto contém testes de automação E2E utilizando Java, Appium e TestNG. Os testes estão estruturados no padrão Page Object, facilitando a manutenção e reusabilidade do código.

## Pré-requisitos
Antes de começar, certifique-se de que você tenha as seguintes ferramentas instaladas:

- Java JDK
- Maven
- Appium (e suas dependências, como o Node.js)
- Emulador ou dispositivo físico para testar a aplicação

## Configuração do Ambiente
- Instale o Java JDK:
  
    [Download JDK](https://www.oracle.com/java/technologies/downloads/)

- Instale o Maven:


    [Download Maven](https://maven.apache.org/install.html)

- Instale o Node.js e o Appium:

    [Download Maven](https://nodejs.org/en/download)

- Após a instalação do Node.js, instale o Appium usando o comando:
<pre>
<code>
npm install -g appium
</code>
</pre>

### Configure um emulador:

Configure um emulador Android para testar os aplicativos. Para rodar localmente, você precisa ter um emulador aberto.

## Configuração do Projeto
- Clone o repositório:

<pre>
<code>
git clone https://github.com/raizen-energy/raizen-power-customer-app-automation-test.git
</code>
</pre>

- Navegue até o diretório do projeto:

<pre>
<code>
cd raizen-power-customer-app-automation-test
</code>
</pre>

- Instale as dependências do Maven:
<pre>
<code>
mvn clean install
</code>
</pre>

## Execução dos Testes
  Inicie o Appium Server:
  Abra um terminal e execute o comando:
<pre>
<code>
appium
</code>
</pre>

  Execute os testes:
  Utilize o seguinte comando Maven para executar os testes:
<pre>
<code>
mvn test
</code>
</pre>

## Estrutura do Projeto
src/main/java: Pages Objects
src/test/java: Testes automatizados e utils 
src/test/resources: Recursos para testes, como dados de teste (apk)
### Padrão Page Object
Os testes são estruturados no padrão Page Object. Cada página da aplicação tem uma classe correspondente no pacote pages, onde os elementos da página e as ações são definidos.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas ou enviar solicitações de pull.
