# Interfaces em Programação Orientada a Objetos (Java)

### Autor - Luis Guilherme

## 1. O que é uma interface e qual problema ela resolve?

Antes de entender a sintaxe, precisamos entender o problema.
Imagine que estamos desenvolvendo um sistema que possui diferentes tipos de objetos: carros, motocicletas, caminhões e bicicletas.
Todos esses objetos possuem características e comportamentos diferentes. Entretanto, alguns deles compartilham uma capacidade: movimentar-se.

Como podemos estabelecer que diferentes classes possuem determinado comportamento sem obrigatoriamente fazer com que elas pertençam à mesma hierarquia de herança?
É justamente esse tipo de problema que uma interface resolve.
Uma interface define um **contrato** que determina quais operações uma classe deve disponibilizar quando decide implementá-la.

Em Java, podemos declarar uma interface assim:

```java
public interface Veiculo {
    void acelerar();
    void frear();
}
```

Observe que não estamos criando um carro, uma motocicleta ou qualquer outro veículo. Estamos estabelecendo um contrato.

Esse contrato determina que qualquer classe que implementar `Veiculo` deverá fornecer implementações para os métodos abstratos `acelerar()` e `frear()`, salvo quando a própria classe for abstrata.

Agora podemos criar diferentes classes:

```java
public class Carro implements Veiculo {

    @Override
    public void acelerar() {
        System.out.println("Carro acelerando");
    }

    @Override
    public void frear() {
        System.out.println("Carro freando");
    }
}
```

```java
public class Bicicleta implements Veiculo {

    @Override
    public void acelerar() {
        System.out.println("Bicicleta aumentando a velocidade");
    }

    @Override
    public void frear() {
        System.out.println("Bicicleta diminuindo a velocidade");
    }
}
```

Perceba que as duas classes implementam a mesma interface, mas executam os métodos de maneiras diferentes.

**Analogia:** pense em uma tomada elétrica. Ela estabelece um padrão de conexão. Uma televisão, um carregador e um computador podem utilizar a mesma tomada, embora sejam equipamentos completamente diferentes.

A interface funciona de maneira semelhante: estabelece um padrão que diferentes classes precisam respeitar.

---

## 2. Principais dúvidas sobre interfaces

### 2.1. Uma interface é uma classe?

Não.
Uma interface e uma classe são estruturas diferentes da linguagem Java.
Uma classe pode possuir atributos de instância, construtores e métodos concretos, além de métodos abstratos quando declarada abstrata.

Uma interface possui regras próprias: seus campos são implicitamente `public static final`, e seus métodos podem ser abstratos, `default`, `static` ou `private`, dependendo das regras da linguagem.

Exemplo:

```java
public interface Animal {
    int ID = 10;

    void emitirSom();
}
```

O atributo `ID` é implicitamente:

```java
public static final int ID = 10;
```

Isso significa que ele é:

- `public`: acessível publicamente;
- `static`: pertence à interface, não a uma instância;
- `final`: não pode receber outro valor após sua inicialização.

Portanto, não podemos fazer:

```java
Animal.ID = 20; // ERRO
```

**Caso extremo:** podemos criar objetos de uma interface?

Não diretamente.

```java
Animal animal = new Animal(); // ERRO
```

Uma interface não pode ser instanciada diretamente.

Entretanto, podemos criar uma variável cujo tipo seja uma interface:

```java
Animal animal = new Cachorro();
```

Isso é perfeitamente válido, desde que `Cachorro` implemente `Animal`.

Essa diferença é fundamental: não podemos instanciar uma interface, mas podemos utilizá-la como tipo de referência.

### 2.2. Qual é a diferença entre `extends` e `implements`?

Essa é uma das dúvidas mais importantes.

Em Java:

- `extends` representa herança entre classes ou extensão de interfaces.
- `implements` representa a implementação de uma ou mais interfaces por uma classe.

Exemplo de herança:

```java
public class Animal {
    public void respirar() {
        System.out.println("Respirando");
    }
}

public class Cachorro extends Animal {
}
```

O cachorro herda as características e os comportamentos acessíveis da classe Animal.

Agora, utilizando uma interface:

