import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int BOUND = 50;
        int NUMBERS_TO_ADD = 100;

        MySet set = new MySet();

        Random random = new Random();
        System.out.println("=====Add values: ");
        for (int i = 0; i < NUMBERS_TO_ADD; i++) {
            int value = random.nextInt(BOUND);
            System.out.print(value + " ");
            set.add(value);
        }
        System.out.println("=====");

        System.out.println("=====Check toString(set)=====");
        System.out.println(set);

        int check = random.nextInt(BOUND);
        System.out.println("=====Check contains("+check+")=====");
        System.out.println(set.contains(check));

        System.out.println("=====Check contains("+(BOUND+1)+")=====");
        System.out.println(set.contains(BOUND+1));

        System.out.println("=====Check toArray()=====");
        for (Object value : set.toArray()) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("=====Check iterator=====");
        for (Object o : set) {
            System.out.print(o + " ");
        }
        System.out.println();


        int remove = random.nextInt(BOUND);
        System.out.println("=====Check remove "+remove+"=====");
        set.remove(remove);
        remove = random.nextInt(BOUND);
        System.out.println("=====Check remove "+remove+"=====");
        set.remove(random.nextInt(10));
        remove = random.nextInt(BOUND);
        System.out.println("=====Check remove "+remove+"=====");
        set.remove(random.nextInt(10));
        System.out.println("=====Result=====");
        System.out.println(set);
    }
}
