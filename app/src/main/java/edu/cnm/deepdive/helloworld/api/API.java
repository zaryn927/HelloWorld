package edu.cnm.deepdive.helloworld.api;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sky Link on 7/14/2017.
 */

public class API {
  private static ImgurService mService;

  public static void init() {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.readTimeout(60, TimeUnit.SECONDS);
    httpClient.connectTimeout(60, TimeUnit.SECONDS);
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.imgur.com/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(httpClient.build())
        .build();
    mService = retrofit.create(ImgurService.class);
  }
}
