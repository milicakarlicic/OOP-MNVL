package cas03;

public class Zadatak1 {

    public static void main(String[] args) {
        String s1 = new String("ana");
        String s2 = new String("marko");

        // leksikografsko poredjenje
        int rez = s1.compareTo(s2);
        if (rez == 0) {
            System.out.println("jednaki su");
        } else if (rez > 0) {
            System.out.println("drugi je ispred prvog");
        }  else {
            System.out.println("prvi je ispred drugog");
        }
    }

}
