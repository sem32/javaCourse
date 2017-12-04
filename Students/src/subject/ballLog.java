package Subject;

import java.util.Date;

public class BallLog {
    private Date date;

    private int ball;

    public Date getDate() {
        return date;
    }

    public int getBall() {
        return ball;
    }

    public BallLog(Date date, int ball) {
        this.date = date;
        this.ball = ball;
    }
}
