package developer.shivam.swiperecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import developer.shivam.swiperecyclerview.adapter.NamesAdapter;
import developer.shivam.swiperecyclerview.helper.SwipeHelper;

public class MainActivity extends AppCompatActivity {

    private final String[] names = {"Shivam Satija (developer-shivam)",
            "Tarun Mudgal (tarun0)",
            "Chetan Kaushik (dynamitechetan)",
            "Rahul Bhatia", "Ishmeet Singh", "Pulkit Kumar", "Shadab Hussain"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> names = new ArrayList<>();
        names.add("Shivam Satija (developer-shivam)");
        names.add("Tarun Mudgal (tarun0)");
        names.add("Chetan Kaushik (dynamitechetan)");
        names.add("Rahul Bhatia");
        names.add("Ishmeet Singh");
        names.add("Pulkit Kumar");
        names.add("Shadab Hussain");
        names.add("Vishal Thadari");
        names.add("Shivam Satija (developer-shivam)");
        names.add("Tarun Mudgal (tarun0)");
        names.add("Chetan Kaushik (dynamitechetan)");
        names.add("Rahul Bhatia");
        names.add("Ishmeet Singh");
        names.add("Pulkit Kumar");
        names.add("Shadab Hussain");
        names.add("Vishal Thadari");

        RecyclerView rvNames = (RecyclerView) findViewById(R.id.rvNames);
        rvNames.setLayoutManager(new LinearLayoutManager(this));
        NamesAdapter adapter = new NamesAdapter(this, names);
        rvNames.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SwipeHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rvNames);
    }
}
