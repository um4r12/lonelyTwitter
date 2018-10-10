package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by romansky on 10/20/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client; // Same one between instances with controllers

    // TODO we need a function which adds tweets to elastic search
    // A sync tasks, runs asynchrously
    // UI won't wait for it, and will run independently
    // To make a request to an elastic search server the AddTweetsTask will post tweets into elastic search
    public static class AddTweetsTask extends AsyncTask<NormalTweet, Void, Void> {

        // Only one method which will run whenever we execute the AddTweetTask
        @Override
        // Multiple arguments
        protected Void doInBackground(NormalTweet... tweets) {
            // This method ensures that the client is initialized. If not, it will create a builder and then create the client
            verifySettings();

            for (NormalTweet tweet : tweets) {
                // Building an index with index as testing and type being tweet
                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();

                try {
                    // When we build the index, we pass the tweet inside it
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        tweet.setId(result.getId());
                    } else {
                        Log.e("Error", "Elastic search was not able to add the tweet");
                    }
                }
                catch (Exception e) {
                    Log.i("Error", "The application failed to build and send the tweets");
                }

            }
            return null;
        }
    }

    // TODO we need a function which gets tweets from elastic search
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<NormalTweet>> {
        @Override
        protected ArrayList<NormalTweet> doInBackground(String... search_parameters) {

            // Ensure that the client exists
            verifySettings();
            // Initialize tweets
            ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

            // The first parameter will be used as a term to search
            // This search will search for the first parameter that will be sent to testing index
            Search search = new Search.Builder(search_parameters[0]).addIndex("testing").addType("tweet").build();
            Log.e("Search parameters: ", search_parameters[0]);
                // TODO Build the query

            try {
                SearchResult result = client.execute(search);
                if(result.isSucceeded()) {
                   List<NormalTweet> foundTweets = result.getSourceAsObjectList(NormalTweet.class);
                   tweets.addAll(foundTweets);
                } else {
                    Log.e("Error", "The search query failed to find any tweets that matched");
                }
               // TODO get the results of the query
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return tweets;
        }
    }




    public static void verifySettings() {
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}