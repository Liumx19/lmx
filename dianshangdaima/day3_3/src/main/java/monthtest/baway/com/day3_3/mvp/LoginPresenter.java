package monthtest.baway.com.day3_3.mvp;

import monthtest.baway.com.day3_3.MainActivity;

public class LoginPresenter implements LoginContract.ILoginPresenter {

    private LoginModel loginModel;
    MainActivity iLoginView;

    @Override
    public void attch(MainActivity mainActivity) {
        loginModel = new LoginModel();
        this.iLoginView = mainActivity;
    }

    @Override
    public void detch() {
        if (loginModel != null) {
            loginModel = null;
        }
        if (iLoginView != null) {
            iLoginView = null;
        }
        System.gc();
    }

    @Override
    public void login(String url, String username, String pwd) {
        loginModel.getRequester(url, username, pwd, new LoginContract.ILoginModel.ModelCallBack() {
            @Override
            public void onSuccess(String data) {
                iLoginView.getPreData(data);
            }

            @Override
            public void onFail() {

            }
        });
    }
}
