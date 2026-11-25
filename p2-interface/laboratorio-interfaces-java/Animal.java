public interface Animal {
    void emitirSom();

    default void descansar() {
        System.out.println("Animal descansando.");
    }
}
