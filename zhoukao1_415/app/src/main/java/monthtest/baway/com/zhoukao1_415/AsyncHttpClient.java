package monthtest.baway.com.zhoukao1_415;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.common.io.ByteStreams;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AsyncHttpClient {
    public static final AsyncHttpClient ourInstance = new AsyncHttpClient();
    public static final String TAG = "AsyncHttpClient";

    public static AsyncHttpClient getInstance() {
        return ourInstance;
    }

    public void PostAsync(final String url, final String name, final String pwd, final AsyncCallBack callBack) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                return PostDataHttp(strings[0], strings[1], strings[2]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (TextUtils.isEmpty(s)) {
                    callBack.Surror(s);
                } else {
                    callBack.Error(503, "未找到数据");
                }
            }
        }.execute(url, name, pwd);
    }

    private String PostDataHttp(String server_url, String name, String pwd) {
        try {
            URL url = new URL(server_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            String body = "phone=" + URLEncoder.encode(name) + "&pwd=" + URLEncoder.encode(pwd);
            connection.getOutputStream().write(body.getBytes());
            if (connection.getResponseCode() == connection.HTTP_OK) {
                InputStream stream = connection.getInputStream();
                String s = new String(ByteStreams.toByteArray(stream));
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface AsyncCallBack {
        void Error(int errorcode, String message);

        void Surror(String result);
    }
}
