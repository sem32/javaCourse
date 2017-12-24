public class CollectionApp {
    public static void main(String[] args) {



        // Check add(Object o)
        MyArrayList arr = new MyArrayList();
        arr.add(3);
        arr.add(8);
        arr.add(44);
        arr.add("Test");
        System.out.println("Test add (3, 8, 44, 'Test') result: " + arr);
        System.out.println("------------------------");

        // Check size()
        System.out.println("Size: " + arr.size());
        System.out.println("------------------------");

        // Check isEmpty()
        System.out.println("isEmpty: " + arr.isEmpty());
        System.out.println("------------------------");

        // Check contains(Object o)
        System.out.println("is Contains 5 in " + arr + " result: " + arr.contains(5));
        System.out.println("is Contains 3 in " + arr + " result: " + arr.contains(3));
        System.out.println("------------------------");

        // Check remove(Object o)
        System.out.println("Before remove 3 from: " + arr);
        arr.remove(3);
        System.out.println("Result of remove 3: " + arr);
        System.out.println("------------------------");

        // Check addAll(Collection c)
        MyArrayList foo = new MyArrayList();
        foo.add("foo");
        foo.add(54);
        foo.add("new value");
        arr.addAll(foo);
        System.out.println("After addAll: " + foo + " retult:" + arr);
        System.out.println("------------------------");

        // Check retainAll(Collection c)
        arr.retainAll(foo);
        System.out.println("After retainAll: " + foo + " result:" + arr);
        System.out.println("------------------------");

        // Check containsAll(Collection c)
        arr.add(99);
        System.out.println("containsAll: " + foo + " result:" + arr.containsAll(foo));
        foo.add(1);
        System.out.println("containsAll: " + foo + " result:" + arr.containsAll(foo));
        System.out.println("------------------------");

        // Check removeAll(Collection c)
        foo.clear();
        foo.add("foo");
        foo.add(54);
        System.out.println("Check removeAll: " + foo + " from " + arr);
        arr.removeAll(foo);
        System.out.println("After removeAll " + foo + " result:" + arr);
        System.out.println("------------------------");

        // Check clear()
        arr.clear();
        System.out.println("After clear: " + arr);
        System.out.println("------------------------");
    }
}
