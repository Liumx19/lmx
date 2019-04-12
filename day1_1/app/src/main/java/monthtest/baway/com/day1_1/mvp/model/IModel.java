package monthtest.baway.com.day1_1.mvp.model;

public interface IModel {
    //网络请求，逻辑处理
    void httpGet(String name,String pwd,CallBack callBack);
    interface CallBack{
        //成功
        void onSuccess(Object obj);
        //失败
        void onFail(Object objfail);
    }
}
