package list;

public class LinkedList<T> implements List<T> {
    private int size;
    private Node first;
    private Node last;

    public LinkedList() {
        first = new Node();
        last = first;
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
            last = first;
        } else {
            Node newNode = new Node();
            newNode.value = t;
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void remove(int i) {
        if (i >= 0 && i < size) {
            Node head = first;
            while (i > 0) {
                head = head.next;
                i--;
            }
            if (head.prev == null) {
                first = first.next;
                if (first != null) {
                    first.prev = null;
                }
            } else {
                head.prev.next = head.next;
            }
            if (head.next == null) {
                last = last.prev;
                if (last != null) {
                    last.next = null;
                }
            } else {
                head.next.prev = head.prev;
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
            return "list.LinkedList is empty!";
        } else {
            Node head = first;
            StringBuilder valuesString = new StringBuilder();
            valuesString.append(head.value.toString()).append(", ");
            while ((head = head.next) != null) {
                valuesString.append(head.value.toString()).append(", ");
            }
            valuesString.delete(valuesString.length() - 2, valuesString.length()); // Remove last comma and space
            return "list.LinkedList {" +
                    "values = [" + valuesString.toString() +
                    "]}";
        }
    }

    private class Node {
        T value;
        Node next;
        Node prev;
    }
}
