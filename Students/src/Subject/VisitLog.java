package Subject;

import java.util.Date;

public class VisitLog {
    private Date date;

    private boolean isVisited;

    public Date getDate() {
        return date;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public VisitLog(Date date, boolean isVisited) {
        this.date = date;
        this.isVisited = isVisited;
    }
}
