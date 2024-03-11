package zadatak3;

public class Elipsa extends Oblik {
    private double a;
    private double b;

    public Elipsa(Tacka centar, double a, double b) {
        super(centar);
        this.a = a;
        this.b = b;
    }

    public Elipsa(Elipsa e) {
        this(e.getCentar(), e.a, e.b);
    }

    public double getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Elipsa sa centrom " + super.toString() + " i poluosama a = " + a + ", b = " + b;
    }
}
