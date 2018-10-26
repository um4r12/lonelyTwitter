package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    TextView passedTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        passedTweet = (TextView)findViewById(R.id.textView);

        String clickedTweet;
        clickedTweet = getIntent().getStringExtra("ClickedTweet");
        passedTweet.setText(clickedTweet);
    }
}
