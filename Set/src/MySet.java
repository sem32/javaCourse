import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet implements Set {

    private class Node {
        private Node left;

        private Node right;

        private Node parent;

        private int data;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    private int size;

    @Override
    public String toString() {
        return toString(head);
    }

    private String toString(Node node) {
        String result = "";
        if (node.left != null) {
            result += toString(node.left);
        }
        result += node.data + " ";
//        result += " data: " + node.data;
//        result += " left: " + (node.left != null ? node.left.data : "null");
//        result += " right: " + (node.right != null ? node.right.data : "null") + ";";
        if (node.right != null) {
            result += toString(node.right);
        }
        return result;
    }

    @Override
    public boolean add(Object o) {
        Node node = new Node((int)o);
        add(node, head);
        return true;
    }

    private boolean add(Node node, Node currentNode) {
        if (head == null) {
            size++;
            head = node;
        } else if (currentNode != null) {
            if (node.data > currentNode.data) {
                if (currentNode.right == null) {
                    size++;
                    currentNode.right = node;
                    node.parent = currentNode;
                } else {
                    add(node, currentNode.right);
                }
            } else if (node.data < currentNode.data) {
                if (currentNode.left == null) {
                    size++;
                    currentNode.left = node;
                    node.parent = currentNode;
                } else {
                    add(node, currentNode.left);
                }
            }
        }
        return true;
    }

    private boolean contains(int data, Node node) {
        if (node == null) {
            return false;
        }
        if (data == node.data) {
            return true;
        } else if (data > node.data) {
            return contains(data, node.right);
        } else if (data < node.data) {
            return contains(data, node.left);
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return contains((int)o, head);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int addToArray(Object[] arr, int index, Node node) {
        if (node == null) {
            return index;
        }
        if (node.left != null) {
            index = addToArray(arr, index, node.left);
        }
        arr[index++] = node.data;
        if (node.right != null) {
            index = addToArray(arr, index, node.right);
        }
        return index;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        addToArray(result, 0, head);
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a == null || a.length < size) {
            return this.toArray();
        }
        addToArray(a, 0, head);
        return a;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length ; i++) {
            add(arr[i]);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            if (!contains(arr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator iterator() {
        Object[] arr = toArray();
        final int[] index = {0};
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index[0] < size;
            }

            @Override
            public Object next() {
                return arr[index[0]++];
            }
        };
    }

    private Node getMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private boolean remove(Node node) {

        if (node.parent != null) {
            if (node.right == null && node.left == null) {
                if (node.parent.left == node) {
                    node.parent.left = null;
                } else if (node.parent.right == node) {
                    node.parent.right = null;
                }
            } else if (node.left == null) {
                if (node.parent.left == node) {
                    node.parent.left = node.right;
                } else if (node.parent.right == node) {
                    node.parent.right = node.right;
                }
                node.right.parent = node.parent;
            } else if (node.right == null ) {
                if (node.parent.left == node) {
                    node.parent.left = node.left;
                } else if (node.parent.right == node) {
                    node.parent.right = node.left;
                }
                node.left.parent = node.parent;
            }
        } else if (head == node) {
            if (node.right == null && node.left == null) {
                head = null;
                return true;
            } else if (node.right == null) {
                head = node.left;

            } else if (node.left == null) {
                head = node.right;
            }
            head.parent = null;
        }

        if (node.right != null && node.left != null) {
            Node min = getMin(node.right);
            if (min.parent.left == min) {
                min.parent.left = min.right;
            } else if (min.parent.right == min) {
                min.parent.right = min.right;
            }

            if (node.parent != null) {
                if (node.parent.right == node) {
                    node.parent.right = min;
                } else if (node.parent.left == node) {
                    node.parent.left = min;
                }
            }
            if (node.left != null) {
                node.left.parent = min;
            }
            if (node.right != null) {
                node.right.parent = min;
            }
            min.parent = node.parent;
            min.left = node.left;
            min.right = node.right;
            if (head == node) {
                head = min;
            }
            node.parent = node.left = node.right = node.parent = null;
        }
        return true;
    }

    private boolean remove(int data, Node node) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            size--;
            remove(node);
        } else if (data > node.data) {
            remove(data, node.right);
        } else {
            remove(data, node.left);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return remove((int)o, head);
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            remove(arr[i]);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] myArr = toArray();
        for (int i = 0; i < myArr.length; i++) {
            if (!c.contains(myArr[i])) {
                remove(myArr[i]);
            }
        }
        return true;
    }
}
