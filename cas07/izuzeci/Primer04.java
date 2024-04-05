package izuzeci;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Primer04 {

    // primer kada metod izbacuje izuzetak i oznacavanje da se izbacuje izuzetak u potpisu metoda
    public static int pom(Scanner ulaz) throws InputMismatchException {
        if (ulaz.hasNextInt()) {
            int x = ulaz.nextInt();
            return x;
        } else {
            throw new InputMismatchException();
        }
    }

    public static void main(String[] args) {
        try (Scanner ulaz = new Scanner(System.in);) {
            int x = pom(ulaz);
            System.out.println(x);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
