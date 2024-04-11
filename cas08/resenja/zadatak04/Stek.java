package cas08.zadatak04;

public interface Stek<T> {
    void push(T element);
    T pop();
    T top();
    boolean empty();
}
