package ca.ualberta.cs.lonelytwitter;

/**
 * Created by lipton on 9/18/18.
 */

import java.util.Date;

public abstract class Mood {
    private Date date;

    Mood() {
        this.date = new Date();
    }


    Mood(Date date) {
        this.date = date;
    }

    public abstract String getMood();

    public Date getDate() {return this.date;}


}
