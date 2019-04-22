package clea.com.android_news_app.Interface;

import clea.com.android_news_app.Model.News;
import clea.com.android_news_app.Model.Website;
import clea.com.android_news_app.common.Common;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewsService {
    @GET("v2/sources?language=en&apiKey="+ Common.API_KEY)
    Call<Website> getSources();

    @GET
    Call<News> getNewestArticles(@Url String url);
}
