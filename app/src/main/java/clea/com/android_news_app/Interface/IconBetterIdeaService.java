package clea.com.android_news_app.Interface;

import clea.com.android_news_app.Model.IconBetterIdea;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * created by Bishal on 2019 April 16 9:17 AM
 * version:      V1.0
 * project:      Android_news_App
 * package:      clea.com.android_news_app.Interface
 */
public interface IconBetterIdeaService {
    @GET
    Call<IconBetterIdea> getIconUrl(@Url String url);
}
