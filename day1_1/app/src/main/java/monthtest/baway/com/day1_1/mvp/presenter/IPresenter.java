package monthtest.baway.com.day1_1.mvp.presenter;

import monthtest.baway.com.day1_1.mvp.view.View;

public interface IPresenter {
    //绑定
    void attchView(View view);
    //解绑
    void deachView(View view);
    //传值
    void chuan(String name,String pwd);
}
