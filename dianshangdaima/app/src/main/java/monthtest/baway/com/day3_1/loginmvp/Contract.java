package monthtest.baway.com.day3_1.loginmvp;

public interface Contract {
    //IView
    public interface IView {
        void getPresenter(String name);
    }

    //IModel
    public interface IModel {
        void login(IModel.CallBack callBack);

        interface CallBack {
            void onSuccess(String names);

            void onFail();
        }
    }

    //IPresenter
    public interface IPresenter {
        void getModel();

        void attch(IView view);

        void deach();
    }
}
