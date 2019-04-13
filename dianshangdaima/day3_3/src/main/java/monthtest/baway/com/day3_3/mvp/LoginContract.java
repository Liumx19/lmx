package monthtest.baway.com.day3_3.mvp;

import monthtest.baway.com.day3_3.MainActivity;

public interface LoginContract {
    //Iview
    interface ILoginView {
        void getPreData(String data);
    }

    //Imodel
    interface ILoginModel {
        void getRequester(String url, String username, String pwd, ModelCallBack callBack);

        interface ModelCallBack {
            void onSuccess(String data);

            void onFail();
        }
    }

    //Ipresenter
    interface ILoginPresenter {
        void attch(MainActivity mainActivity);

        void detch();

        void login(String url, String username, String pwd);
    }
}
