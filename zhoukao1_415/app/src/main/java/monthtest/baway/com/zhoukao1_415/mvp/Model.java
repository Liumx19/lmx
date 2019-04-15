package monthtest.baway.com.zhoukao1_415.mvp;

import monthtest.baway.com.zhoukao1_415.AsyncHttpClient;
import monthtest.baway.com.zhoukao1_415.mvp.Contract.IModel;

public class Model implements IModel {
    @Override
    public void getRequester(String url, String name, String pwd, final ModelCallBack callBack) {
        AsyncHttpClient.getInstance().PostAsync(url, name, pwd, new AsyncHttpClient.AsyncCallBack() {
            @Override
            public void Error(int errorcode, String message) {

            }

            @Override
            public void Surror(String result) {
                callBack.onSuccess(result);
            }
        });
    }
}
