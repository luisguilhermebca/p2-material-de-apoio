# Gabarito — Interfaces em Programação Orientada a Objetos (Java)

## 1. Parte 1 — Fundamentos

**1. O que é uma interface em Java?**

É uma estrutura que define um contrato de métodos e comportamentos que uma classe deve disponibilizar ao implementá-la.

**2. Qual problema uma interface resolve?**

Permite estabelecer comportamentos comuns entre classes diferentes, reduzindo o acoplamento e permitindo polimorfismo sem exigir herança entre elas.

**3. Qual é a diferença entre uma interface e uma classe?**

Uma classe pode possuir atributos de instância, construtores e métodos implementados. Uma interface define contratos e pode possuir constantes, métodos abstratos, `default`, `static` e `private`, mas não possui construtores nem atributos de instância.

**4. Uma interface pode ser instanciada?**

Não. Não podemos criar objetos diretamente de uma interface com `new`.

**5. Uma variável pode ter como tipo uma interface?**

Sim. Podemos declarar uma referência de interface que aponta para um objeto de uma classe que a implementa.

```java
Animal animal = new Cachorro();
```

**6. Qual é a diferença entre `extends` e `implements`?**

`extends` representa herança entre classes ou extensão entre interfaces. `implements` indica que uma classe está implementando uma ou mais interfaces.

**7. Uma classe pode implementar várias interfaces?**

Sim.

```java
public class Robo implements Movivel, Programavel, Recarregavel {
}
```

**8. Uma interface pode estender várias interfaces?**

Sim. Basta utilizar `extends` e separar as interfaces por vírgula.

```java
public interface C extends A, B {
}
```

---

## 2. Parte 2 — Métodos e atributos

**9. Uma interface pode possuir atributos?**

Sim. Entretanto, seus atributos são necessariamente constantes.

**10. Quais são os modificadores implícitos dos atributos de uma interface?**

`public static final`.

**11. Podemos modificar o valor de um atributo de interface?**

Não. Como é `final`, seu valor não pode ser alterado após a inicialização.

**12. Uma interface pode possuir construtores?**

Não. Interfaces não possuem construtores porque não podem ser instanciadas diretamente.

**13. Uma interface pode possuir métodos concretos?**

Sim. Pode possuir métodos `default`, `static` e `private` com implementação.

**14. Qual é a diferença entre `default` e `static`?**

`default` define um método de instância com implementação, que pode ser herdado e sobrescrito pela classe.

`static` define um método pertencente à própria interface, chamado diretamente pelo nome dela.

```java
interface Exemplo {

    default void metodoA() {
        System.out.println("Default");
    }

    static void metodoB() {
        System.out.println("Static");
    }
}
```

**15. Uma classe pode sobrescrever um método `default`?**

Sim. Basta implementar novamente o método utilizando `@Override`.

**16. Uma interface pode possuir métodos `private`?**

Sim. Desde Java 9, interfaces podem possuir métodos privados, utilizados para compartilhar código internamente entre seus métodos.

**17. Uma classe concreta pode deixar de implementar um método abstrato?**

Não. Ela precisa implementar todos os métodos abstratos pendentes. Uma classe abstrata, entretanto, pode deixar métodos sem implementação.

---

## 3. Parte 3 — Polimorfismo

**18. Por que podemos criar uma referência de interface apontando para um objeto de uma classe concreta?**

Porque a classe implementa o contrato definido pela interface. Portanto, o objeto é compatível com aquele tipo.

```java
Animal animal = new Cachorro();
```

**19. O que é polimorfismo nesse contexto?**

É a capacidade de utilizar uma mesma referência de interface para representar diferentes objetos que implementam essa interface, cada um executando seu próprio comportamento.

**20. Se uma referência é do tipo de uma interface, podemos acessar métodos exclusivos da classe concreta?**

Não diretamente. A referência disponibiliza os métodos declarados no seu tipo, além dos métodos herdados de `Object`.

**21. O que acontece quando atribuímos outro objeto à mesma referência?**

A referência passa a apontar para o novo objeto, desde que ele também implemente a interface.

```java
Animal animal = new Cachorro();

animal = new Gato();
```

**22. O método executado é determinado pelo tipo da referência ou pelo tipo real do objeto?**

A seleção da implementação sobrescrita ocorre pelo tipo real do objeto em tempo de execução. Entretanto, o compilador verifica se o método pode ser acessado pelo tipo da referência.

---

## 4. Parte 4 — Casos extremos

**23. O que acontece quando duas interfaces possuem métodos abstratos com a mesma assinatura?**

Não ocorre conflito. Uma única implementação na classe satisfaz os contratos das duas interfaces.

**24. O que acontece quando duas interfaces possuem métodos `default` com a mesma assinatura?**

Ocorre um conflito de implementação. A classe precisa sobrescrever o método e escolher qual implementação utilizar ou fornecer uma implementação própria.

**25. O que acontece se uma classe abstrata implementar uma interface sem implementar todos os métodos?**

É permitido. A classe abstrata pode deixar os métodos pendentes para suas subclasses.

**26. Uma classe pode implementar uma interface e estender uma classe simultaneamente?**

Sim.

```java
public class Cachorro extends Animal implements Domestico {
}
```

A classe pode estender uma única classe e implementar várias interfaces.

**27. Uma classe pode implementar uma interface sem declarar explicitamente todos os métodos herdados de outra interface?**

Depende.

