package monthtest.baway.com.day2_3.mvp.presenter;

import monthtest.baway.com.day2_3.mvp.model.Model;
import monthtest.baway.com.day2_3.mvp.view.IView;

public class Presenter implements IPresenter {

    private Model model;
    IView iview;

    @Override
    public void attchView(IView iView) {
        model = new Model();
        this.iview = iView;
    }

    @Override
    public void deachView(IView iView) {

    }
}
