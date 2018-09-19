package ca.ualberta.cs.lonelytwitter;

/**
 * Created by lipton on 9/18/18.
 */

public class TweetTooLongException extends Exception {

    //create constructor for the class
    TweetTooLongException() {
        super("The message is too long, make it less than 140");
        //super calls the methods in the base class
    }
}
