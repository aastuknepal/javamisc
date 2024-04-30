public interface SimpleArrayList {
   
    void add(Object item);

    void remove(Object item);

    boolean contains(Object item);

    int indexOf(Object item);

    Object get(int index) throws IndexOutOfBoundsException;

    int size();
}
