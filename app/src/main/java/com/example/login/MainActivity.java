package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
    private TextView logout;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        remainTime = findViewById(R.id.count);
        login = findViewById(R.id.login);
        logout = findViewById(R.id.logout);
        time = 3;

        login.setOnClickListener(this);
        logout.setOnClickListener(this);
        remainTime.setText(" " + time);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                String user = username.getText().toString();
                String pwd = password.getText().toString();
                Log.e("e---->", "user " + user + " pwd " + pwd );
                Toast toast = Toast.makeText(this, null, Toast.LENGTH_SHORT);
                if(time > 0){
                    if(user.equals("admin") && pwd.equals("123456")){
                        toast.setText(R.string.success);
                        toast.show();
                        //参数1：当前的上下文环境。可用getApplicationContext()或this
                        //参数2：要显示的字符串。
                        //参数3：显示的时间长短。Toast默认的有两个LENGTH_LONG(长)和LENGTH_SHORT(短)

                        /*
                        跳转成功
                        */
                    }
                    else if(user.equals("") || pwd.equals("")){
                        toast.setText(R.string.empty);
                        toast.show();
                    }
                    else{
                        time--;
                        remainTime.setText(" " + time);
                        toast.setText(R.string.fail);
                        toast.show();
                    }
                }
                else{
                    toast.setText(R.string.failMuch);
                    toast.show();
                }
                break;
            case R.id.logout:
                System.exit(0);
                break;
                default:break;
        }

    }
}
