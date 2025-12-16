# Climatic App

## Português (pt-BR)

### Visão Geral

Este projeto é uma aplicação Java simples para obter e exibir informações climáticas. Contém classes de modelo, DTOs e serviços para realizar requisições e tratar respostas.

### Requisitos

- Java 11+ instalado
- O arquivo `api_key.txt` na raiz do projeto contendo a chave da API (uma linha)

- `json.jar` (biblioteca JSON) — coloque no classpath ou em `lib/`

### Como compilar e executar

1. Abra um terminal na raiz do projeto.
2. Compile todos os fontes:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
```

3. Execute a aplicação:

```bash
java -cp out com.github.joaogavalentim.climatic.app.App
```

Observação: se o projeto estiver configurado com módulos (presença de `module-info.java`), prefira abrir em uma IDE (IntelliJ/VS Code) e executar a configuração de módulo, ou usar comandos de compilação/execução específicos para módulos.

### Estrutura do projeto

- `src/` - código-fonte Java
- `api_key.txt` - chave da API (não comitar em repositórios públicos)
- `bin/` - possíveis arquivos compilados ou build outputs

### Uso

Coloque sua chave da API em `api_key.txt` e execute a aplicação conforme os passos acima. A aplicação irá ler a chave e fazer requisições conforme implementado nos serviços.

### Licença

Este projeto não tem licença especificada. Adicione uma licença se desejar compartilhá-lo publicamente.

---

## English (en-US)

### Overview

This project is a simple Java application to fetch and display weather information. It includes model classes, DTOs and services to perform requests and handle responses.

### Requirements

- Java 11+ installed
- The file `api_key.txt` at the project root containing the API key (single line)

- `json.jar` (JSON library) — place it on the classpath or in `lib/`

### How to compile and run

1. Open a terminal at the project root.
2. Compile all sources:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
```

3. Run the application:

```bash
java -cp out com.github.joaogavalentim.climatic.app.App
```

Note: if the project uses Java modules (`module-info.java` present), consider opening the project in an IDE (IntelliJ/VS Code) and running with module support, or use module-aware compile/run commands.

### Project structure

- `src/` - Java source code
- `api_key.txt` - API key (do not commit to public repos)
- `bin/` - possible compiled outputs

### Usage

Place your API key in `api_key.txt` and run the app as shown above. The app will read the key and make requests according to the implemented services.

### License

No license specified. Add a license if you intend to publish this repository.

