package ca.ualberta.cs.lonelytwitter;


public class TweetTooLongException extends Exception {
    TweetTooLongException() {
        /** The super takes advantage of everything in the exception class,
         by calling the constructor of the Exception class with the message created
         */
        super("The message is too long! Please keep your tweets within 140 characters.");
    }
}
