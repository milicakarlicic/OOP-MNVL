package cas03.Zadatak10;

public class Tacka {
    private double x;
    private double y;

    public Tacka(double x, double y) {
        this.x = x;
        this.y = y;
    }
	
	// podrazumevani konstrukor - postoji ukoliko ne definisemo nijedan drugi, u suprotnom ga je neophodno eksplicitno definisati
    public Tacka() {
    	// ukoliko ne postoji kolizija imena poljima tekuceg objekta se moze
        // pristupati i samo pomocu njihovog imena
        x = 0;
        y = 0;
    }

    public double rastojanje(Tacka t) {
        // t1 zapravo this
        // t2 zapravo argument t
        return Math.sqrt((this.x - t.x) * (this.x - t.x) + (this.y - t.y) * (this.y - t.y));
    }
}
