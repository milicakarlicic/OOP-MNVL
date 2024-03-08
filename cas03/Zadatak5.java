package cas03;

public class Zadatak5 {

    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);

        String linija = ulaz.nextLine();

        System.out.println("original: " + linija);

        char[] pom = linija.toCharArray();
        Arrays.sort(pom);
        linija = String.valueOf(pom);
        System.out.println("sortirana: " + linija);

        ulaz.close();
    }

}
