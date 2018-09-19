package ca.ualberta.cs.lonelytwitter;

/**
 * Created by lipton on 9/18/18.
 */

public class Sad extends Mood {
    private String message;

    Sad() {
        // Need to initialize everything, set everything that exists for that object
        this.message = "I am sad";    // this is like self in python
    }

    public String getMood() {return this.message;}
}
