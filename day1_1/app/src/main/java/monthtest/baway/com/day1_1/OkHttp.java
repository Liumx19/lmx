package monthtest.baway.com.day1_1;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*Time:2019/4/11
 *Author:zhaozhiwei
 *Description:
 */public class OkHttp {
     private static Handler handler = new Handler();
     public static void doPost(String url, String name, String pwd, final Class clazz, final NetCallback netCallback){
         OkHttpClient okHttpClient = new OkHttpClient.Builder()
                 .connectTimeout(3000, TimeUnit.SECONDS)
                 .readTimeout(3000,TimeUnit.SECONDS)
                 .build();

         FormBody builder1 = new FormBody.Builder()
                 .add("phone",name)
                 .add("pwd",pwd)
                 .build();
         Request build = new Request.Builder()
                 .url(url)
                 .post(builder1)
                 .build();
         Call call = okHttpClient.newCall(build);
         call.enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 String string = response.body().string();
                 Gson gson = new Gson();
                 final Object o = gson.fromJson(string, clazz);
                 handler.post(new Runnable() {
                     @Override
                     public void run() {
                         netCallback.onSuccess(o);
                     }
                 });
             }
         });

     }
     public interface NetCallback{
         void onSuccess(Object obj);
     }
}
