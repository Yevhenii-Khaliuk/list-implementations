package list;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] values;
    private int size;

    public ArrayList() {
        values = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayList(int capacity) {
        values = new Object[capacity];
        size = 0;
    }

    @Override
    public T get() {
        Object value = null;
        if (values[0] != null) {
            value = values[0];
        }
        return value == null ? null : (T) value;
    }

    public T get(int index) {
        Object value = null;
        if (index < size) {
            value = values[index];
        }
        return value == null ? null : (T) value;
    }

    @Override
    public void add(T t) {
        if (size == values.length) {
            resizeGreater();
        }
        values[size] = t;
        size++;
    }

    @Override
    public void remove(int i) {
        if (i >= 0 && i < size) {
            for (int index = i; index < size - 1; index++) {
                values[index] = values[index + 1];
            }
            size--;
            if (size <= values.length / 4 && values.length > DEFAULT_CAPACITY) {
                resizeLess();
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void resizeGreater() {
        Object[] newValues = new Object[values.length * 2];
        System.arraycopy(values, 0, newValues, 0, size);
        values = newValues;
    }

    private void resizeLess() {
        Object[] newValues = new Object[values.length / 2];
        System.arraycopy(values, 0, newValues, 0, size);
        values = newValues;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "list.ArrayList is empty!";
        } else {
            StringBuilder valuesString = new StringBuilder();
            for (int i = 0; i < size; i++) {
                valuesString.append(values[i].toString()).append(", ");
            }
            valuesString.delete(valuesString.length() - 2, valuesString.length()); // Remove last comma and space
            return "list.ArrayList {" +
                    "values = [" + valuesString.toString() +
                    "]}";
        }
    }
}
