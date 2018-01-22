package groupStudents;

import student.Student;
import student.StudentComparatorByName;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class Group extends ArrayList<Student> {

    private String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void delete(String surename) {
        Predicate<Student> studentPredicate = s -> s.getSurename().equals(surename);
        this.removeIf(studentPredicate);
    }

    public boolean contains(String surename) {
        for (Student student : this) {
            if (student.getSurename().equals(surename)) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        this.sort(new StudentComparatorByName());
    }

    public boolean equal(Group compareGroup) {
        boolean result = true;
        if (this.size() != compareGroup.size()) {
            return false;
        }

        /* Make clone for don't change compared groups */
        Group g1 = (Group)this.clone();
        Group g2 = (Group)compareGroup.clone();

        /* Sort both compared groups */
        g1.sort();
        g2.sort();

        for (int i = 0; i < g1.size(); i++) {
            if (!g1.get(i).getSurename().equals(g2.get(i).getSurename())) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void print() {
        System.out.println("Group: " + name);
        int number = 1;
        for (Student student : this) {
            System.out.println(number + ". " + student.getSurename());
            student.getSubjects().stream().forEach(s->{
                System.out.println("\t" + s.getName() + ": \n" +
                        "\t\t- average Ball:\t" + s.getAverageBall() + "\n" +
                        "\t\t- was absent:\t" + s.wasAbsent());
            });
            number++;
        }
    }
}
