package clea.com.android_news_app.common;

import clea.com.android_news_app.Interface.NewsService;
import clea.com.android_news_app.remote.RetrofitClient;

public class Common {
    private static final String BASE_URL="https://newsapi.org/";
    public static final String API_KEY="74881819f4a944379382bebf6e8b7f5a";

    public static NewsService getNewsService(){
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }
}
