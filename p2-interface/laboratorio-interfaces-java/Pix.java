public class Pix implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via Pix: R$ " + valor);
    }

    public void gerarComprovante() {
        System.out.println("Comprovante Pix gerado.");
    }
}
