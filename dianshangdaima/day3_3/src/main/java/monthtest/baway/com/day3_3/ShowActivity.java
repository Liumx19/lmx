package monthtest.baway.com.day3_3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import monthtest.baway.com.day3_3.fragment.Frag1;
import monthtest.baway.com.day3_3.fragment.Frag2;

public class ShowActivity extends AppCompatActivity {


    private Frag1 frag1;
    private Frag2 frag2;
    private FragmentManager manager;
    private RadioGroup radioG;
    private FrameLayout vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        vp = findViewById(R.id.vp);
        radioG = findViewById(R.id.radioG);
        frag1 = new Frag1();
        frag2 = new Frag2();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.vp, frag1)
                .add(R.id.vp, frag2)
                .show(frag1)
                .hide(frag2)
                .commit();
        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.rb1:
                        transaction1.show(frag1).hide(frag2);
                        break;
                    case R.id.rb2:
                        transaction1.show(frag2).hide(frag1);
                        break;
                }
                transaction1.commit();
            }
        });
    }


}