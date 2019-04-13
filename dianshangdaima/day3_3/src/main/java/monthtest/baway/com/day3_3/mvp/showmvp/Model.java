package monthtest.baway.com.day3_3.mvp.showmvp;

import monthtest.baway.com.day3_3.net.AsyncHttpClient;

public class Model implements IShowContract.IModel {
    public static final String BaseUrl = "http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10";

    @Override
    public void show(final IShowContract.IModel.CallBack callBack) {
        AsyncHttpClient.getInstance().GetAsync(BaseUrl, new AsyncHttpClient.AsyncCallback() {
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
