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
}
