package monthtest.baway.com.day2_1.mvp.presenter;

import monthtest.baway.com.day2_1.mvp.model.Model;
import monthtest.baway.com.day2_1.mvp.view.IView;

public class Presenter implements IPresenter {
    IView iview;
    private Model model;

    @Override
    public void attchView(IView iView) {
        model = new Model();
        this.iview = iView;

    }

    @Override
    public void deachView(IView iView) {

    }
}
