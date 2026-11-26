# Gabarito — Herança e Polimorfismo em Java

Este documento apresenta as respostas das 40 questões teóricas e as soluções dos exercícios práticos.

# PARTE I — QUESTÕES TEÓRICAS

## Bloco A — Conceitos fundamentais

**1. O que é herança?**

É um mecanismo da POO que permite que uma classe herde atributos e métodos de outra classe, possibilitando reutilização e especialização de código.

**2. Diferença entre superclasse e subclasse?**

Superclasse é a classe que fornece membros para outras classes. Subclasse é aquela que herda esses membros.

**3. O que significa relação "é um"?**

Significa que a subclasse representa um tipo especializado da superclasse. Por exemplo, um cachorro é um animal.

**4. Finalidade de `extends`?**

Indicar que uma classe herda de outra.

**5. Construtores são herdados?**

Não. Construtores não são herdados. Entretanto, o construtor da superclasse participa da inicialização de um objeto da subclasse.

**6. Java permite herança múltipla de classes?**

Não. Uma classe Java pode estender diretamente apenas uma classe. Porém, pode implementar várias interfaces.

**7. Diferença entre herança e composição?**

Herança representa uma relação "é um". Composição representa uma relação "tem um". Por exemplo, um carro é um veículo, mas possui um motor.

**8. Uma subclasse herda membros privados?**

Os membros privados fazem parte do estado da superclasse, mas não são diretamente acessíveis pela subclasse. O acesso pode ocorrer por métodos públicos ou protegidos fornecidos pela superclasse.

## Bloco B — Modificadores e construtores

**9. Diferença entre `private`, `protected` e `public`?**

- `private`: acesso restrito à própria classe.
- `protected`: acesso no mesmo pacote e também pelas subclasses, inclusive em outros pacotes, respeitadas as regras da linguagem.
- `public`: acesso de qualquer classe.

**10. Uma subclasse acessa diretamente um atributo privado?**

Não. Pode utilizar métodos acessíveis da superclasse, como getters e setters.

**11. Finalidade de `super`?**

Permite acessar membros da superclasse e chamar seu construtor.

**12. O que acontece quando não escrevemos `super()`?**

O compilador tenta inserir automaticamente uma chamada ao construtor sem argumentos da superclasse, desde que não exista outra chamada explícita de construtor na primeira instrução.

**13. Por que pode ocorrer erro quando a superclasse possui apenas construtores com parâmetros?**

Porque o Java tenta chamar `super()` automaticamente, mas esse construtor não existe. É necessário chamar explicitamente um construtor disponível, como `super("Rex")`.

**14. Ordem de execução dos construtores?**

Primeiro ocorre a inicialização da superclasse, depois a inicialização da subclasse. Em uma cadeia de herança, a inicialização começa pela classe mais alta e segue até a classe mais específica.

**15. É possível chamar métodos da superclasse com `super`?**

Sim.

```java
@Override
public void emitirSom() {
    super.emitirSom();
    System.out.println("Au au!");
}
```

## Bloco C — Override e Overload

**16. O que é sobrescrita?**

É quando uma subclasse fornece uma implementação própria para um método herdado da superclasse.

**17. O que é sobrecarga?**

É a existência de métodos com o mesmo nome, mas com listas de parâmetros diferentes.

**18. Diferença entre override e overload?**

Override modifica a implementação de um método herdado. Overload cria diferentes versões de um método, variando seus parâmetros.

**19. `@Override` é obrigatória?**

Não. É opcional, mas recomendada porque permite ao compilador verificar se realmente estamos sobrescrevendo um método.

**20. É possível sobrecarregar alterando somente o retorno?**

Não. A lista de parâmetros precisa ser diferente.

**21. Um método privado pode ser sobrescrito?**

Não. Métodos privados não são herdados como métodos sobrescrevíveis.

**22. Um método `final` pode ser sobrescrito?**

Não. A palavra-chave `final` impede a sobrescrita.

**23. Métodos estáticos são sobrescritos?**

Não. Métodos estáticos são associados à classe e podem ser ocultados por métodos estáticos de uma subclasse com assinatura compatível. A seleção ocorre conforme o tipo usado para acessar o método, e não pelo tipo real do objeto.

**24. Uma subclasse pode reduzir a visibilidade de um método público?**

