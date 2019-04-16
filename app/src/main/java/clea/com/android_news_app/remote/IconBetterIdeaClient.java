package clea.com.android_news_app.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * created by Bishal on 2019 April 16 9:25 AM
 * version:      V1.0
 * project:      Android_news_App
 * package:      clea.com.android_news_app.remote
 */
public class IconBetterIdeaClient {
    private static Retrofit retrofit;
    public static Retrofit getClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl("http://icons.better-idea.org").addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
