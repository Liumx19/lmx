package monthtest.baway.com.day3_1.loginmvp;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class Presenter implements Contract.IPresenter {

    private Model model;
    Contract.IView iView;

    @Override
    public void getModel() {

    }

    @Override
    public void attch(final Contract.IView view) {
        model = new Model();
        this.iView = view;
        model.login(new Contract.IModel.CallBack() {
            @Override
            public void onSuccess(String names) {
                view.getPresenter(names);
                Log.i(TAG, "onSuccess: " + names);

            }

            @Override
            public void onFail() {

            }
        });
    }

    @Override
    public void deach() {
        if (iView != null) {
            iView = null;
        }
        if (model != null) {
            model = null;
        }
        System.gc();
    }
}
