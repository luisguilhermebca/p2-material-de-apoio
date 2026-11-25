import java.util.Scanner;

/**
 * Laboratorio prático de interfaces em Java.
 * Requer Java 17 ou superior.
 *
 * Compile: javac *.java
 * Execute: java Main
 */
public class Main {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            System.out.print("Escolha uma opção: ");
            String opcao = SC.nextLine().trim();

            switch (opcao) {
                case "1" -> Demonstracoes.contrato();
                case "2" -> Demonstracoes.multiplasInterfaces();
                case "3" -> Demonstracoes.polimorfismo();
                case "4" -> Demonstracoes.metodosDefault();
                case "5" -> Demonstracoes.interfaceFuncional();
                case "6" -> Desafios.executar(SC);
                case "0" -> {
                    System.out.println("Laboratório encerrado.");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }

            System.out.println("\nPressione ENTER para voltar ao menu.");
            SC.nextLine();
        }
    }

    private static void mostrarMenu() {
        System.out.println("""

                ==========================================
                  LABORATÓRIO DE INTERFACES — JAVA
                ==========================================
                1. Contrato: implementar uma interface
                2. Uma classe implementando várias interfaces
                3. Polimorfismo e tipo da referência
                4. Métodos default e resolução de conflito
                5. Interface funcional e lambda
                6. Desafios para responder
                0. Sair
                ==========================================
                """);
    }
}
