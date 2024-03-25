package zadatak02;

import java.util.Arrays;

public class StekPrekoNiza implements Stek {
    private int[] elementi;
    private int sp;                    // prva slobodna pozicija
    private int kapacitet;             // inicijalni kapacitet niza

    public StekPrekoNiza(int kapacitet) {
        this.kapacitet = kapacitet;
        this.elementi = new int[kapacitet];
        this.sp = 0;
    }

    @Override
    public void push(int element) {
        if (size() == kapacitet) {
            kapacitet *= 2;
            elementi = Arrays.copyOf(elementi, kapacitet);
        }

        elementi[sp++] = element;
    }

    @Override
    public int pop() {
        if (size() == 0) {
            return Integer.MIN_VALUE;
        }

        return elementi[--sp];
    }

    @Override
    public int top() {
        if (size() == 0) {
            return Integer.MIN_VALUE;
        }

        return elementi[sp - 1];
    }

    @Override
    public int size() {
        return sp;
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size(); i++) {
            sb.append(elementi[i]).append(" ");
        }

        return sb.toString();
    }
}