```java
public interface Animal {
    void emitirSom();
}

public class Cachorro implements Animal {

    @Override
    public void emitirSom() {
        System.out.println("Au au");
    }
}
```

Aqui, Cachorro não está herdando uma implementação de `emitirSom()`. Está assumindo a responsabilidade de fornecer essa implementação.

**Atenção:** uma classe pode estender somente uma classe, mas pode implementar várias interfaces.

```java
public class Robo implements Movivel, Programavel, Recarregavel {
}
```

Isso permite que uma classe assuma vários contratos diferentes.

### 2.3. Uma interface pode ter vários métodos?

Sim.

```java
public interface Pessoa {
    void andar();
    void falar();
    void estudar();
    void trabalhar();
}
```

Uma classe concreta que implementar essa interface deverá implementar todos os métodos abstratos herdados.

```java
public class Estudante implements Pessoa {

    @Override
    public void andar() {
        System.out.println("Andando");
    }

    @Override
    public void falar() {
        System.out.println("Falando");
    }

    @Override
    public void estudar() {
        System.out.println("Estudando");
    }

    @Override
    public void trabalhar() {
        System.out.println("Trabalhando");
    }
}
```

**Caso extremo:** e se a classe implementar somente dois dos quatro métodos?

Se ela for concreta, ocorrerá um erro de compilação.

Entretanto, se for declarada abstrata, poderá deixar métodos abstratos sem implementação.

```java
public abstract class Estudante implements Pessoa {

    @Override
    public void andar() {
        System.out.println("Andando");
    }
}
```

Essa classe não precisa implementar os outros métodos porque é abstrata.

Uma subclasse concreta deverá implementar os métodos que ainda estiverem pendentes.

### 2.4. Uma interface pode ter métodos implementados?

Sim. Essa é uma dúvida importante porque muita gente aprende inicialmente que interfaces possuem apenas métodos sem implementação.

Isso não é mais verdade.
Desde o Java 8, interfaces podem possuir métodos `default` e `static` com implementação.

Exemplo:

```java
public interface Animal {

    void emitirSom();

    default void dormir() {
        System.out.println("Dormindo");
    }

    static void respirar() {
        System.out.println("Respirando");
    }
}
```

Agora temos três situações:

1. `emitirSom()`: método abstrato. A classe concreta deve implementá-lo.
2. `dormir()`: método `default`. Já possui implementação e pode ser herdado pela classe.
3. `respirar()`: método `static`. Pertence à própria interface.

Utilização:

```java
public class Cachorro implements Animal {

    @Override
    public void emitirSom() {
        System.out.println("Au au");
    }
}
```

```java
public class Main {

    public static void main(String[] args) {

        Cachorro cachorro = new Cachorro();

        cachorro.emitirSom();
        cachorro.dormir();

        Animal.respirar();
    }
}
```

Observe que chamamos `dormir()` pelo objeto, mas chamamos `respirar()` diretamente pela interface.

**Caso extremo:** uma classe pode sobrescrever um método `default`?

Sim.

```java
public class Cachorro implements Animal {

    @Override
    public void emitirSom() {
        System.out.println("Au au");
    }

    @Override
    public void dormir() {
        System.out.println("Cachorro dormindo");
    }
}
```

A implementação da classe passa a prevalecer sobre a implementação `default` da interface.

### 2.5. Uma interface pode ter construtores?

Não.

Uma interface não possui construtores porque não pode ser instanciada diretamente.

```java
public interface Animal {

    public Animal() { // ERRO
    }

}
```

Entretanto, uma classe que implementa uma interface pode ter construtores normalmente.

```java
public class Cachorro implements Animal {

    public Cachorro() {
        System.out.println("Cachorro criado");
    }

    @Override
    public void emitirSom() {
        System.out.println("Au au");
    }
}
```

A interface estabelece um contrato, mas não controla diretamente a construção dos objetos das classes que a implementam.

### 2.6. Uma classe pode implementar duas interfaces com o mesmo método?

Sim.

Imagine que temos duas interfaces:

```java
public interface Nadador {
    void movimentar();
}
```

```java
public interface Corredor {
    void movimentar();
}
```

Agora temos uma classe que implementa as duas:

```java
public class Atleta implements Nadador, Corredor {

    @Override
    public void movimentar() {
        System.out.println("Atleta se movimentando");
    }
}
```

