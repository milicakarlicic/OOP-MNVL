package resenja;

public class Nivo {
    private int iskustvo;

    public Nivo(int iskustvo) {
        this.iskustvo = iskustvo;
    }

    public int getIskustvo() {
        return iskustvo;
    }

    public static Nivo napraviNivo1() {
        return new Nivo(1000);
    }

    public int izracunajNivo() {
        return iskustvo / 1000;
    }

    @Override
    public String toString() {
        return "lvl " + izracunajNivo();
    }
}
