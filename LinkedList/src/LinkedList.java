import java.util.Collection;
import java.util.Iterator;

public class LinkedList implements Collection {

    private static class Node {
        private Object data;

        private Node next = null;

        private Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node head;

    private int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean add(Object o) {
        Node new_item = new Node(o);
        if (head == null) {
            head = new_item;
        } else {
            new_item.next = head;
            head = new_item;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (o.equals(current.data)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] input = c.toArray();
        for (Object item : input) {
            add(item);
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] result = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        return result;
    }

    private boolean isContainsArray(Object[] array, Object value) {
        for (Object anArray : array)
            if (anArray.equals(value)) {
                return true;
            }
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] input = c.toArray();
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (!isContainsArray(input, current.data)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
                size--;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] input = c.toArray();
        boolean result = false;
        for (Object item : input) {
            if (remove(item)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection c) {
        Object[] input = c.toArray();
        for (Object item : input) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        Node current = head;
        while (current != null) {
            if (!result.isEmpty()) {
                result += ", ";
            }
            result += current.toString();
            current = current.next;
        }
        return "{" + result + "}";
    }
}
