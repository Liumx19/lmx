package monthtest.baway.com.day2_1.mvp.presenter;

import monthtest.baway.com.day2_1.mvp.view.IView;

public interface IPresenter {
    //绑定
    void attchView(IView iView);

    //解绑
    void deachView(IView iView);
    //传值
}
