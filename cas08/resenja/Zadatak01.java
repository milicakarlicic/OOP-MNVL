package cas08;

public class Zadatak01 {

    public static <T> void ispis(T x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        ispis(1);
        ispis("ana");
        ispis(4.5);
        Tacka t = new Tacka(1, 2);
        ispis(t);
    }
}
