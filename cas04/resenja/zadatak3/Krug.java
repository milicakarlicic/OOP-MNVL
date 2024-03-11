package zadatak3;

public class Krug extends Elipsa {
    public Krug(Tacka centar, double r) {
        super(centar, r, r);
    }

    public Krug(Krug k) {
        this(k.getCentar(), k.getPoluprecnik());
    }

    public double getPoluprecnik() {
        return getA();
    }

    @Override
    public String toString() {
        return "Krug sa centrom " + getCentar() + " i poluprecnikom r = " + getPoluprecnik();
    }
}
