public class MyArrayApp {

    public static void main(String[] args) {

        MyArrayList arr = new MyArrayList(new int[] {4,2,1,3});
        System.out.println("Array: " + arr.toString());

        arr.add(5);
        System.out.println("Add value 5 to array. Result: " + arr.toString());

        System.out.println("Index of value 2: " + arr.get(2));

        System.out.println("Value 3 is " + (arr.contains(3) ? "contains" : "not contains"));

        MyArrayList newArray = new MyArrayList(new int[] {9, 8, 7, 6});
        MyArrayList clone = arr.clone();
        arr.addAll(newArray);
        System.out.println("Merge arrays (" + clone.toString() + " and " + newArray.toString() + ". Result: " + arr.toString());

        newArray = new MyArrayList(new int[] {1,2,3,4,5,6,7,8,9});
        boolean equals = arr.equals(newArray);
        System.out.println("Arrays " + arr.toString() + " and " + newArray.toString() + " " + (equals ? "are equals" : "aren't equals"));

        System.out.println("Index of value 5 is " + arr.indexOf(5));

        System.out.println("Size of array: " + arr.getSize());

        arr.sort();
        System.out.println("Sorted array: " + arr.toString());

        arr.clear();
        System.out.println("Cleared array: " + arr.toString());
    }
}
