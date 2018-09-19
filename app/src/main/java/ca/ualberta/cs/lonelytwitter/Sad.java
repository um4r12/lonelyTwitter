package ca.ualberta.cs.lonelytwitter;
import java.util.Date;


public class Sad extends Mood {
    private String message;

    Sad() {
        super();
        this.setDate(new Date());
        this.message = "Sad";

    }
    Sad(Date date) {
        super();
        this.setDate(date);
        this.message = "Sad";

    }

    @Override
    public String getMood(){
        return this.message;
    }
}
