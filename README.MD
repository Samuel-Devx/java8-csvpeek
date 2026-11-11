# CSVPeek ☕

Um projeto desenvolvido em Java para trabalhar com arquivos CSV, fazendo leitura, organização e análise de dados utilizando Streams e Expressões Lambda.

## Sobre o projeto

O CSVPeek surgiu como uma forma de colocar em prática meus estudos em Java, principalmente trabalhando com Collections, Streams, Expressões Lambda e manipulação de arquivos.

A ideia foi desenvolver uma pequena ferramenta que conseguisse ler arquivos CSV, transformar seus dados em listas e realizar algumas operações sobre essas informações.

Durante o desenvolvimento, também aproveitei para praticar organização de código, tratamento de exceções e criação de testes automatizados.

## Funcionalidades

- Leitura de arquivos CSV.
- Ignora automaticamente a primeira linha do arquivo (cabeçalho).
- Transforma cada linha em um array de Strings.
- Retorna os dados em uma lista.
- Calcula a média de uma coluna numérica.
- Ignora valores vazios, inválidos ou inexistentes durante o cálculo.
- Possui validações para evitar erros com índices negativos e listas nulas.

## Tecnologias utilizadas

- Java 8
- Maven
- Java Streams
- Expressões Lambda
- Collections
- JUnit 5

## Como funciona?

O projeto possui duas operações principais:

### 1. Leitura do CSV

O método `readCsv()` recebe o caminho de um arquivo e realiza sua leitura utilizando `Files.lines()`.

Depois, utiliza Streams para ignorar o cabeçalho, separar os valores de cada linha e reunir os resultados em uma lista.

### 2. Cálculo da média

O método `average()` recebe a lista de dados e o índice da coluna que deseja analisar.

Durante o processamento, são ignorados valores nulos, vazios e que não representam números válidos.

Ao final, é calculada a média dos valores encontrados. Caso não existam valores numéricos válidos, o método retorna `0.0`.

## Exemplo de utilização

```java
CsvReader csvReader = new CsvReader();

List<String[]> csvData = csvReader.readCsv(
    "src/main/java/samukadev/csvpeek/files/example2.csv"
);

// Calculando a média da terceira coluna
double result = csvReader.average(csvData, 2);

System.out.println(result);
```

## Testes

Também desenvolvi testes automatizados utilizando JUnit 5 para verificar o comportamento das funcionalidades.

Alguns cenários testados:

- Leitura correta do arquivo.
- Verificação da quantidade de registros e colunas.
- Ignorar o cabeçalho.
- Leitura de arquivo vazio.
- Tratamento de arquivo inexistente.
- Cálculo da média.
- Ignorar valores inválidos.
- Validação de índice negativo.
- Validação de lista nula.

Para executar os testes:

```bash
mvn clean test
```

## Limitações atuais

Esta primeira versão trabalha com arquivos CSV simples, separados por vírgula.

Ainda não possui tratamento completo de campos entre aspas que contenham vírgulas, nem de caracteres de escape.

A primeira linha também é considerada automaticamente como cabeçalho.

## O que aprendi com esse projeto

O CSVPeek foi uma oportunidade de sair um pouco da teoria e começar a aplicar os conceitos de Java em algo prático.

Durante o desenvolvimento, consegui trabalhar melhor com Streams, entender o funcionamento de operações intermediárias e terminais, praticar tratamento de exceções e perceber a importância dos testes automatizados.

Sei que ainda existem melhorias que podem ser feitas, mas esse projeto representa uma parte importante da minha evolução com Java.

---

**Desenvolvido por Samuel Duarte**

*Estudando, praticando e evoluindo um pouco a cada projeto.*