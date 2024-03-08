package cas03.Zadatak9;

public class Test {

    public static void main(String[] args) {
        Student s1 = new Student("Anastasija", "Markovic", 9, "mv22001");

        s1.ispisi();
        
        String ime = s1.getIme();
        double prosek = s1.getProsek();
        System.out.println("Student sa imenom " + ime + " ima prosek " + prosek);

	s1.setProsek(9.5);
        s1.ispisi();

        s1.setAlasNalog("mm22001");
        s1.ispisi();
    }
}
