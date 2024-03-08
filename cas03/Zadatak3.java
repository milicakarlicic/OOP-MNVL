package cas03;

public class Zadatak3 {

    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);

        String linija = ulaz.nextLine();

        String pom = ulaz.next();
        
        if (linija.contains(pom)) {
			System.out.println("jeste podniska");
        }
        
        System.out.println(linija.substring(10, 16));

        if (linija.startsWith(pom)) {
            System.out.println("jeste prefiks");
        } 
        
        if (linija.endsWith(pom)) {
            System.out.println("jeste sufiks");
        }

        ulaz.close();
    }

}
