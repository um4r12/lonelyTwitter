package ca.ualberta.cs.lonelytwitter;

/**
 * Created by lipton on 9/25/18.
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return false;
    }
}
