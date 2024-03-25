package zadatak02;

public enum Operacija {
    // push, pop, size, top, show
    PUSH(0),
    POP(1),
    TOP(2),
    SIZE(3),
    SHOW(4),
    EXIT(5);

    private int vrednost;

    Operacija(int vrednost) {
        this.vrednost = vrednost;
    }

}
