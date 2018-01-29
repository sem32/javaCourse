import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int BOUND = 50;
        int NUMBERS_TO_ADD = 100;
        int DELETE_COUNTER = 20;

        MySet set = new MySet();

        Random random = new Random();
        System.out.println("=====Add values: ");
        for (int i = 0; i < NUMBERS_TO_ADD; i++) {
            int value = random.nextInt(BOUND);
            System.out.print(value + " ");
            set.add(value);
        }

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


        for (int i = 0; i < DELETE_COUNTER; i++) {
            int remove = random.nextInt(BOUND);
            System.out.println("=====Check remove " + remove + "=====");
            set.remove(remove);
        }
        System.out.println("=====Result=====");
        System.out.println(set);
    }
}
