package zadatak1;

public class Test {

    public static void main(String[] args) {
        Tacka t1 = new Tacka();
        Tacka t2 = new Tacka(0, 0);

        System.out.println(t2);
        t2.transliraj(3, 4);
        System.out.println(t2);

        // nestaticka metoda
        System.out.println("rastojanje izmedju tacaka: " + t1.rastojanje(t2));
        // staticka metoda
        System.out.println("rastojanje izmedju tacaka: " + Tacka.rastojanje(t1, t2));
        
        System.out.println("Ukupno tacaka: " + Tacka.getBrojac());
    }

}
