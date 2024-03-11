package zadatak2;

public class StudentSaV extends Student {
    private int ocenaUUV;

    public StudentSaV(String ime, String prezime, String alas, double prosek, int ocenaUUV) {
    	// pozivamo konstruktor natklase kako bismo inicijalizovali polja koja nasledjujemo
        super(ime, prezime, alas, prosek);
        this.ocenaUUV = ocenaUUV;
    }

    @Override
    public String toString() {
        return super.toString() + " ocena iz UUV: " + ocenaUUV;
    }
}
