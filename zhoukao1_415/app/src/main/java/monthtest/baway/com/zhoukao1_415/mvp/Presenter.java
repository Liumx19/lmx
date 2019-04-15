package monthtest.baway.com.zhoukao1_415.mvp;

import monthtest.baway.com.zhoukao1_415.MainActivity;

public class Presenter implements Contract.IPresenter {

    private Model model;
    MainActivity iView;

    @Override
    public void attch(MainActivity mainActivity) {
        model = new Model();
        this.iView = mainActivity;
    }

    @Override
    public void detch() {
        if (model != null) {
            model = null;
        }
        if (iView != null) {
            iView = null;
        }
        System.gc();
    }

    @Override
    public void login(String url, String name, String pwd) {
        model.getRequester(url, name, pwd, new Contract.IModel.ModelCallBack() {
            @Override
            public void onSuccess(String data) {
                iView.getPreData(data);
            }

            @Override
            public void onFail() {

            }
        });
    }
}
