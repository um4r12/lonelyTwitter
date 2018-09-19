package ca.ualberta.cs.lonelytwitter;



public class ImportantTweet extends Tweet {
    // Depending on how we chose to initialize Tweet
    ImportantTweet() {
        // Instantiating the parent class if it does not take in any parameter
        super();
    }

    ImportantTweet(String message) {
        // Instantiating the parent class if it does take in the message parameter
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return true;
    }

}
