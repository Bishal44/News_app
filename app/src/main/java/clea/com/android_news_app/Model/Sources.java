package clea.com.android_news_app.Model;

import java.util.List;

 class UrlsToLogs{
     private String small,medium,large;

     public String getSmall() {
         return small;
     }

     public void setSmall(String small) {
         this.small = small;
     }

     public String getMedium() {
         return medium;
     }

     public void setMedium(String medium) {
         this.medium = medium;
     }

     public String getLarge() {
         return large;
     }

     public void setLarge(String large) {
         this.large = large;
     }
 }

public class Sources {
    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;

    private UrlsToLogs urlsToLogs;
    private List<String> sortByAvavible;

    public Sources() {
    }

    public Sources(String id, String name, String description, String url, String category, String language, String country, UrlsToLogs urlsToLogs, List<String> sortByAvavible) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.language = language;
        this.country = country;
        this.urlsToLogs = urlsToLogs;
        this.sortByAvavible = sortByAvavible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UrlsToLogs getUrlsToLogs() {
        return urlsToLogs;
    }

    public void setUrlsToLogs(UrlsToLogs urlsToLogs) {
        this.urlsToLogs = urlsToLogs;
    }

    public List<String> getSortByAvavible() {
        return sortByAvavible;
    }

    public void setSortByAvavible(List<String> sortByAvavible) {
        this.sortByAvavible = sortByAvavible;
    }
}
