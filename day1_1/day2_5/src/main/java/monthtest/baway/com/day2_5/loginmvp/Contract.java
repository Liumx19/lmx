package monthtest.baway.com.day2_5.loginmvp;

public interface Contract {
    //IView
    public interface ILoginView{
        void getPresenter(String name);
    }
    //IModel
    public interface ILoginModel{
        void login(ILoginModel.CallBack callBack);
        interface CallBack{
            void onSuccess(String names);
            void onFail();
        }
    }
    //IPresenter
    public interface ILoginPresenter{
        void getModel();
        void attch(ILoginView view);
        void detch();
    }
}
