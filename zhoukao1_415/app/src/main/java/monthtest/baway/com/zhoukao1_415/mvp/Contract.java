package monthtest.baway.com.zhoukao1_415.mvp;

import monthtest.baway.com.zhoukao1_415.MainActivity;

public interface Contract {
    interface IView {
        void getPreData(String data);
    }

    interface IModel {
        void getRequester(String url, String name, String pwd, ModelCallBack callBack);

        interface ModelCallBack {
            void onSuccess(String data);

            void onFail();
        }
    }

    interface IPresenter {
        void attch(MainActivity mainActivity);

        void detch();

        void login(String url, String name, String pwd);
    }
}
