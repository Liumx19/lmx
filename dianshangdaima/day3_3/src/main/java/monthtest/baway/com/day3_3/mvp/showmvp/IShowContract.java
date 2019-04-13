package monthtest.baway.com.day3_3.mvp.showmvp;

public interface IShowContract {
    public interface IView {
        void getPresenter(String name);
    }

    public interface IModel {
        void show(IModel.CallBack callBack);

        interface CallBack {
            void onSuccess(String names);

            void onFail();
        }
    }

    public interface IPresenter {
        void getModel();

        void attch(IView view);

        void detch();
    }
}
