package cas11.zadatak05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zadatak02 {

    public static void main(String[] args) {
        try (Scanner ulaz = new Scanner(new File("src/cas11/1.txt"));
             PrintWriter pisac = new PrintWriter(new File("src/cas11/izlaz.txt"))) {
            while (ulaz.hasNextLine()) {
                String linija = ulaz.nextLine();
                System.out.println(linija);
                pisac.write(linija + '\n');
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
