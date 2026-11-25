import java.util.Scanner;

public class Desafios {
    public static void executar(Scanner sc) {
        while (true) {
            System.out.println("""

                    --- DESAFIOS ---
                    1. Uma classe esqueceu um método da interface
                    2. Tipo da referência versus tipo do objeto
                    3. Conflito entre métodos default
                    4. Interface funcional
                    0. Voltar
                    """);
            System.out.print("Escolha: ");
            String escolha = sc.nextLine().trim();

            switch (escolha) {
                case "1" -> desafioContrato(sc);
                case "2" -> desafioReferencia(sc);
                case "3" -> desafioDefault(sc);
                case "4" -> desafioFuncional(sc);
                case "0" -> { return; }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void desafioContrato(Scanner sc) {
        System.out.println("""

                Código:
                interface Dispositivo {
                    void ligar();
                    void desligar();
                }

                class Lampada implements Dispositivo {
                    public void ligar() {
                        System.out.println("Ligada");
                    }
                }

                Pergunta: Lampada compila?
                """);
        System.out.print("Sua resposta (sim/não): ");
        String resposta = sc.nextLine().trim();

        if (resposta.equalsIgnoreCase("não") || resposta.equalsIgnoreCase("nao")) {
            System.out.println("Correto. Falta implementar desligar().");
            System.out.println("Alternativa: tornar Lampada abstrata.");
        } else {
            System.out.println("Não. Uma classe concreta precisa implementar desligar().");
        }
    }

    private static void desafioReferencia(Scanner sc) {
        System.out.println("""

                Considere:
                Animal animal = new Cachorro();

                emitirSom() está em Animal.
                abanarRabo() existe apenas em Cachorro.

                Qual chamada não compila?
                A) animal.emitirSom()
                B) animal.abanarRabo()
                """);
        System.out.print("Resposta (A/B): ");
        String resposta = sc.nextLine().trim();

        if (resposta.equalsIgnoreCase("B")) {
            System.out.println("Correto. A referência Animal não expõe abanarRabo().");
        } else {
            System.out.println("A resposta é B. O tipo da referência limita os métodos acessíveis.");
        }
    }

    private static void desafioDefault(Scanner sc) {
        System.out.println("""

                A e B declaram:
                default void executar() { ... }

                Uma classe implementa A e B.
                O que precisa fazer?
                A) Nada: Java escolhe uma.
                B) Sobrescrever executar().
                C) Declarar a classe como final.
                """);
        System.out.print("Resposta (A/B/C): ");
        String resposta = sc.nextLine().trim();

        if (resposta.equalsIgnoreCase("B")) {
            System.out.println("Correto. A classe deve resolver o conflito explicitamente.");
        } else {
            System.out.println("Resposta: B. É necessário sobrescrever executar().");
        }
    }

    private static void desafioFuncional(Scanner sc) {
        System.out.println("""

                Uma interface funcional pode ter:
                A) Dois métodos abstratos.
                B) Um método abstrato e vários métodos default.
                C) Nenhum método abstrato.
                """);
        System.out.print("Resposta (A/B/C): ");
        String resposta = sc.nextLine().trim();

        if (resposta.equalsIgnoreCase("B")) {
            System.out.println("Correto. Ela deve ter exatamente um método abstrato.");
        } else {
            System.out.println("Resposta: B. Métodos default não entram nessa contagem.");
        }
    }
}
