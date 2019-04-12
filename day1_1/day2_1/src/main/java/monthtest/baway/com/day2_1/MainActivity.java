package monthtest.baway.com.day2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import monthtest.baway.com.day2_1.mvp.presenter.Presenter;
import monthtest.baway.com.day2_1.mvp.view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter();

    }

    @Override
    public void Login(Object obj) {

    }
}
