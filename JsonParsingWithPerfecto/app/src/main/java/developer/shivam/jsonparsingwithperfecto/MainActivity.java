package developer.shivam.jsonparsingwithperfecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import developer.shivam.jsonparsingwithperfecto.adapter.FeedAdapter;
import developer.shivam.jsonparsingwithperfecto.model.Feed;
import developer.shivam.jsonparsingwithperfecto.util.ParseJson;
import developer.shivam.perfecto.OnRequestComplete;
import developer.shivam.perfecto.Perfecto;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lvItems);
        Perfecto.with(this).fromUrl("http://api.androidhive.info/feed/feed.json").ofTypeGet().connect(new OnRequestComplete() {

            @Override
            public void onSuccess(String s) {
                List<Feed> feeds = ParseJson.ofTypeFeed(s);
                if (feeds.size() != 0) {
                    listView.setAdapter(new FeedAdapter(MainActivity.this, feeds));
                }
            }

            @Override
            public void onFailure(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
