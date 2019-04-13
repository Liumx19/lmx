package monthtest.baway.com.day3_3.mvp.showmvp;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class Presenter implements IShowContract.IPresenter {

    private Model model;
    IShowContract.IView iView;

    @Override
    public void getModel() {

    }

    @Override
    public void attch(final IShowContract.IView view) {
        model = new Model();
        this.iView = view;
        model.show(new IShowContract.IModel.CallBack() {
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
    public void detch() {
        if (model != null) {
            model = null;
        }
        if (iView != null) {
            iView = null;
        }
    }
}
