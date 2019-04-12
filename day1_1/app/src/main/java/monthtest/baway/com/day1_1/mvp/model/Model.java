package monthtest.baway.com.day1_1.mvp.model;

import monthtest.baway.com.day1_1.Bean;
import monthtest.baway.com.day1_1.OkHttp;

public class Model implements IModel{
    String url="http://172.17.8.100/small/user/v1/login";
    @Override
    public void httpGet(String name, String pwd, final CallBack callBack) {
        //网络请求
        OkHttp.doPost(url, name, pwd, Bean.class, new OkHttp.NetCallback() {
            @Override
            public void onSuccess(Object obj) {
                callBack.onSuccess(obj);
            }

        });
    }
}