Isso funciona normalmente.

A classe fornece uma única implementação que satisfaz os dois contratos.

**Mas e se os métodos tiverem assinaturas diferentes?**

```java
public interface Nadador {
    void movimentar(int velocidade);
}
```

```java
public interface Corredor {
    void movimentar(String direcao);
}
```

A classe precisará implementar os dois métodos:

```java
public class Atleta implements Nadador, Corredor {

    @Override
    public void movimentar(int velocidade) {
        System.out.println("Nadando a " + velocidade);
    }

    @Override
    public void movimentar(String direcao) {
        System.out.println("Correndo para " + direcao);
    }
}
```

Isso é possível porque as assinaturas são diferentes e o Java consegue distinguir os métodos.

### 2.7. E se duas interfaces possuírem um método `default` com o mesmo nome?

Aqui temos uma situação mais interessante.

```java
public interface A {

    default void executar() {
        System.out.println("Executando A");
    }
}
```

```java
public interface B {

    default void executar() {
        System.out.println("Executando B");
    }
}
```

Agora imagine:

```java
public class C implements A, B {
}
```

Isso gera um erro de compilação.

Por quê?

Porque o Java não sabe qual implementação `default` deve prevalecer.

A classe precisa resolver explicitamente o conflito:

```java
public class C implements A, B {

    @Override
    public void executar() {
        A.super.executar();
    }
}
```

Também poderíamos escolher:

```java
B.super.executar();
```

Ou escrever uma implementação própria:

```java
@Override
public void executar() {
    System.out.println("Executando C");
}
```

**Analogia:** imagine duas pessoas dando instruções diferentes para o mesmo funcionário. Se não houver uma regra de prioridade, ele não saberá qual instrução seguir. A classe precisa resolver o conflito.

---

## 3. Polimorfismo utilizando interfaces

Esse é um dos conceitos mais importantes relacionados às interfaces.

Imagine que temos diferentes classes que implementam a mesma interface:

```java
public interface Pagamento {
    void pagar(double valor);
}
```

```java
public class Pix implements Pagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via Pix: " + valor);
    }
}
```

```java
public class Cartao implements Pagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via cartão: " + valor);
    }
}
```

Agora podemos fazer:

```java
public class Main {

    public static void main(String[] args) {

        Pagamento pagamento1 = new Pix();
        Pagamento pagamento2 = new Cartao();

        pagamento1.pagar(100);
        pagamento2.pagar(200);
    }
}
```

Observe:

```java
Pagamento pagamento1 = new Pix();
```

O tipo da referência é `Pagamento`, mas o objeto criado é um `Pix`.

Isso é polimorfismo.

A referência é capaz de apontar para diferentes objetos que respeitam o mesmo contrato.

O método executado será determinado pelo tipo real do objeto em tempo de execução.

**Caso extremo:** podemos fazer o seguinte?

```java
Pagamento pagamento = new Pix();

pagamento = new Cartao();
```

Sim.

A variável continua sendo do tipo `Pagamento`, mas passa a referenciar outro objeto.

**Outra dúvida:** podemos chamar métodos específicos de `Pix` utilizando uma referência do tipo `Pagamento`?

Não diretamente.

Imagine:

```java
public class Pix implements Pagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pix realizado");
    }

    public void gerarComprovante() {
        System.out.println("Comprovante gerado");
    }
}
```

Agora:

```java
Pagamento pagamento = new Pix();

pagamento.pagar(100); // Válido

pagamento.gerarComprovante(); // ERRO
```

Por quê?

Porque o compilador considera os métodos disponíveis no tipo da referência, que é `Pagamento`.

Mesmo que o objeto real seja um `Pix`, a referência não disponibiliza automaticamente os métodos exclusivos dessa classe.

Uma possibilidade seria realizar um cast:

```java
if (pagamento instanceof Pix) {
    Pix pix = (Pix) pagamento;
    pix.gerarComprovante();
}
```

Entretanto, fazer cast constantemente pode indicar que a abstração está mal planejada.

---

## 4. Interface versus classe abstrata

Essa comparação costuma gerar bastante confusão.

Ambas podem ser utilizadas para estabelecer abstrações e definir comportamentos que subclasses precisam implementar.

