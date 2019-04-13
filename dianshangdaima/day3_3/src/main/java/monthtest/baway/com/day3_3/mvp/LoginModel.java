package monthtest.baway.com.day3_3.mvp;

import monthtest.baway.com.day3_3.net.AsyncHttpClient;

public class LoginModel implements LoginContract.ILoginModel {
    @Override
    public void getRequester(String url, String username, String pwd, final ModelCallBack callBack) {
        AsyncHttpClient.getInstance().PostAsync(url, username, pwd, new AsyncHttpClient.AsyncCallback() {
            @Override
            public void Error(int errorcode, String message) {

            }

            @Override
            public void Succore(String result) {
                callBack.onSuccess(result);
            }
        });
    }
}
