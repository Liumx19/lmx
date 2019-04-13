package monthtest.baway.com.day3_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import monthtest.baway.com.day3_3.bean.LoginBean;
import monthtest.baway.com.day3_3.mvp.LoginContract;
import monthtest.baway.com.day3_3.mvp.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginContract.ILoginView, View.OnClickListener {

    private EditText name_edit_login, pwd_edit_login;
    private Button button_login;
    private CheckBox check;
    private LoginPresenter loginPresenter;
    public static final String BaseLoginUrl = "http://172.17.8.100/small/user/v1/login";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private Gson gson;
    private LoginBean loginBean;
    private String name;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.zhuce_login).setOnClickListener(this);
        loginPresenter = new LoginPresenter();
        loginPresenter.attch(this);
        sharedPreferences = getSharedPreferences("mvplogin", MODE_PRIVATE);
        edit = sharedPreferences.edit();
        init();
        boolean checked = check.isChecked();
        if (checked){
            sharedPreferences.edit().putString("name_edit_login",name)
            .putString("pwd_edit_login",pwd)
            .commit();
        }else {
            sharedPreferences.edit().putString("name_edit_login","")
                    .putString("pwd_edit_login","")
                    .commit();
        }
    }

    private void init() {
        name_edit_login = findViewById(R.id.name_edit_login);
        pwd_edit_login = findViewById(R.id.pwd_edit_login);
        button_login = findViewById(R.id.button_login);
        check = findViewById(R.id.check);
        button_login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                name = name_edit_login.getText().toString();
                pwd = pwd_edit_login.getText().toString();
                if (!name.isEmpty() && !pwd.isEmpty()) {
                    check.setChecked(true);
                    loginPresenter.login(BaseLoginUrl, name, pwd);
                }
            }
        });
    }

    @Override
    public void getPreData(String data) {
        gson = new Gson();
        if (data != null) {
            loginBean = gson.fromJson(data, LoginBean.class);
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_LONG).show();
            if (loginBean.getStatus().equals("0000")) {
                edit.putString("pwd", pwd);
                edit.commit();
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detch();
    }
    @Override
    public void onClick(View v) {

    }
}