Se os métodos já estiverem implementados por uma superclasse ou forem métodos `default` herdados sem conflito, não precisam ser implementados novamente.

Caso sejam métodos abstratos pendentes, uma classe concreta deverá implementá-los.

**28. Uma implementação pode reduzir a visibilidade de um método público da interface?**

Não. Um método abstrato de interface é implicitamente `public`, portanto sua implementação também precisa ser pública.

**29. Uma interface funcional pode possuir métodos `default`?**

Sim. Métodos `default` não entram na contagem de métodos abstratos.

**30. Uma interface funcional pode possuir dois métodos abstratos?**

Não. Para ser funcional, deve possuir exatamente um método abstrato, considerando as regras de equivalência e herança de assinaturas da linguagem Java.

---

# 5. Exercícios práticos — Resoluções

## Exercício 1 — Identificando erros

**1. O código compila?**

Não. A classe `Carro` não implementou todos os métodos abstratos da interface `Veiculo`.

**2. Qual é o problema?**

O método `frear()` está declarado na interface, mas não foi implementado na classe concreta.

**3. Como corrigir?**

Implementando o método `frear()`:

```java
public class Carro implements Veiculo {

    @Override
    public void acelerar() {
        System.out.println("Acelerando");
    }

    @Override
    public void frear() {
        System.out.println("Freando");
    }
}
```

**4. Se `Carro` fosse abstrata, o resultado seria diferente?**

Sim. O código seria válido porque classes abstratas podem deixar métodos abstratos sem implementação.

```java
public abstract class Carro implements Veiculo {

    @Override
    public void acelerar() {
        System.out.println("Acelerando");
    }
}
```

---

## Exercício 2 — Múltiplas interfaces

**Implementação da classe Atleta:**

```java
public class Atleta implements Nadador, Corredor {

    @Override
    public void nadar() {
        System.out.println("Nadando");
    }

    @Override
    public void correr() {
        System.out.println("Correndo");
    }
}
```

**1. É possível implementar as duas interfaces simultaneamente?**

Sim. Java permite que uma classe implemente várias interfaces utilizando `implements`.

**2. Quantos métodos precisam ser implementados?**

Dois: `nadar()` e `correr()`, pois são os dois métodos abstratos pendentes.

**3. Uma classe poderia implementar cinco interfaces?**

Sim. Java não estabelece um limite fixo de quantidade de interfaces que uma classe pode implementar.

**4. Existe algum limite imposto pela regra de herança múltipla de classes?**

Sim. Uma classe pode estender somente uma classe, mas pode implementar várias interfaces.

---

## Exercício 3 — Polimorfismo

**1. O código compila?**

Não. A chamada `animal.abanarRabo()` gera erro de compilação.

**2. Por que `emitirSom()` pode ser chamado?**

Porque esse método está declarado na interface `Animal`, que é o tipo da referência.

**3. Por que `abanarRabo()` não pode ser chamado?**

Porque esse método existe apenas na classe `Cachorro`, não estando declarado na interface `Animal`. O compilador considera o tipo da referência, não apenas o tipo real do objeto.

**4. Como acessar `abanarRabo()` com segurança?**

Utilizando `instanceof` para verificar o tipo real do objeto antes de realizar o cast.

```java
public class Main {

    public static void main(String[] args) {

        Animal animal = new Cachorro();

        animal.emitirSom();

        if (animal instanceof Cachorro cachorro) {
            cachorro.abanarRabo();
        }
    }
}
```

A variável `cachorro` é disponibilizada após a verificação bem-sucedida do tipo.

---

## Exercício 4 — Conflito de métodos default

**Implementação da classe:**

```java
public class C implements A, B {

    @Override
    public void executar() {
        A.super.executar();
    }
}
```

**1. O que acontece se não sobrescrevermos `executar()`?**

Ocorre um erro de compilação, porque as interfaces `A` e `B` possuem implementações `default` conflitantes com a mesma assinatura.

**2. Como resolver o conflito?**

Sobrescrevendo o método `executar()` na classe e definindo qual implementação será utilizada.

**3. Como chamar especificamente a implementação de `A`?**

```java
A.super.executar();
```

**4. Como chamar especificamente a implementação de `B`?**

```java
B.super.executar();
```

Também podemos chamar as duas implementações dentro do método sobrescrito:

```java
public class C implements A, B {

    @Override
    public void executar() {
        A.super.executar();
        B.super.executar();
    }
}
```

Nesse caso, serão exibidos:

```text
A
B
```

---

# 6. Resumo final para revisão

| Conceito | Resposta |
|---|---|
| Declarar interface | `interface` |
| Implementar interface | `implements` |
| Estender interface | `extends` |
| Atributos | `public static final` |
| Métodos abstratos | `public abstract` |
| Métodos com implementação | `default`, `static` e `private` |
| Construtores | Não possui |
| Instanciação direta | Não é permitida |
| Múltiplas interfaces | Permitido |
| Múltiplas classes herdadas | Não permitido |
| Polimorfismo | Referência de interface apontando para diferentes implementações |
| Interface funcional | Exatamente um método abstrato |
| Conflito entre métodos `default` | Deve ser resolvido pela classe |

**Critério de domínio:** você deve conseguir identificar quando um código compila, justificar os erros e explicar por que uma referência de interface pode apontar para diferentes objetos. Esses conhecimentos abrangem os principais fundamentos e casos extremos de interfaces em Java.