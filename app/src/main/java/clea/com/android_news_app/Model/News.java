package clea.com.android_news_app.Model;

import java.util.List;

/**
 * created by Bishal on 2019 April 21 5:34 PM
 * version:      V1.0
 * project:      Android_news_App
 * package:      clea.com.android_news_app.Model
 */
public class News {
    private String status;
    private String source;
    private String sortBy;
    private List<Article> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
