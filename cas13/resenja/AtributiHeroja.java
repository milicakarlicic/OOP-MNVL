package resenja;

public class AtributiHeroja {
    private int snaga;
    private int spretnost;
    private int konstitucija;
    private int inteligencija;
    private int mudrost;
    private int harizma;

    public AtributiHeroja(int snaga, int spretnost, int konstitucija, int inteligencija, int mudrost, int harizma) {
        this.snaga = snaga;
        this.spretnost = spretnost;
        this.konstitucija = konstitucija;
        this.inteligencija = inteligencija;
        this.mudrost = mudrost;
        this.harizma = harizma;
    }

    public int getSnaga() {
        return snaga;
    }

    public int getSpretnost() {
        return spretnost;
    }

    public int getKonstitucija() {
        return konstitucija;
    }

    public int getInteligencija() {
        return inteligencija;
    }

    public int getMudrost() {
        return mudrost;
    }

    public int getHarizma() {
        return harizma;
    }

    public static AtributiHeroja pocetniAtributiRatnik() {
        return new AtributiHeroja(11, 8, 9, 7, 6, 7);
    }

    public static AtributiHeroja pocetniAtributiMag() {
        return new AtributiHeroja(6, 7, 6, 11, 11, 8);
    }

    @Override
    public String toString() {
        return "[" +
                snaga +
                ", " + spretnost +
                ", " + konstitucija +
                ", " + inteligencija +
                ", " + mudrost +
                ", " + harizma +
                "]";
    }
}
