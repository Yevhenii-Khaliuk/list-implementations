public class LinkedList<T> implements List<T> {
    private int size;
    private Node first;

    public LinkedList() {
        first = new Node();
        size = 0;
    }

    @Override
    public T get() {
        T value = first == null ? null : first.value;
        return value;
    }

    @Override
    public void add(T t) {
        if (size == 0) {
            first.value = t;
        } else {
            Node head = first;
            while (head.next != null) {
                head = head.next;
            }
            Node newNode = new Node();
            newNode.value = t;
            head.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(int i) {
        if (i >= 0 && i < size) {
            if (i == 0) {
                first = first.next;
            } else {
                Node head = first;
                while (i > 1) {
                    head = head.next;
                    i--;
                }
                head.next = head.next.next;
            }
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "LinkedList is empty!";
        } else {
            Node head = first;
            StringBuilder valuesString = new StringBuilder();
            valuesString.append(head.value.toString()).append(", ");
            while ((head = head.next) != null) {
                valuesString.append(head.value.toString()).append(", ");
            }
            valuesString.delete(valuesString.length() - 2, valuesString.length()); // Remove last comma and space
            return "LinkedList {" +
                    "values = [" + valuesString.toString() +
                    "]}";
        }
    }

    private class Node {
        T value;
        Node next;
    }
}