Entretanto, existem diferenças importantes.

| Característica | Interface | Classe abstrata |
|---|---|---|
| Instanciação direta | Não | Não |
| Construtores | Não | Sim |
| Atributos de instância | Não | Sim |
| Constantes | Sim | Sim |
| Métodos abstratos | Sim | Sim |
| Métodos concretos | Sim | Sim |
| Herança múltipla | Uma classe pode implementar várias | Uma classe só pode estender uma classe |
| Métodos `default` | Sim | Não utiliza essa declaração |

Exemplo de classe abstrata:

```java
public abstract class Animal {

    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void dormir() {
        System.out.println(nome + " está dormindo");
    }

    public abstract void emitirSom();
}
```

Uma classe pode herdar essa estrutura:

```java
public class Cachorro extends Animal {

    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Au au");
    }
}
```

Agora, imagine uma interface:

```java
public interface Voador {
    void voar();
}
```

Podemos combinar as duas estruturas:

```java
public class Passaro extends Animal implements Voador {

    public Passaro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Piu piu");
    }

    @Override
    public void voar() {
        System.out.println("Voando");
    }
}
```

Observe que `Passaro` estende `Animal` e implementa `Voador`.

Essa combinação é perfeitamente válida.

**Quando utilizar cada uma?**

Utilize uma classe abstrata quando quiser compartilhar estado, construtores e implementação entre classes relacionadas.

Utilize uma interface quando quiser estabelecer um contrato que diferentes classes podem implementar, mesmo que não tenham uma relação de herança direta.

---

## 5. Interfaces funcionais e expressões lambda

Uma interface funcional é uma interface que possui exatamente um método abstrato.

Exemplo:

```java
@FunctionalInterface
public interface Operacao {

    int calcular(int a, int b);

}
```

Podemos implementar normalmente:

```java
public class Soma implements Operacao {

    @Override
    public int calcular(int a, int b) {
        return a + b;
    }
}
```

Mas interfaces funcionais permitem uma utilização especial: expressões lambda.

```java
public class Main {

    public static void main(String[] args) {

        Operacao soma = (a, b) -> a + b;

        System.out.println(soma.calcular(10, 20));
    }
}
```

O resultado será:

```java
30
```

Por que isso funciona?

Porque a interface possui apenas um método abstrato. O Java consegue associar a expressão lambda à implementação desse método.

**Atenção:** métodos `default`, `static` e `private` não entram na contagem dos métodos abstratos.

Portanto, uma interface pode possuir vários métodos no total e continuar sendo funcional, desde que tenha exatamente um método abstrato.

---

## 6. O que acontece quando uma classe implementa uma interface e não respeita o contrato?

Vamos analisar algumas situações.

**Situação 1: classe concreta sem implementar um método abstrato.**

```java
public interface Animal {
    void emitirSom();
}
```

```java
public class Cachorro implements Animal {
}
```

Resultado: erro de compilação.

Uma classe concreta precisa implementar todos os métodos abstratos que ainda estiverem pendentes.

**Situação 2: classe abstrata sem implementar todos os métodos.**

```java
public abstract class AnimalBase implements Animal {
}
```

Resultado: válido.

Uma classe abstrata pode deixar a implementação para suas subclasses.

**Situação 3: tentar implementar um método com visibilidade menor.**

```java
public interface Animal {
    void emitirSom();
}
```

```java
public class Cachorro implements Animal {

    @Override
    protected void emitirSom() {
        System.out.println("Au au");
    }
}
```

Resultado: erro de compilação.

Os métodos abstratos de uma interface são implicitamente públicos. Portanto, a implementação não pode reduzir sua visibilidade.

**Situação 4: implementar o método com retorno diferente.**

```java
public interface Animal {
    void emitirSom();
}
```

```java
public class Cachorro implements Animal {

    @Override
    public int emitirSom() {
        return 10;
    }
}
```

Resultado: erro de compilação.

A implementação precisa respeitar a assinatura compatível do método, incluindo o tipo de retorno.

---

## 7. Interfaces podem estender outras interfaces?

Sim.

Uma interface pode estender uma ou várias interfaces utilizando `extends`.

Exemplo:

```java
public interface Animal {
    void emitirSom();
}
```

