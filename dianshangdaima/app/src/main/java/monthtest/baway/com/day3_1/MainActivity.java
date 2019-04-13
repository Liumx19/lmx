package monthtest.baway.com.day3_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import monthtest.baway.com.day3_1.adapter.ListviewAdapter;
import monthtest.baway.com.day3_1.bean.ListviewBean;
import monthtest.baway.com.day3_1.loginmvp.Contract;
import monthtest.baway.com.day3_1.loginmvp.Presenter;

public class MainActivity extends AppCompatActivity implements Contract.IView {

    private RequestQueue requestQueue;
    private ListView listview;
    private Presenter presenter;
    private Gson gson;
    private ListviewBean listviewBean;
    private List<ListviewBean.ResultBean> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        listview = findViewById(R.id.listview);
        //初始化presenter
        presenter = new Presenter();
        presenter.attch(this);
    }

    @Override
    public void getPresenter(String name) {
        gson = new Gson();
        listviewBean = gson.fromJson(name, ListviewBean.class);
        result = listviewBean.getResult();
        listview.setAdapter(new ListviewAdapter(result, this));
    }
}
