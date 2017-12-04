import subject.Subject;
import com.sun.istack.internal.NotNull;

import java.util.List;

public class Student {
    @NotNull
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
