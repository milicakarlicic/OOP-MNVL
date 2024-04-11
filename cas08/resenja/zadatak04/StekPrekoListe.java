package cas08.zadatak04;

public class StekPrekoListe<T> implements Stek<T> {
    private class Cvor<E> {
        E vrednost;
        Cvor<E> sledeci;

        public Cvor(E vrednost) {
            this.vrednost = vrednost;
            this.sledeci = null;
        }

        @Override
        public String toString() {
            return " " + vrednost + " ";
        }
    }

    private Cvor<T> glava;

    // Koji konstruktor koristimo?

    @Override
    public void push(T element) {
        Cvor<T> cvor = new Cvor<>(element);
        cvor.sledeci = glava;
        glava = cvor;
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new RuntimeException("Stek je prazan!");
        }
        Cvor<T> pom = glava;
        glava = glava.sledeci;
        return pom.vrednost;
    }

    @Override
    public T top() {
        if (empty()) {
            throw new RuntimeException("Stek je prazan!");
        }
        return glava.vrednost;
    }

    @Override
    public boolean empty() {
        return glava == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        Cvor<T> pom = glava;
        while (pom != null) {
            sb.append(pom);
            pom = pom.sledeci;
        }
        sb.append("}");

        return sb.toString();
    }
}
