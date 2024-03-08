package cas03;

public class Zadatak4 {

    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);

        String linija = ulaz.nextLine();

        String[] reci = linija.split(" ");
        System.out.println(Arrays.toString(reci));

        ulaz.close();
    }

}
