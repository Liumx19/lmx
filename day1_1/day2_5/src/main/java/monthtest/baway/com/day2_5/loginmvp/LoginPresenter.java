package monthtest.baway.com.day2_5.loginmvp;

import android.util.Log;

public class LoginPresenter implements Contract.ILoginPresenter{
    public static final String TAG="LoginPreSenter";
    private LoginModel loginModel;
    private Contract.ILoginView view;
    //获取model
    @Override
    public void getModel() {

    }

    @Override
    public void attch(final Contract.ILoginView view) {
//初始化model
        loginModel = new LoginModel();
        this.view=view;
        loginModel.login( new Contract.ILoginModel.CallBack() {
            @Override
            public void onSuccess(String names) {
                view.getPresenter(names);
                Log.i(TAG, "onSuccess: "+names);
            }

            @Override
            public void onFail() {

            }
        });
    }

    @Override
    public void detch() {
        if (view!=null){
            view=null;
        }
        if (loginModel!=null){
            loginModel=null;
        }
        //防止内存溢出
        System.gc();
    }
    }

