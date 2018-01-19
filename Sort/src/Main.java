import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int ELEMENTS = 30;

        Random random = new Random();
        ArrayList arrayList = new ArrayList<>();
        for (int i = 0; i < ELEMENTS; i++) {
            arrayList.add(random.nextInt(100));
        }

        System.out.println("arrayList:\n\t" + arrayList);

        arrayList.sort((o1, o2) -> {
            if (((int)o1 % 2 == 0)) return 1;
            else if (o1.equals(o2)) return 0;
            else return -1;
        });

        arrayList.sort((o1, o2) -> {
            int i1 = (int)o1;
            int i2 = (int)o2;
            if ((i1 > i2 && i1 % 2 == i2 % 2)) return 1;
            else if (o1.equals(o2)) return 0;
            else return -1;
        });

        System.out.println("sorted Array:\n\t" + arrayList);
    }
}
