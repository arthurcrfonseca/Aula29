# Aula 29 — Padrão DAO (BookStore)

`Livro` com dois construtores e validações, interface `LivroDAO` e `LivroDAOSqlite` (tabela criada no construtor, `RETURN_GENERATED_KEYS`, `mapearLinha`, `Optional` no `buscarPorId`). O `Main` segue o roteiro da lista.

## Como rodar

Abra o terminal na pasta do projeto (onde está este README). É preciso ter o JDK 17 ou superior.

**macOS / Linux**

```bash
javac -encoding UTF-8 -cp "lib/*" -sourcepath src -d bin src/br/com/bookstore/main/Main.java
java -cp "bin:lib/*" br.com.bookstore.main.Main
```

**Windows**

```bat
javac -encoding UTF-8 -cp "lib/*" -sourcepath src -d bin src\br\com\bookstore\main\Main.java
java -cp "bin;lib/*" br.com.bookstore.main.Main
```

## Resultado esperado

IDs 1, 2 e 3; o livro 2 é encontrado; o ID 999 não gera erro; o catálogo é listado. Para repetir do zero, apague o arquivo `bookstore.db`.
