public class StudentArrayList implements SimpleArrayList {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public StudentArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void add(Object item) {
        ensureCapacity();
        elements[size++] = item;
    }

    @Override
    public void remove(Object item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                removeAtIndex(i);
                return;
            }
        }
    }

    private void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[size * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    public static void main(String[] args) {
        StudentArrayList studentList = new StudentArrayList();

        studentList.add("Prashidda");
        studentList.add("Astuk");
        studentList.add("Chai");

        System.out.println("List size: " + studentList.size());
        System.out.println("List contains 'Astuk': " + studentList.contains("Astuk"));
        System.out.println("Index of 'Chai': " + studentList.indexOf("Chai"));

        studentList.remove("Chai");

        System.out.println("List size after removal: " + studentList.size());
        System.out.println("List contains 'Chai' after removal: " + studentList.contains("Chai"));

        System.out.println("Element at index 0: " + studentList.get(0));
    }
}
