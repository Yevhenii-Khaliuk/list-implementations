package list;

public interface List<T> {
    T get();
    void add(T t);
    void remove(int i);
    int size();
}
