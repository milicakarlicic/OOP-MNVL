package zadatak3;

public class Oblik {
    private Tacka centar;

    public Oblik(Tacka centar) {
        this.centar = new Tacka(centar);
    }

    public Oblik(Oblik o) {
        this(o.centar);
    }
    
    public Tacka getCentar() {
        return centar;
    }

    public void setCentar(Tacka centar) {
        this.centar = new Tacka(centar);
    }

    @Override
    public String toString() {
        return "" + centar;
    }
}
