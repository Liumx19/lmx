package monthtest.baway.com.day3_3.net;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.common.io.ByteStreams;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AsyncHttpClient {
    private static final AsyncHttpClient ourInstance = new AsyncHttpClient();
    private static final String TAG = "AsyncHttpClient";

    public static AsyncHttpClient getInstance() {
        return ourInstance;
    }
    public void GetAsync(final String url, final AsyncCallback callback) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                return GetDataHttp(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (!TextUtils.isEmpty(s)) {
                    callback.Succore(s);
                } else {
                    callback.Error(503, "未请求到数据");
                }
            }
        }.execute(url);
    }
    public void PostAsync(final String url, final String username, final String pwd, final AsyncCallback callback) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                return PostDataHttp(strings[0], strings[1], strings[2]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (!TextUtils.isEmpty(s)) {
                    callback.Succore(s);
                } else {
                    callback.Error(503, "未请求到数据");
                }
            }
        }.execute(url, username, pwd);
    }
    private String GetDataHttp(String server_url) {
        try {
            URL url = new URL(server_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
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
    private String PostDataHttp(String server_url, String name, String pwd) {
        try {
            URL url = new URL(server_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("POST");
            //请求头的信息
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

    public interface AsyncCallback {
        void Error(int errorcode, String message);

        void Succore(String result);
    }
}
