package cas08.zadatak03;

import java.util.Optional;

public class Test {

    public static <T extends Comparable<T>> Optional<T> nadjiMaksimum(T[] niz) {
        if (niz.length == 0) {
            // ukoliko je niz prazan vracamo praznu opcionu vrijednost
            return Optional.empty();
        }

        T max = niz[0];
        for (int i = 1; i < niz.length; i++) {
            if (niz[i].compareTo(max) > 0) {
                max = niz[i];
            }
        }

        return Optional.of(max);
    }

    public static void main(String[] args) {
        Integer[] niz = {};

        Optional<Integer> max = nadjiMaksimum(niz);
        System.out.println(max);
    }
}
