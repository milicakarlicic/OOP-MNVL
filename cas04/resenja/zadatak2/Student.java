package zadatak2;

// nivoi vidljivosti: public, protected, package, private
public class Student {
    private String ime, prezime, alas;
    private double prosek;

    public Student(String ime, String prezime, String alas, double prosek) {
        this.ime = ime;
        this.prezime = prezime;
        this.alas = alas;
        this.prosek = prosek;
    }

    // prevazilazenje ili predefinisanje metode
    @Override
    public String toString() {
        return ime + " " + prezime + " " + alas + " " + prosek;
    }
}
