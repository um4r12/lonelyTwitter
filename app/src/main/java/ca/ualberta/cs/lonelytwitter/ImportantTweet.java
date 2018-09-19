package ca.ualberta.cs.lonelytwitter;

/**
 * Created by lipton on 9/18/18.
 */

public class ImportantTweet extends Tweet {
    ImportantTweet() {
        super();

    }

    ImportantTweet(String message) {
        super(message); //Inheritance
    }

    //Example of overriding
    @Override
    public Boolean isImportant() {
        return true;
    }
}
