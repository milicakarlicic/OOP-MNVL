package cas11.zadatak05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Zadatak04 {

    public static void main(String[] args) {
        try (FileInputStream tok = new FileInputStream("src/cas11/1.txt");) {
            byte[] niz = new byte[10];
            int brojProcitanihBajtova = tok.read(niz);
            if (brojProcitanihBajtova != 10) {
                System.exit(-1);
            }

            for (byte b : niz) {
                System.out.print((char) b);
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
