package eliran.recepie.com.recepiesearch;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class DownloadService extends IntentService {


    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String recepieName=intent.getStringExtra("recepiename");
        String Url="http://www.recipepuppy.com/api/?i="+recepieName+"&q=omelet&p=3";
        OkHttpClient client = new OkHttpClient();
        // GET request
        Request request = new Request.Builder()
                .url(Url)
                .build();
        String jsonRespon="";
        try {
            client.newCall(request).execute();
            Response response = client.newCall(request).execute();
            jsonRespon= response.body().string();

        }catch (IOException interntEX)
        {
        }

        Gson gson=new Gson();
        RecepieGsonArray recepieGsonArray=gson.fromJson(jsonRespon, RecepieGsonArray.class);
        Intent intent1=new Intent("com.recepiesearch.eliran.DONE!");
        intent1.putParcelableArrayListExtra("recepiearray",recepieGsonArray.results);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent1);




    }
}