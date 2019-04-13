package monthtest.baway.com.day3_1.net;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

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

    public void GetAsync(String server_url, final AsyncCallback callBack) {
        new AsyncTask<String, Void, String>() {


            @Override
            protected String doInBackground(String... strings) {
                Log.d(TAG, "doInBackground: " + strings[0]);
                return GetDataHttp(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                if (!TextUtils.isEmpty(s)) {
                    callBack.Succorce(s);
                } else {
                    callBack.Error(503, "未请求到数据");
                }
            }
        }.execute(server_url);
    }

    private String GetDataHttp(String server_url) {
        try {
            Log.d(TAG, "GetDataHttp: " + server_url);
            URL url = new URL(server_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream strea = connection.getInputStream();
                String s = new String(ByteStreams.toByteArray(strea));
                Log.d(TAG, "GetDataHttp: " + s);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String PostDataHttp(String server_url, String name, String pswd) {
        try {
            Log.d(TAG, "PostDataHttp: " + server_url);
            URL url = new URL(server_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            String body = "username=" + URLEncoder.encode(name) + "$pswd=" + URLEncoder.encode(pswd);
            connection.getOutputStream().write(body.getBytes());
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream strea = connection.getInputStream();
                String s = new String(ByteStreams.toByteArray(strea));
                Log.d(TAG, "GetDataHttp: " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface AsyncCallback {
        void Error(int errorcode, String message);

        void Succorce(String result);
    }
}
