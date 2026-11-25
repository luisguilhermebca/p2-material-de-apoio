public class Atleta implements Nadador, Corredor {
    @Override
    public void nadar() {
        System.out.println("Atleta nadando.");
    }

    @Override
    public void correr() {
        System.out.println("Atleta correndo.");
    }
}
