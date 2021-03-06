package student;

import subject.Subject;

import java.util.List;

public class Student {
    private String surename;

    private List<Subject> subjects;

    public String getSurename() {
        return surename;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Student(String surename){
        this.surename = surename;
        this.subjects = Subject.init();
    }

    public double getAverageScore() {
        double result = 0;
        for (Subject s : subjects) {
            result += s.getAverageBall();
        }
        return result / subjects.size();
    }
}
