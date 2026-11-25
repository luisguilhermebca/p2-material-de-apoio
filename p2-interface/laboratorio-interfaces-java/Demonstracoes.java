public class Demonstracoes {
    public static void contrato() {
        System.out.println("\n--- CONTRATO ---");
        Caixa caixa = new Caixa();
        Pagamento pix = new Pix();
        Pagamento cartao = new Cartao();

        caixa.processar(pix, 100.0);
        caixa.processar(cartao, 250.0);

        System.out.println("A classe Caixa depende da interface Pagamento,");
        System.out.println("não precisa conhecer os detalhes de Pix ou Cartao.");
    }

    public static void multiplasInterfaces() {
        System.out.println("\n--- MÚLTIPLAS INTERFACES ---");
        Atleta atleta = new Atleta();
        atleta.nadar();
        atleta.correr();
        System.out.println("Atleta implementa Nadador e Corredor.");
    }

    public static void polimorfismo() {
        System.out.println("\n--- POLIMORFISMO ---");
        Animal primeiro = new Cachorro();
        Animal segundo = new Gato();

        primeiro.emitirSom();
        segundo.emitirSom();

        primeiro.descansar();
        segundo.descansar();

        System.out.println("\nA referência é Animal; o objeto real muda.");
        System.out.println("O método emitirSom executado depende do objeto real.");

        System.out.println("\nAcesso seguro a um método específico de Cachorro:");
        if (primeiro instanceof Cachorro cachorro) {
            cachorro.abanarRabo();
        }

        System.out.println("\nA linha abaixo NÃO compilaria:");
        System.out.println("// primeiro.abanarRabo();");
        System.out.println("O método não está declarado no tipo Animal.");
    }

    public static void metodosDefault() {
        System.out.println("\n--- MÉTODOS DEFAULT ---");
        Animal cachorro = new Cachorro();
        cachorro.descansar();

        ResolucaoConflito resolucao = new ResolucaoConflito();
        resolucao.executar();

        System.out.println("\nSem sobrescrever executar() em ResolucaoConflito,");
        System.out.println("haveria conflito entre os dois métodos default.");
    }

    public static void interfaceFuncional() {
        System.out.println("\n--- INTERFACE FUNCIONAL ---");
        Operacao soma = (a, b) -> a + b;
        Operacao multiplicacao = (a, b) -> a * b;

        System.out.println("Soma: " + soma.calcular(7, 5));
        System.out.println("Multiplicação: " + multiplicacao.calcular(7, 5));
        System.out.println("Cada lambda fornece a implementação de calcular().");
    }
}
