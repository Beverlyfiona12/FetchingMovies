package com.hillary.fetchingmovies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
EditText inputTitle,inputYear,inputCategory;
ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputTitle=findViewById(R.id.inputTitle);
        inputYear=findViewById(R.id.inputYear);
        inputCategory=findViewById(R.id.inputCategory);
        progress=new ProgressDialog(this);
        progress.setMessage("Saving in progress");
    }

    public void save(View view) {
    String title= inputTitle.getText().toString().trim();
    String year=inputYear.getText().toString().trim();
    String category= inputCategory.getText().toString().trim();
    //if data is not available the toast appears

        if (title.isEmpty()||year.isEmpty()||category.isEmpty())
        {
            Toast.makeText(this,"Empty Field",Toast.LENGTH_SHORT).show();
            return;
        }


        String Url="http://jistymarketer.com/789/save.php";
        AsyncHttpClient client =new AsyncHttpClient();
        RequestParams params=new RequestParams();
        params.put("title",title);
        params.put("year",year);
        params.put("category",category);
        client.post(Url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Failed to save", Toast.LENGTH_SHORT).show();
                progress.dismiss();
                //clearing the dat on the keyboard

                if (responseString.equalsIgnoreCase("success"))
                {
                    inputTitle.setText("");
                    inputYear.setText("");
                    inputCategory.setText("");
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Toast.makeText(MainActivity.this, "+responseString", Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });



    }

    public void show(View view) {
        Intent x=new Intent(this,DisplayActivity.class);
        startActivity(x);
    }
}
