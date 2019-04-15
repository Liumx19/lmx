package monthtest.baway.com.zhoukao1_415;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ZhuceActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView login_zhuce;
    private EditText name_zhuce, pwd_zhuce, que_zhuce;
    private Button button_zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        findViewById(R.id.fanhui_zhuce).setOnClickListener(this);
        //初始化
        name_zhuce = findViewById(R.id.name_zhuce);
        pwd_zhuce = findViewById(R.id.pwd_zhuce);
        que_zhuce = findViewById(R.id.que_zhuce);
        button_zhuce = findViewById(R.id.button_zhuce);
        login_zhuce = findViewById(R.id.login_zhuce);
        //点击跳转
        login_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZhuceActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //
        button_zhuce.setOnClickListener(new View.OnClickListener() {

            private String que;
            private String name;
            private String pwd;

            @Override
            public void onClick(View v) {
                pwd = pwd_zhuce.getText().toString();
                name = name_zhuce.getText().toString();
                que = que_zhuce.getText().toString();
                if (!name.isEmpty() && !pwd.isEmpty() && !que.isEmpty()) {
                    if (pwd.equals(que)) {
                        Toast.makeText(ZhuceActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ZhuceActivity.this, MainActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("pwd", pwd);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(ZhuceActivity.this, "输入的密码不正确", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ZhuceActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ZhuceActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