```java
public interface Domestico extends Animal {
    void interagirComHumano();
}
```

Agora uma classe que implementar `Domestico` deverá respeitar os dois contratos:

```java
public class Cachorro implements Domestico {

    @Override
    public void emitirSom() {
        System.out.println("Au au");
    }

    @Override
    public void interagirComHumano() {
        System.out.println("Interagindo com humano");
    }
}
```

Observe que a classe não implementou diretamente `Animal`, mas precisou implementar seu método porque `Domestico` herda de `Animal`.

**Caso extremo:** uma interface pode estender duas interfaces diferentes?

Sim.

```java
public interface A {
    void metodoA();
}
```

```java
public interface B {
    void metodoB();
}
```

```java
public interface C extends A, B {
    void metodoC();
}
```

Uma classe que implementar `C` deverá implementar os três métodos abstratos.

---

## 8. Quando interfaces realmente são úteis?

Imagine um sistema bancário.

Podemos ter diferentes formas de realizar pagamentos:

- Pix;
- Cartão;
- Boleto;
- Transferência.

Em vez de criar um código diferente para cada tipo de pagamento, podemos estabelecer um contrato:

```java
public interface Pagamento {
    void realizarPagamento(double valor);
}
```

Cada classe implementa sua própria lógica:

```java
public class Pix implements Pagamento {

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pix: " + valor);
    }
}
```

```java
public class Cartao implements Pagamento {

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Cartão: " + valor);
    }
}
```

Agora podemos criar uma classe que recebe qualquer implementação de `Pagamento`:

```java
public class Caixa {

    public void processar(Pagamento pagamento, double valor) {
        pagamento.realizarPagamento(valor);
    }
}
```

Utilização:

```java
public class Main {

    public static void main(String[] args) {

        Caixa caixa = new Caixa();

        caixa.processar(new Pix(), 100);
        caixa.processar(new Cartao(), 200);
    }
}
```

A classe `Caixa` não precisa conhecer os detalhes internos de Pix ou Cartão.

Ela só precisa saber que ambos respeitam o contrato `Pagamento`.

Isso reduz o acoplamento entre as classes e facilita a manutenção e a expansão do sistema.

---

## 9. Perguntas que você precisa saber responder

Antes de considerar que compreendeu interfaces, tente responder às perguntas abaixo sem consultar o material.

### Parte 1 — Fundamentos

1. O que é uma interface em Java?
2. Qual problema uma interface resolve?
3. Qual é a diferença entre uma interface e uma classe?
4. Uma interface pode ser instanciada?
5. Uma variável pode ter como tipo uma interface?
6. Qual é a diferença entre `extends` e `implements`?
7. Uma classe pode implementar várias interfaces?
8. Uma interface pode estender várias interfaces?

### Parte 2 — Métodos e atributos

9. Uma interface pode possuir atributos?
10. Quais são os modificadores implícitos dos atributos de uma interface?
11. Podemos modificar o valor de um atributo de interface?
12. Uma interface pode possuir construtores?
13. Uma interface pode possuir métodos concretos?
14. Qual é a diferença entre `default` e `static`?
15. Uma classe pode sobrescrever um método `default`?
16. Uma interface pode possuir métodos `private`?
17. Uma classe concreta pode deixar de implementar um método abstrato?

### Parte 3 — Polimorfismo

18. Por que podemos criar uma referência de interface apontando para um objeto de uma classe concreta?
19. O que é polimorfismo nesse contexto?
20. Se uma referência é do tipo de uma interface, podemos acessar métodos exclusivos da classe concreta?
21. O que acontece quando atribuímos outro objeto à mesma referência?
22. O método executado é determinado pelo tipo da referência ou pelo tipo real do objeto?

### Parte 4 — Casos extremos

23. O que acontece quando duas interfaces possuem métodos abstratos com a mesma assinatura?
24. O que acontece quando duas interfaces possuem métodos `default` com a mesma assinatura?
25. O que acontece se uma classe abstrata implementar uma interface sem implementar todos os métodos?
26. Uma classe pode implementar uma interface e estender uma classe simultaneamente?
27. Uma classe pode implementar uma interface sem declarar explicitamente todos os métodos herdados de outra interface?
28. Uma implementação pode reduzir a visibilidade de um método público da interface?
29. Uma interface funcional pode possuir métodos `default`?
30. Uma interface funcional pode possuir dois métodos abstratos?

