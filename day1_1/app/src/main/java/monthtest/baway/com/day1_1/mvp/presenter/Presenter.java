package monthtest.baway.com.day1_1.mvp.presenter;

import java.lang.ref.SoftReference;

import monthtest.baway.com.day1_1.mvp.model.IModel;
import monthtest.baway.com.day1_1.mvp.model.Model;
import monthtest.baway.com.day1_1.mvp.view.View;

public class Presenter implements IPresenter {
    View viewi;
    private Model model;
    private SoftReference<IModel> softReference;

    @Override
    public void attchView(View view) {
        model = new Model();
        this.viewi = view;
        softReference = new SoftReference<IModel>(model);
    }

    @Override
    public void deachView(View view) {
        softReference.clear();
    }

    @Override
    public void chuan(String name, String pwd) {
        model.httpGet(name, pwd, new IModel.CallBack() {
            @Override
            public void onSuccess(Object obj) {
                viewi.Login(obj);
            }

            @Override
            public void onFail(Object objfail) {

            }
        });
    }
}
