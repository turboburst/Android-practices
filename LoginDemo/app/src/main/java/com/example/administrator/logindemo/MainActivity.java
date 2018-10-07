package com.example.administrator.logindemo;
/*
这是个简单的例子，我们使用volley，这个比较老了，但是比较简单容易理解，而且也挺好用的。
我们假设我们发送一个请求，方法是get，url是https://www.baidu.com，这个正常如果你要做login，
那肯定是有header或者params或者都要有，这个需要看服务器是这么要求的，但是这里我们就没有了。
没办法，对百度不能啥请求都发，发了也没用。
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private String username, password;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginbutton);

        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        stringRequest = new StringRequest(Request.Method.GET, "https://www.baidu.com", new Response.Listener<String>() {
            @Override
            /*
            onResponse这个方法，就是处理当你的请求被服务器认可并正确返回的时候的情况
            这里，当百度对我们的get请求返回正确的时候（那是当然的），我们就假设是我们
            的用户名密码那个请求的到了正确的返回，也就是说我们的用户名密码正确了，

            那既然返回正确了，我们就跳转到下一个界面，虽然下一个界面里什么都没有。

            这是怎么处理的我们不管，我们就是根据服务器的要求发送并请求得到返回的结果，根据
            结果我们做相应的处理。

            哦对了，volley的返回之后的这两个方法，是在ui的线程里处理的，很多其他的工具是不同的。
             */
            public void onResponse(String response) {
                Log.i("onresponse", response);
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            //onErrorResponse这个方法，就是处理当你的请求发送以后，服务器返回错误，比如你的url有问题啊，
            //服务器不认可你的请求啊，你忘记在android里面加网络权限啊之类的情况，反正就是有问题的时候。
            public void onErrorResponse(VolleyError error) {
                Log.i("onerrorresponse", error.getMessage());
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            /*
            请求的头信息，是一个map，根据服务器端的接口要求，传递所需的东西
             */
            public Map<String, String> getHeaders() throws AuthFailureError {
                //由于我没有可用的适当的服务器，所以url用的是百度，当然不可能去测试login这种网络请求
                //以下这个是假设，假设服务器是这么要求的，就类似这么写
                /*Map<String, String> theHeader = new HashMap<>();
                theHeader.put("USERNAME", username);
                theHeader.put("PASSWORD", password);
                return theHeader;*/
                return super.getHeaders();
            }

            @Override
            /*
            请求的参数，也是一个map，根据服务器端的接口要求，传递所需的东西
             */
            protected Map<String, String> getParams() throws AuthFailureError {
                ////由于我没有可用的适当的服务器，所以url用的是百度，当然不可能去测试login这种网络请求
                //以下这个是假设，假设服务器是这么要求的，就类似这么写
                /*Map<String, String> theParams = new HashMap<>();
                theParams.put("PARAM_1", "first");
                theParams.put("PARAM_2", "second");
                theParams.put("PARAM_3", "third");
                return theParams;*/
                return super.getParams();
            }
        };

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用volley的时候，把请求加到请求队列里，意思就是发送请求了，就是下面这句话。
                requestQueue.add(stringRequest);
            }
        });

    }
}
