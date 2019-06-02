package clea.com.android_news_app.common;

import clea.com.android_news_app.Interface.IconBetterIdeaService;
import clea.com.android_news_app.Interface.NewsService;
import clea.com.android_news_app.remote.IconBetterIdeaClient;
import clea.com.android_news_app.remote.RetrofitClient;

public class Common {
    private static final String BASE_URL="";
    public static final String API_KEY="60da14a8b3c74b7c967235be46bdeb61";

    public static NewsService getNewsService(){
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }
    public static IconBetterIdeaService getIconService(){
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }


    //https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=a7072d9c2ad9495a8dd5cb58a7fd30df
    public static String getAPIUrl(String source,String sortBy,String apiKEY)
    {
        StringBuilder apiUrl = new StringBuilder(" ");
        return apiUrl.append(source)
                .append("&apiKey=")
                .append(apiKEY)
                .toString();
    }
}
