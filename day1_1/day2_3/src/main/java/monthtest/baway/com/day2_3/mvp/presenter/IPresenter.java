package monthtest.baway.com.day2_3.mvp.presenter;

import monthtest.baway.com.day2_3.mvp.view.IView;

public interface IPresenter {
    void attchView(IView iView);

    void deachView(IView iView);
}
