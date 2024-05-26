package resenja;

import java.util.Comparator;

public abstract class Heroj {
    private String ime;
    private Nivo nivo;
    private Rasa rasa;
    private AtributiHeroja atributiHeroja;

    public static Comparator<Heroj> komparator = (o1, o2) -> {
        int nivo1 = o1.nivo.izracunajNivo();
        int nivo2 = o2.nivo.izracunajNivo();
        if (nivo1 != nivo2) {
            return -Integer.compare(nivo1, nivo2);
        } else {
            if (o1 instanceof HerojRatnik && o2 instanceof HerojMag) {
                // -1 prvi < drugo
                return 1;
            } else if (o1 instanceof HerojMag && o2 instanceof HerojRatnik) {
                return -1;
            } else {
                return Integer.compare(o1.izracunajZivot(), o2.izracunajZivot());
            }
        }
    };

    public static Comparator<Heroj> komparatorSnage = (o1, o2) -> {
        return -Integer.compare(o1.atributiHeroja.getSnaga(),
                o2.atributiHeroja.getSnaga());
    };

    public Heroj(String ime, Nivo nivo, Rasa rasa, AtributiHeroja atributiHeroja) {
        this.ime = ime;
        this.nivo = nivo;
        this.rasa = rasa;
        this.atributiHeroja = atributiHeroja;
    }

    public String getIme() {
        return ime;
    }

    public Nivo getNivo() {
        return nivo;
    }

    public Rasa getRasa() {
        return rasa;
    }

    public AtributiHeroja getAtributiHeroja() {
        return atributiHeroja;
    }

    public abstract int izracunajMinNapad();

    public abstract int izracunajMaxNapad();

    public abstract int izracunajZivot();
}
