package monthtest.baway.com.day1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import monthtest.baway.com.day1_1.mvp.presenter.Presenter;
import monthtest.baway.com.day1_1.mvp.view.View;

public class MainActivity extends AppCompatActivity implements View {

    private Presenter presenter;
    private EditText edit_name;
    private EditText edit_pwd;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_pwd);
        button = findViewById(R.id.button);
        presenter = new Presenter();
        //绑定视图
        presenter.attchView(MainActivity.this);
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String name = edit_name.getText().toString();
                String pwd = edit_pwd.getText().toString();
                presenter.chuan(name,pwd);
            }
        });
    }

    @Override
    public void Login(Object obj) {
        Bean bean= (Bean) obj;
        String message = bean.getMessage();
        String status = bean.getStatus();
        if (status.equals("0000")){
            Toast.makeText(MainActivity.this,"123"+message,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this,"123"+message,Toast.LENGTH_SHORT).show();
        }
    }
}
