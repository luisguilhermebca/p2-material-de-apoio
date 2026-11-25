# Laboratório de Interfaces — Java

Projeto pequeno para testar, executar e modificar exemplos de interfaces em Java sem precisar criar cada exemplo do zero.

## Requisitos

- JDK 17 ou superior.
- Terminal aberto na pasta do projeto.

## Como executar

Compile todos os arquivos:

```java
javac *.java
```

Execute o programa:

```java
java Main
```

O menu permite executar demonstrações de:

1. Contratos e implementação de interfaces.
2. Implementação de múltiplas interfaces.
3. Polimorfismo e tipo da referência.
4. Métodos `default` e conflitos entre interfaces.
5. Interfaces funcionais e expressões lambda.
6. Pequenos desafios com correção imediata.

## Como estudar usando o projeto

1. Execute uma opção do menu.
2. Leia a saída e identifique qual conceito está sendo demonstrado.
3. Abra os arquivos `.java` relacionados.
4. Altere o código e execute novamente.
5. Antes de compilar, tente prever se a alteração funciona ou gera erro.

## Testes recomendados

### Teste 1 — Contrato

Abra `Pagamento.java` e adicione:

```java
void cancelar();
```

Tente compilar. Observe quais classes precisam implementar o novo método.

Depois, implemente `cancelar()` em `Pix` e `Cartao`.

### Teste 2 — Múltiplas interfaces

Abra `Atleta.java`. Remova temporariamente a implementação de `correr()`.

Tente compilar. Depois, transforme `Atleta` em uma classe abstrata e observe a diferença.

### Teste 3 — Polimorfismo

Em `Demonstracoes.java`, experimente adicionar:

```java
primeiro.abanarRabo();
```

A compilação falhará porque `primeiro` foi declarado como `Animal`.

Depois, teste o `instanceof` já demonstrado no projeto.

### Teste 4 — Conflito de default

Abra `ResolucaoConflito.java` e remova o método `executar()`.

Tente compilar. O conflito entre `OrigemA` e `OrigemB` ficará evidente.

### Teste 5 — Interface funcional

Abra `Operacao.java`. Adicione um segundo método abstrato.

Tente utilizar uma expressão lambda novamente. Observe o erro: uma lambda precisa corresponder a uma interface funcional.

## Organização

- `Main.java`: menu principal.
- `Demonstracoes.java`: exemplos executáveis.
- `Desafios.java`: perguntas com correção.
- `Pagamento.java`, `Pix.java`, `Cartao.java` e `Caixa.java`: contrato e polimorfismo.
- `Nadador.java`, `Corredor.java` e `Atleta.java`: múltiplas interfaces.
- `Animal.java`, `Cachorro.java` e `Gato.java`: polimorfismo e métodos default.
- `OrigemA.java`, `OrigemB.java` e `ResolucaoConflito.java`: conflito entre métodos default.
- `Operacao.java`: interface funcional.

## Observação

Os exemplos que precisam gerar erro de compilação aparecem como desafios ou comentários. Eles não ficam ativos no projeto principal, para que todos os arquivos possam ser compilados juntos.
