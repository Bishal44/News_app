package clea.com.android_news_app.Interface;

import clea.com.android_news_app.Model.Website;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {
    @GET("v2/top-headlines?country=us&apiKey=74881819f4a944379382bebf6e8b7f5a")
    Call<Website> getSources();

}