---

## 10. Exercícios práticos

### Exercício 1 — Identificando erros

Analise o código:

```java
public interface Veiculo {
    void acelerar();
    void frear();
}
```

```java
public class Carro implements Veiculo {

    @Override
    public void acelerar() {
        System.out.println("Acelerando");
    }

}
```

Perguntas:

1. O código compila?
2. Qual é o problema?
3. Como corrigir?
4. Se `Carro` fosse abstrata, o resultado seria diferente?

### Exercício 2 — Múltiplas interfaces

Considere:

```java
public interface Nadador {
    void nadar();
}
```

```java
public interface Corredor {
    void correr();
}
```

Crie uma classe `Atleta` que implemente as duas interfaces.

Depois, responda:

1. É possível implementar as duas interfaces simultaneamente?
2. Quantos métodos precisam ser implementados?
3. Uma classe poderia implementar cinco interfaces?
4. Existe algum limite imposto pela regra de herança múltipla de classes?

### Exercício 3 — Polimorfismo

Considere:

```java
public interface Animal {
    void emitirSom();
}
```

```java
public class Cachorro implements Animal {

    @Override
    public void emitirSom() {
        System.out.println("Au au");
    }

    public void abanarRabo() {
        System.out.println("Abanando o rabo");
    }
}
```

Agora:

```java
public class Main {

    public static void main(String[] args) {

        Animal animal = new Cachorro();

        animal.emitirSom();
        animal.abanarRabo();
    }
}
```

Perguntas:

1. O código compila?
2. Por que `emitirSom()` pode ser chamado?
3. Por que `abanarRabo()` não pode ser chamado?
4. Como acessar `abanarRabo()` com segurança?

### Exercício 4 — Conflito de métodos default

Considere:

```java
public interface A {

    default void executar() {
        System.out.println("A");
    }
}
```

```java
public interface B {

    default void executar() {
        System.out.println("B");
    }
}
```

Crie uma classe que implemente as duas interfaces.

Perguntas:

1. O que acontece se não sobrescrevermos `executar()`?
2. Como resolver o conflito?
3. Como chamar especificamente a implementação de `A`?
4. Como chamar especificamente a implementação de `B`?

---

## 11. O que você deve memorizar para uma prova?

- Interface é um contrato que estabelece operações disponibilizadas por uma classe.
- Uma interface não pode ser instanciada diretamente.
- Uma classe utiliza `implements` para implementar uma interface.
- Uma interface utiliza `extends` para estender outra interface.
- Uma classe pode implementar várias interfaces.
- Uma classe pode estender apenas uma classe.
- Métodos abstratos de interfaces são implicitamente `public abstract`.
- Atributos de interfaces são implicitamente `public static final`.
- Interfaces não possuem construtores.
- Métodos `default` possuem implementação e podem ser sobrescritos.
- Métodos `static` pertencem à interface e são chamados por ela.
- Interfaces podem possuir métodos `private` desde o Java 9.
- Uma classe concreta precisa implementar os métodos abstratos pendentes.
- Uma classe abstrata pode deixar implementações pendentes.
- Interfaces permitem polimorfismo.
- Uma referência de interface só disponibiliza os métodos declarados no tipo da referência, além dos métodos herdados de `Object`.
- Uma interface funcional possui exatamente um método abstrato.
- Duas implementações `default` conflitantes precisam ser resolvidas pela classe.

---

## 12. Referência oficial

Para aprofundar o conteúdo, consulte a documentação oficial da linguagem Java:

- Java Language Specification — Interfaces: https://docs.oracle.com/javase/specs/jls/se25/html/jls-9.html
- Java Tutorials — Interfaces: https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
- Java API Documentation: https://docs.oracle.com/en/java/

**Recomendação de estudo:** não tente decorar os 30 conceitos isoladamente. Construa pequenos programas, modifique os exemplos e tente prever se cada alteração produzirá um erro de compilação ou uma execução válida. A capacidade de prever o comportamento do código é um indicador muito melhor de compreensão do que simplesmente saber repetir as definições.