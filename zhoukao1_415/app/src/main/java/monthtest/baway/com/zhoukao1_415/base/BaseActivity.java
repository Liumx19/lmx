package monthtest.baway.com.zhoukao1_415.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseActivity extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public abstract int bindLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void bindEvent();

    protected <T extends View> T bindView(int resid) {
        return null;
    }
}
