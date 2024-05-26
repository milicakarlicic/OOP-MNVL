package resenja;

public enum Rasa {
    Covek, // 0
    Patuljak, // 1
    Vilenjak; // 2

    public static Rasa napraviRasu(String s) {
        switch (s) {
            case "patuljak":
                return Patuljak;
            case "vilenjak":
                return Vilenjak;
            default:
                return Covek;
        }
    }
}
