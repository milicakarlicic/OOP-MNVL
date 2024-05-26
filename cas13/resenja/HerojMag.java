package resenja;

public class HerojMag extends Heroj{

    public HerojMag(String ime, Nivo nivo, Rasa rasa, AtributiHeroja atributiHeroja) {
        super(ime, nivo, rasa, atributiHeroja);
    }

    @Override
    public int izracunajMinNapad() {
        // Nivo + Snaga
        return getNivo().izracunajNivo() +
                getAtributiHeroja().getSnaga();
    }

    @Override
    public int izracunajMaxNapad() {
        // Nivo + Snaga + 0.4 * Spretnost
        return (int) Math.ceil(getNivo().izracunajNivo() +
                getAtributiHeroja().getSnaga() +
                0.4 * getAtributiHeroja().getSpretnost());
    }

    @Override
    public int izracunajZivot() {
        // Nivo + Konstitucija + 0.3f * Snaga
        return (int) Math.ceil(getNivo().izracunajNivo() +
                getAtributiHeroja().getKonstitucija() +
                0.3f * getAtributiHeroja().getSnaga());
    }

    @Override
    public String toString() {
        // [ratnik] [lvl 8] ime rasa atr napad: min-max hp: zivot

        return "******************************************************************\n" +
                "[mag] " +
                "[" + getNivo() + "] " +
                getIme() + " " +
                getRasa() + " " +
                getAtributiHeroja() + " " +
                "napad: " + izracunajMinNapad() +
                "-" + izracunajMaxNapad() + " " +
                "hp: " + izracunajZivot() + "\n" +
                "******************************************************************\n";
    }
}
