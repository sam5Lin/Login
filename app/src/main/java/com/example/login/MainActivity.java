package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private TextView remainTime;
    private ImageButton login;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        remainTime = findViewById(R.id.remainTime);
        login = findViewById(R.id.login);
        time = 3;

        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String user = username.getText().toString();
        String pwd = password.getText().toString();
        Log.e("e---->", "user " + user + " pwd " + pwd );

            if(time > 0){

                    if(user.equals("admin") && pwd.equals("123456")){
                        Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                        //参数1：当前的上下文环境。可用getApplicationContext()或this
                        //参数2：要显示的字符串。
                        //参数3：显示的时间长短。Toast默认的有两个LENGTH_LONG(长)和LENGTH_SHORT(短)

                        /*
                        跳转成功
                        */
                    }
                    else{
                        time--;
                        String text = "Remaining Times: " + time;
                        remainTime.setText(text);
                        Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
                    }
            }
            else{
                Toast.makeText(this,"你是个好人,但我们不合适",Toast.LENGTH_SHORT).show();
            }
    }
}
