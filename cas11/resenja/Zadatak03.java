package cas11;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Zadatak03 {

    public static void main(String[] args) {
        Path putanja = Paths.get("pomocni", "ulaz.txt");

        Map<String, Integer> mapa = new TreeMap<>();

        try (Scanner ulaz = new Scanner(putanja);) {
            while (ulaz.hasNext()) {
                String rec = ulaz.next();
                if (mapa.containsKey(rec)) {
                    int brojPojavljivanja = mapa.get(rec);
                    brojPojavljivanja++;
                    mapa.put(rec, brojPojavljivanja);
                } else {
                    mapa.put(rec, 1);
                }
            }
        } catch (IOException e) {
            System.err.println("greska");
        }

        for (String kljuc : mapa.keySet()) {
            int vrednost = mapa.get(kljuc);
            System.out.println(kljuc + ": " + vrednost);
        }
    }

}
