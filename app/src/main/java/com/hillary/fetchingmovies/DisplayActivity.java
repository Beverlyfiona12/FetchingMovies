package com.hillary.fetchingmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class DisplayActivity extends AppCompatActivity {
    ListView list;
    CustomAdapter adapter;
    ArrayList<Movie> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        list = findViewById(R.id.listView);
        array=new ArrayList<>();
        adapter=new CustomAdapter(this, array);
        list.setAdapter(adapter);

        fetch();

    }
    public void fetch(){
        String Url="http://jistymarketer.com/789/fetch.php";
        AsyncHttpClient client=new AsyncHttpClient();

        client.get(Url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(DisplayActivity.this, "Failed to Fetch Movies", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                try {
                    //process json
                    JSONArray jarray=new JSONArray(responseString);
                    for (int i = 0; i <jarray.length() ; i++) {
                        JSONObject object = jarray.getJSONObject(i);
                        String title = object.getString("title");
                        String year = object.getString("year");
                        String category = object.getString("category");
                        Movie m=new Movie(title,year,category);
                        array.add(m);


                    }
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(DisplayActivity.this, "Error while processing", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
