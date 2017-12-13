import java.util.Arrays;

public class MyArrayList {
    private int [] array;

    public MyArrayList(int[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public int getSize() {
        if (array == null) {
            return 0;
        }
        return this.array.length;
    }

    public void add(int value) {
        int[] result = new int[getSize() + 1];
        for (int i = 0; i < getSize(); i++) {
            result[i] = array[i];
        }

        result[getSize()] = value;
        this.array = result;
    }

    public int get(int index) {
        if (index >= getSize()) {
            System.out.println("Error");
            return -1;
        }
        return array[index];
    }

    public int indexOf(int value) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int data) {
        return indexOf(data) != -1;
    }

    public void addAll(MyArrayList data) {
        int length = data.getSize() + this.getSize();

        int[] result = new int[length];
        for (int i = 0; i < length; i++ ) {
            if (i < data.getSize()) {
                result[i] = data.get(i);
            } else {
                result[i] = this.array[i-data.getSize()];
            }
        }

        this.array = result;
    }

    public MyArrayList clone() {
        return new MyArrayList(this.array);
    }

    public boolean equals(MyArrayList data) {
        if (this.getSize() != data.getSize()) {
            return false;
        }

        MyArrayList arrayA = this.clone();
        MyArrayList arrayB = data.clone();

        arrayA.sort();
        arrayB.sort();
        for (int i = 0; i < arrayA.getSize(); i++) {
            if (arrayA.array[i] != arrayB.array[i]) {
                return false;
            }
        }

        return true;
    }

    public void clear() {
        this.array = null;
    }

    public void sort() {
        Arrays.sort(this.array);
    }

    public String toString() {
        String result = "";
        if (this.array == null) {
            return "{}";
        }
        for (int value : array) {
            if (!result.isEmpty()) {
                result += ",";
            }
            result += String.valueOf(value);
        }

        return "{" + result + "}";
    }
}
