package VTTP.nus.iss.sg.SSFAssessment.Models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Articles {

    private static Integer newsId;
    private Integer newsPublishedOn;
    private String newsTitle;
    private String newsUrl;
    private String newsImageUrl;
    private String newsBody;
    private String newsTags;
    private String newsCategories;

public Articles(Integer newsId, Integer newsPublishedOn, String newsTitle, 
                String newsUrl, String newsImageUrl, String newsBody,
                String newsTags, String newsCategories) {

        Articles.newsId = newsId;
        this.newsPublishedOn = newsPublishedOn;
        this.newsTitle = newsTitle;
        this.newsUrl = newsUrl;
        this.newsImageUrl = newsImageUrl;
        this.newsBody = newsBody;
        this.newsTags = newsTags;
        this.newsCategories = newsCategories;
        
    }

public Articles() {
}

public Integer getNewsId() {
    return newsId;
}

public void setNewsId(Integer newsId) {
    Articles.newsId = newsId;
}

public Integer getNewsPublishedOn() {
    return newsPublishedOn;
}

public void setNewsPublishedOn(Integer newsPublishedOn) {
    this.newsPublishedOn = newsPublishedOn;
}

public String getNewsTitle() {
    return newsTitle;
}

public void setNewsTitle(String newsTitle) {
    this.newsTitle = newsTitle;
}

public String getNewsUrl() {
    return newsUrl;
}

public void setNewsUrl(String newsUrl) {
    this.newsUrl = newsUrl;
}

public String getNewsImageUrl() {
    return newsImageUrl;
}

public void setNewsImageUrl(String newsImageUrl) {
    this.newsImageUrl = newsImageUrl;
}

public String getNewsBody() {
    return newsBody;
}

public void setNewsBody(String newsBody) {
    this.newsBody = newsBody;
}

public String getNewsTags() {
    return newsTags;
}

public void setNewsTags(String newsTags) {
    this.newsTags = newsTags;
}

public String getNewsCategories() {
    return newsCategories;
}

public void setNewsCategories(String newsCategories) {
    this.newsCategories = newsCategories;
}

public static Articles create (JsonObject jo) {
    Articles n = new Articles ();
    n.setNewsId(jo.getInt("newsId"));
    n.setNewsPublishedOn(jo.getInt("newsPublishedOn"));
    n.setNewsTitle(jo.getString("newsTitle"));
    n.setNewsUrl(jo.getString("newsUrl"));
    n.setNewsImageUrl(jo.getString("newsImageUrl"));
    n.setNewsBody(jo.getString("newsBody"));
    n.setNewsTags(jo.getString("newsTags"));
    n.setNewsCategories(jo.getString("newsCategories"));
    return n;
}

public JsonObject toJson(){
    return Json.createObjectBuilder()
        .add("newsId", newsId)
        .add("newsPublishedOn", newsPublishedOn)
        .add("newsTitle", newsTitle)
        .add("newsUrl", newsUrl)
        .add("newsImageUrl", newsImageUrl)
        .add("newsBody", newsBody)
        .add("newsTags", newsTags)
        .add("newsCategories", newsCategories)
        .build();
}

}
