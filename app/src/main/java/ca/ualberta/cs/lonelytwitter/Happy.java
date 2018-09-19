package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

public class Happy extends Mood {
    private String message;

    Happy() {
        super();
        this.setDate(new Date());
        this.message = "Happy";

    }
    Happy(Date date) {
        super();
        this.setDate(date);
        this.message = "Happy";

    }

    @Override
    public String getMood(){
        return this.message;
    }
}
