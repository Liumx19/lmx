package monthtest.baway.com.day2_5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import monthtest.baway.com.day2_5.Adapter.HomeAdapter;
import monthtest.baway.com.day2_5.Bean.HomeBean;
import monthtest.baway.com.day2_5.loginmvp.Contract;
import monthtest.baway.com.day2_5.loginmvp.LoginPresenter;

public class MainActivity extends AppCompatActivity implements Contract.ILoginView {
    private RequestQueue requestQueue;
    private Gson gson;
    private HomeBean homeBean;
    private ListView mlistview;
    private List<HomeBean.ResultBean> homeBeanResult;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        init();
        //初始化presenter
        loginPresenter = new LoginPresenter();
        //调起绑定
        loginPresenter.attch(this);
    }

    private void init() {
        mlistview = findViewById(R.id.listview);

    }

    @Override
    public void getPresenter(String name) {
        //buttonLogin.setText(name);
        gson = new Gson();
        homeBean = gson.fromJson(name, HomeBean.class);
        homeBeanResult = homeBean.getResult();
        mlistview.setAdapter(new HomeAdapter(this, homeBeanResult));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detch();
    }
}
