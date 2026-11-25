public class Cachorro implements Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au au!");
    }

    public void abanarRabo() {
        System.out.println("Cachorro abanando o rabo.");
    }
}
