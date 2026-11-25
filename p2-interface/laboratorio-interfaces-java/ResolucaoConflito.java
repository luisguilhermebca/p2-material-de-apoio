public class ResolucaoConflito implements OrigemA, OrigemB {
    @Override
    public void executar() {
        System.out.println("A classe escolheu executar as duas:");
        OrigemA.super.executar();
        OrigemB.super.executar();
    }
}
