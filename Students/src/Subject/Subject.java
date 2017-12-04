package Subject;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;

    private List<BallLog> ballLogs;

    private List<VisitLog> visitLogs;

    public Subject(String name) {
        this.name = name;
        ballLogs = new ArrayList<BallLog>();
        visitLogs = new ArrayList<VisitLog>();
    }

    public String getName() {
        return name;
    }

    public int getAverageBall() {
        int result = 0;
        for (int i = 0; i < ballLogs.size(); i++) {
            result += ballLogs.get(i).getBall();
        }
        return result > 0  ? result / ballLogs.size() : 0;
    }

    public int wasAbsent() {
        int result = 0;
        for (int i = 0; i < visitLogs.size(); i++) {
            if (!visitLogs.get(i).isVisited()) {
                result++;
            }
        }
        return result;
    }

    public static List<Subject> init() {
        List<Subject> subjects = new ArrayList<Subject>();
        subjects.add(new Subject("Paint"));
        subjects.add(new Subject("Math"));
        subjects.add(new Subject("Ukr"));
        subjects.add(new Subject("Rus"));
        subjects.add(new Subject("Inform"));

        return subjects;
    }
}
