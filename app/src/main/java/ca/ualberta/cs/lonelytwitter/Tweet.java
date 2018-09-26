package ca.ualberta.cs.lonelytwitter;

/**
 * Created by lipton on 9/18/18.
 */

import java.util.Date;

public abstract class Tweet implements Tweetable {

    private Date date; //set the variables, every tweet will have their own variables
    private String message;
    private static final Integer MAX_CHARS=140; // static = operating on the class itself, true for all instances of the class

    // Need to make constructor to have new tweets now
    // constructor is name of class itself

    Tweet() {
        // Need to initialize everything, set everything that exists for that object
        this.date = new Date();    // this is like self in python
        this.message = "I am default message"; //all would have same message

    }

    Tweet(String message) {
        this.date = new Date();
        this.message = message; // Tweet myTweet = new Tweet("this is new")

    }

    //Make getters
    public Date getDate() {return this.date;} // A way to return the date without allowing someone to modify it

    public String getMessage() {return this.message;}

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length()<= this.MAX_CHARS) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public abstract Boolean isImportant(); //abstract means there's no implementation

    public String toString() {
        return this.getMessage();
    }
}