Não. Ao sobrescrever um método, a subclasse não pode reduzir sua visibilidade.

## Bloco D — Polimorfismo e conversões

**25. O que é polimorfismo?**

É a capacidade de tratar objetos de diferentes subclasses por meio de uma referência comum, permitindo que cada objeto execute sua implementação específica de métodos sobrescritos.

**26. Diferença entre tipo da referência e tipo real?**

O tipo da referência é aquele declarado na variável. O tipo real é a classe do objeto efetivamente criado.

**27. Em `Animal animal = new Cachorro()`, quais são os tipos?**

- Referência: `Animal`.
- Objeto: `Cachorro`.

**28. Finalidade do upcasting?**

Converter uma referência de uma subclasse para uma referência de sua superclasse, permitindo tratar o objeto de forma mais genérica.

**29. Upcasting precisa ser explícito?**

Não. É realizado implicitamente.

**30. O que é downcasting?**

É converter uma referência de uma superclasse para uma referência de uma subclasse.

**31. O que acontece em um downcasting incorreto?**

Pode ocorrer uma `ClassCastException` em tempo de execução.

**32. Para que serve `instanceof`?**

Verifica se um objeto é compatível com determinado tipo antes de realizar uma conversão.

**33. Podemos executar `animal.latir()` diretamente?**

Não, se `latir()` não estiver declarado em `Animal`. O compilador considera o tipo da referência, e não apenas o tipo real do objeto.

**34. O que determina qual método sobrescrito será executado?**

O tipo real do objeto em tempo de execução.

## Bloco E — Classes abstratas e boas práticas

**35. O que é uma classe abstrata?**

É uma classe que não pode ser instanciada diretamente e que serve como base para outras classes.

**36. É possível instanciar uma classe abstrata?**

Não. É possível, porém, declarar uma referência do tipo abstrato e atribuir a ela um objeto de uma subclasse concreta.

**37. Uma classe abstrata pode ter métodos concretos?**

Sim. Pode possuir métodos abstratos e métodos com implementação.

**38. Uma classe abstrata pode possuir construtores?**

Sim. Eles são executados durante a construção dos objetos das subclasses.

**39. Uma classe concreta precisa implementar os métodos abstratos herdados?**

Sim, caso ainda não os tenha herdado de alguma implementação concreta. Caso contrário, ela também deverá ser declarada abstrata.

**40. Quando preferir composição à herança?**

Quando a relação entre os objetos for "tem um" em vez de "é um", ou quando a composição proporcionar maior flexibilidade. Por exemplo, um carro possui um motor; não é um motor.

---

# PARTE II — EXERCÍCIOS PRÁTICOS

## Exercício 1 — Pessoa e Aluno

**Objetivo:** utilizar herança, construtores e `super`.

### Pessoa.java

```java
public class Pessoa {
    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void apresentar() {
        System.out.println("Nome: " + nome);
    }
}
```

### Aluno.java

```java
public class Aluno extends Pessoa {
    private int matricula;

    public Aluno(String nome, int matricula) {
        super(nome);
        this.matricula = matricula;
    }

    public void mostrarMatricula() {
        System.out.println("Matrícula: " + matricula);
    }
}
```

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Luis", 12345);

        aluno.apresentar();
        aluno.mostrarMatricula();
    }
}
```

**Explicação:**

`Aluno` herda de `Pessoa` por meio de `extends`.

O construtor de `Aluno` utiliza `super(nome)` para chamar o construtor da superclasse e inicializar o atributo herdado.

O atributo `nome` foi declarado como `protected`, permitindo acesso direto pela subclasse.

## Exercício 2 — Sobrescrita de métodos

**Objetivo:** implementar override.

### Animal.java

```java
public class Animal {
    public void emitirSom() {
        System.out.println("Som genérico");
    }
}
```

### Cachorro.java

```java
public class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au au!");
    }
}
```

### Gato.java

```java
public class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }
}
```

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cachorro cachorro = new Cachorro();
        Gato gato = new Gato();

        animal.emitirSom();
        cachorro.emitirSom();
        gato.emitirSom();
    }
}
```

Saída:

```text
Som genérico
Au au!
Miau!
```

**Explicação:**

As subclasses fornecem implementações próprias para o método herdado `emitirSom()`.

A anotação `@Override` permite ao compilador verificar se a sobrescrita está correta.

