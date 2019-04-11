package clea.com.android_news_app.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    public static Retrofit getClient(String baseurl){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }

}
