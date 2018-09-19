package ca.ualberta.cs.lonelytwitter;


import java.util.Date;


public abstract class Tweet implements Tweetable{

    /**
     scope Type variableName
     Scope defines who in this class will have access
     In this case, private will only allow the Tweet class to have access to the date variable

     */
    // State
    private Date date;
    private String message;
    // static final signifies that the value should not change anywhere in the program
    private static final Integer MAX_CHARS = 140;

    // Constructor; every class should have a constructor.
    // Name of the class itself
    // Initialize and set all the stuff that makes it that object which you want

    /**
     * Two examples of constructors; one which takes no input, and another that does
     */
    protected Tweet() {
        // Everything is an object in java - Date is an object
        // using the 'new' keyword is used to initialize an object
        // 'this' would refer to the 'data' in this object, otherwise it won't be able to determine which data is being referred to
        this.date  = new Date();
        this.message = "I am default message";
    }

    Tweet(String message) {
        this.date  = new Date();
        this.message = message; // Tweet myTweet = new Tweet("My first tweet");
    }

    // We want to be able to change and access things using getters and setters, providing an interface

    public Date getDate(){
        return this.date;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }

    }

    public abstract Boolean isImportant();
}
