package zadatak2;

public class StudentSaM extends Student {
    private int ocenaTA;

    public StudentSaM(String ime, String prezime, String alas, double prosek, int ocenaTA) {
        super(ime, prezime, alas, prosek);
        this.ocenaTA = ocenaTA;
    }

    @Override
    public String toString() {
        return super.toString() + " ocena iz TA: " + ocenaTA;
    }
}
