package com.example.administrator.volleygetrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.administrator.utils.MyApplication;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView textview;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private JsonObjectRequest jsonObjectRequest;
    private String URL= "http://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = MyApplication.getRequestQueue();
        textview = (TextView) findViewById(R.id.textviewid);
        volley_sendGetRequest(URL);
    }

    private void volley_sendGetRequest(String url) {

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textview.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textview.setText(error.toString());

            }
        });
        requestQueue.add(stringRequest);


    }
}
