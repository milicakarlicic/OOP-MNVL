package zadatak3;

public class Trougao extends Oblik {
    private Tacka a;
    private Tacka b;
    private Tacka c;

    public Trougao(Tacka centar, Tacka a, Tacka b, Tacka c) {
        super(centar);
        this.a = new Tacka(a);
        this.b = new Tacka(b);
        this.c = new Tacka(c);
    }

    public Trougao(Trougao t) {
        this(t.getCentar(), t.A, t.B, t.C);
    }

    @Override
    public String toString() {
        return "Trougao sa centrom " + super.toString() + " i temenima: "
                "A = " + a + ", B = " + b + ", C = " + c;
    }
}