## Exercício 3 — Polimorfismo

**Objetivo:** utilizar referências da superclasse para armazenar objetos de subclasses diferentes.

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Cachorro();
        Animal animal2 = new Gato();

        animal1.emitirSom();
        animal2.emitirSom();
    }
}
```

Saída:

```text
Au au!
Miau!
```

**Respostas:**

1. As referências são do tipo `Animal`.
2. Os objetos reais são, respectivamente, `Cachorro` e `Gato`.
3. Cada objeto executa sua própria implementação sobrescrita de `emitirSom()`.

O compilador permite chamar `emitirSom()` porque esse método está declarado em `Animal`.

Em tempo de execução, o Java identifica o tipo real do objeto e seleciona a implementação correspondente.

## Exercício 4 — Downcasting e instanceof

**Objetivo:** compreender os riscos do downcasting.

Código:

```java
Animal animal = new Gato();

Cachorro cachorro = (Cachorro) animal;
```

**Respostas:**

1. O código compila, pois a conversão explícita entre esses tipos relacionados é permitida.
2. A conversão falha em tempo de execução.
3. É lançada uma `ClassCastException`.
4. Podemos utilizar `instanceof` antes da conversão.

Solução segura:

```java
Animal animal = new Gato();

if (animal instanceof Cachorro) {
    Cachorro cachorro = (Cachorro) animal;
    cachorro.emitirSom();
} else {
    System.out.println("O objeto não é um cachorro.");
}
```

Alternativa em Java 17:

```java
Animal animal = new Gato();

if (animal instanceof Cachorro cachorro) {
    cachorro.emitirSom();
} else {
    System.out.println("O objeto não é um cachorro.");
}
```

**Explicação:** o `instanceof` verifica se o objeto pode ser tratado como `Cachorro`. Como o objeto real é um `Gato`, a condição retorna `false`.

## Exercício 5 — Construtores e super

**Objetivo:** inicializar atributos herdados por meio do construtor da superclasse.

### Veiculo.java

```java
public class Veiculo {
    protected String modelo;

    public Veiculo(String modelo) {
        this.modelo = modelo;
    }

    public void mostrarModelo() {
        System.out.println("Modelo: " + modelo);
    }
}
```

### Carro.java

```java
public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String modelo, int quantidadePortas) {
        super(modelo);
        this.quantidadePortas = quantidadePortas;
    }

    public void mostrarPortas() {
        System.out.println("Quantidade de portas: " + quantidadePortas);
    }
}
```

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Sedan", 4);

        carro.mostrarModelo();
        carro.mostrarPortas();
    }
}
```

Saída:

```text
Modelo: Sedan
Quantidade de portas: 4
```

**Explicação:**

O construtor de `Carro` chama `super(modelo)`, executando o construtor de `Veiculo`.

O atributo `modelo` é inicializado pela superclasse, enquanto `quantidadePortas` é inicializado pela própria subclasse.

## Exercício 6 — Classe abstrata

**Objetivo:** implementar uma classe abstrata e um método abstrato.

### Forma.java

```java
public abstract class Forma {
    public abstract double calcularArea();
}
```

### Quadrado.java

```java
public class Quadrado extends Forma {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
```

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Quadrado quadrado = new Quadrado(5);

        System.out.println(quadrado.calcularArea());
    }
}
```

Saída:

```text
25.0
```

**Explicação:**

`Forma` é abstrata e possui um método abstrato. Por isso, não pode ser instanciada diretamente.

`Quadrado` herda de `Forma` e implementa `calcularArea()`.

A implementação é obrigatória porque `Quadrado` é uma classe concreta.

---

# PARTE III — DESAFIO FINAL

## Sistema de funcionários

**Objetivo:** reunir herança, construtores, classes abstratas, sobrescrita e polimorfismo.

### Funcionario.java

```java
public abstract class Funcionario {
    protected String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public abstract double calcularSalario();

    public void mostrarNome() {
        System.out.println("Funcionário: " + nome);
    }
}
```

### Gerente.java

```java
public class Gerente extends Funcionario {
    private double bonus;

    public Gerente(String nome, double bonus) {
        super(nome);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return 5000.0 + bonus;
    }
}
```

### Desenvolvedor.java

```java
public class Desenvolvedor extends Funcionario {
    private int horasTrabalhadas;

