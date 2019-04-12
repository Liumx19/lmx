package monthtest.baway.com.day2_1.mvp.model;

public interface IModel {
    //网络请求，逻辑处理
    void httpGet(String Url, CallBack callBack);

    interface CallBack {
        //成功
        void onSuccess(Object objs);

        //失败
        void onFail(Object objf);

    }

}
