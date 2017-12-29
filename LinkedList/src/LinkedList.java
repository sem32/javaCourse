import java.util.Collection;
import java.util.Iterator;

public class LinkedList implements Collection {

    private final boolean ADD_TO_HEAD = false;

    private Node head;

    private Node tail;

    private int size = 0;

    private static class Node {
        private Object data;

        private Node next = null;

        private Node prev = null;

        private Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private class LinkedListIterable implements Iterable {
        private Node current = head;

        @Override
        public Iterator iterator() {
            return new Iterator() {
                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public Object next() {
                    Object result = current.data;
                    current = current.next;
                    return result;
                }
            };
        }
    }

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
        if (ADD_TO_HEAD) {
            if (head == null) {
                head = new_item;
                tail = new_item;
            } else {
                new_item.next = head;
                head.prev = new_item;
                head = new_item;
            }
        } else {
            if (head == null) {
                head = new_item;
                tail = new_item;
            } else {
                tail.next = new_item;
                new_item.prev = tail;
                tail = new_item;
            }
        }
        size++;
        return true;
    }

    private void removeCurrent(Node current) {
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
    }

    @Override
    public boolean remove(Object o) {
        Node current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                removeCurrent(current);
                size--;
                return true;
            }
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
        return new LinkedListIterable().iterator();
    }

    public Iterable getIterable() {
        return new LinkedListIterable();
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
        int index = 0;
        if (a.length < size) {
            return toArray();
        } else {
            for (Object o: getIterable()) {
                a[index++] = o;
            }
            for (int i = index; i < a.length; i++) {
                a[i] = null;
            }
            return a;
        }
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
        while (current != null) {
            if (!isContainsArray(input, current.data)) {
                removeCurrent(current);
                size--;
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
        for (Object o: getIterable()) {
            if (!result.isEmpty()) {
                result += ", ";
            }
            result += o;
        }
        return "{" + result + "}";
    }
}