    public Desenvolvedor(String nome, int horasTrabalhadas) {
        super(nome);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * 50.0;
    }
}
```

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Funcionario funcionario1 =
            new Gerente("Ana", 1500.0);

        Funcionario funcionario2 =
            new Desenvolvedor("Carlos", 160);

        funcionario1.mostrarNome();
        System.out.println(
            "Salário: R$ " + funcionario1.calcularSalario()
        );

        funcionario2.mostrarNome();
        System.out.println(
            "Salário: R$ " + funcionario2.calcularSalario()
        );
    }
}
```

Saída:

```text
Funcionário: Ana
Salário: R$ 6500.0
Funcionário: Carlos
Salário: R$ 8000.0
```

## Análise do desafio

**1. Onde ocorre a herança?**

Nas declarações:

```java
class Gerente extends Funcionario
```

```java
class Desenvolvedor extends Funcionario
```

Ambas as classes herdam de `Funcionario`.

**2. Onde ocorre o uso de `super`?**

Nos construtores:

```java
super(nome);
```

Essa instrução chama o construtor da superclasse e inicializa o nome do funcionário.

**3. Onde ocorre a abstração?**

Na declaração:

```java
public abstract class Funcionario
```

A classe não pode ser instanciada diretamente.

**4. Onde ocorre a sobrescrita?**

Nas implementações de `calcularSalario()` em `Gerente` e `Desenvolvedor`.

**5. Onde ocorre o polimorfismo?**

Nas declarações:

```java
Funcionario funcionario1 = new Gerente("Ana", 1500.0);
Funcionario funcionario2 = new Desenvolvedor("Carlos", 160);
```

As duas referências possuem o tipo `Funcionario`, mas apontam para objetos de classes diferentes.

Quando `calcularSalario()` é chamado, cada objeto executa sua própria implementação.

---

# PARTE IV — RESUMO PARA REVISÃO

| Conceito | Significado | Palavra-chave ou recurso |
|---|---|---|
| Herança | Reutilizar e especializar uma classe | `extends` |
| Superclasse | Classe que fornece membros | — |
| Subclasse | Classe que herda membros | — |
| Construtor da superclasse | Inicializar a parte herdada | `super()` |
| Acesso à superclasse | Acessar implementação herdada | `super.metodo()` |
| Sobrescrita | Redefinir método herdado | `@Override` |
| Sobrecarga | Mesmo nome com parâmetros diferentes | Overload |
| Polimorfismo | Diferentes comportamentos por referência comum | Despacho dinâmico |
| Upcasting | Subclasse para superclasse | Implícito |
| Downcasting | Superclasse para subclasse | Cast explícito |
| Verificação de tipo | Verificar compatibilidade de tipo | `instanceof` |
| Classe abstrata | Classe que não pode ser instanciada diretamente | `abstract` |
| Método abstrato | Método sem implementação | `abstract` |
| Impedir herança | Impedir que uma classe seja estendida | `final` |
| Impedir sobrescrita | Impedir redefinição de método | `final` |

## Erros comuns em provas

1. Afirmar que construtores são herdados. **Falso.**
2. Afirmar que Java permite herança direta de várias classes. **Falso.**
3. Afirmar que métodos privados podem ser sobrescritos. **Falso.**
4. Afirmar que métodos estáticos são sobrescritos dinamicamente. **Falso.**
5. Afirmar que uma classe abstrata não pode ter construtores. **Falso.**
6. Afirmar que uma classe abstrata não pode possuir métodos concretos. **Falso.**
7. Afirmar que o tipo da referência determina qual implementação sobrescrita será executada. **Falso.**
8. Afirmar que o tipo da referência determina quais métodos podem ser acessados diretamente. **Verdadeiro.**
9. Afirmar que o upcasting é implicitamente permitido. **Verdadeiro.**
10. Afirmar que um downcasting incorreto pode provocar `ClassCastException`. **Verdadeiro.**
11. Afirmar que `@Override` é obrigatória. **Falso.**
12. Afirmar que uma subclasse pode reduzir a visibilidade de um método público sobrescrito. **Falso.**

**Recomendação de estudo:** tente resolver novamente os seis exercícios sem consultar o gabarito. Em seguida, modifique os exemplos para criar novos cenários. Isso ajuda a verificar se você compreendeu os mecanismos, em vez de apenas memorizar os códigos.