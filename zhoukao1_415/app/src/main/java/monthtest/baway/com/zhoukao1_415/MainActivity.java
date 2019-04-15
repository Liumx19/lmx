package monthtest.baway.com.zhoukao1_415;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import monthtest.baway.com.zhoukao1_415.bean.JsonBean;
import monthtest.baway.com.zhoukao1_415.mvp.Contract;
import monthtest.baway.com.zhoukao1_415.mvp.Presenter;

public class MainActivity extends AppCompatActivity implements Contract.IView {

    private TextView zhuce_login;
    private Presenter presenter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    String Url = "http://172.17.8.100/small/user/v1/login";
    private Button button_login;
    private EditText name_login;
    private EditText pwd_login;
    private Gson gson;
    private JsonBean jsonBean;
    private String pwd;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        zhuce_login = findViewById(R.id.zhuce_login);
        button_login = findViewById(R.id.button_login);
        name_login = findViewById(R.id.name_login);
        pwd_login = findViewById(R.id.pwd_login);
        //点击跳转
        zhuce_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ZhuceActivity.class);
                startActivity(intent);
                finish();
            }
        });
        presenter = new Presenter();
        presenter.attch(this);
        sharedPreferences = getSharedPreferences("mvplogin", MODE_PRIVATE);
        edit = sharedPreferences.edit();
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = name_login.getText().toString();
                pwd = pwd_login.getText().toString();
                if (!name.isEmpty() && !pwd.isEmpty()) {
                    presenter.login(Url, name, pwd);
                    Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "内容不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void getPreData(String data) {
        gson = new Gson();
        if (data != null) {
            jsonBean = gson.fromJson(data, JsonBean.class);
            Toast.makeText(MainActivity.this, jsonBean.getMessage(), Toast.LENGTH_SHORT).show();
            if (jsonBean.getStatus().equals("0000")) {
                edit.putString("pwd", pwd);
                edit.commit();
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "手机号或密码输入错误", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detch();
    }
}
