package student;

import java.util.Comparator;

public class StudentComparatorByName implements Comparator<Student> {
    @Override
    public int compare(Student p1, Student p2) {
        return p1.getSurename().compareTo(p2.getSurename());
    }
}
