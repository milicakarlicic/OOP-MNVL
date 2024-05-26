package resenja;

public class HerojRatnik extends Heroj {

    public HerojRatnik(String ime, Nivo nivo, Rasa rasa, AtributiHeroja atributiHeroja) {
        super(ime, nivo, rasa, atributiHeroja);
    }

    @Override
    public int izracunajMinNapad() {
        // Nivo + Inteligencija
        return getNivo().izracunajNivo() +
                getAtributiHeroja().getInteligencija();
    }

    @Override
    public int izracunajMaxNapad() {
        // Nivo + Inteligencija + 0.4 * Spretnost
        return (int) Math.ceil(getNivo().izracunajNivo() +
                        getAtributiHeroja().getInteligencija() +
                        0.4 * getAtributiHeroja().getSpretnost());
    }

    @Override
    public int izracunajZivot() {
        // Nivo + Konstitucija
        return getNivo().izracunajNivo() +
                getAtributiHeroja().getKonstitucija();
    }

    @Override
    public String toString() {
        // domaci: umjesto klase String koristiti StringBuilder
        // [ratnik] [lvl 8] ime rasa atr napad: min-max hp: zivot

        return "******************************************************************\n" +
                "[ratnik] " +
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
