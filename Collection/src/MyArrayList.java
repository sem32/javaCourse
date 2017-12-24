import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList implements Collection {
    private Object[] array = new Object[0];

    @Override
    public int size() {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object element : array) {
            if (element == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return toArray(array);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return copy(a);
    }

    @Override
    public boolean add(Object o) {
        Object[] result = new Object[size() + 1];
        for (int i = 0; i < size(); i++) {
            result[i] = array[i];
        }
        result[size()] = o;
        this.array = result;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        int counter_new_array = 0;
        if (index < 0) {
            return false;
        }
        Object[] result = new Object[size() - 1];
        for (int i = 0; i < size(); i++) {
            if (index != i) {
                result[counter_new_array++] = array[i];
            }
        }
        this.array = result;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {

        Object[] input = c.toArray();

        Object[] result = new Object[input.length + size()];
        for (int i = 0; i < result.length; i++) {
            if (i < input.length) {
                result[i] = input[i];
            } else {
                result[i] = array[i - input.length];
            }
        }
        array = result;
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] input = c.toArray();
        Object[] foo = new Object[array.length];
        int new_counter = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j].equals(input[i])) {
                    foo[new_counter++] = array[j];
                }
            }
        }
        Object[] result = new Object[new_counter];
        for (int i = 0; i < result.length; i++) {
            result[i] = foo[i];
        }
        array = result;

        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] input = c.toArray();
        int deleted = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < array.length; j++)
                if (array[j] != null && array[j].equals(input[i])) {
                    array[j] = null;
                    deleted++;
                }
        }
        if (deleted > 0) {
            Object[] result = new Object[array.length - deleted];
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    result[j++] = array[i];
                }
            }
            array = result;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        Object[] input = c.toArray();
        if (input.length > array.length) {
            return false;
        }
        Object[] foo = toArray(array);
        int contains_counter = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < foo.length; j++) {
                if (foo[j]!= null && input[i] != null && foo[j].equals(input[i])) {
                    contains_counter++;
                    foo[j] = null;
                    input[i] = null;
                }
            }
        }
        return contains_counter == input.length;
    }

    public static Object[] copy(Object[] a) {
        if (a == null) {
            return new Object[0];
        }
        Object[] result = new Object[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i];
        }
        return result;
    }

    public void clear() {
        this.array = null;
    }

    public void sort() {
        Arrays.sort(this.array);
    }

    @Override
    public String toString() {
        String result = "";
        if (this.array == null) {
            return "{}";
        }
        for (Object value : array) {
            if (!result.isEmpty()) {
                result += ",";
            }
            result += String.valueOf(value);
        }

        return "{" + result + "}";
    }

    private int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

}
