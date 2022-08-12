package VTTP.nus.iss.sg.SSFAssessment.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VTTP.nus.iss.sg.SSFAssessment.Repositories.NewsRepo;
import VTTP.nus.iss.sg.SSFAssessment.Services.NewsService;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;

@RestController
@RequestMapping(path="/Articles", produces="application/json")
public class NewsRESTController {

    @Autowired
    private NewsService newsSvc;
    private Object user;

    @GetMapping(value="{newsId}")
    public ResponseEntity<String> getNews(@PathVariable String newsId) {
        Optional<NewsRepo> opt = newsSvc.getNewsById(newsId);

        if (opt.isEmpty()) {
            JsonObject err = Json.createObjectBuilder()
                .add("error", "Cannot find news article Id %s".formatted(userid))
                .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(err.toString());

        } else {
            final JsonObject resp = Json.createObjectBuilder()
                .add("newsId", getNewsId())    
                .add("newsPublishedOn", getNewsPublishedOn())
                .add("newsTitle", getNewsTitle())
                .add("newsUrl", getNewsUrl())
                .add("newsImageUrl", getNewsImageUrl())
                .add("newsBody", getNewsBody())
                .add("newsTags", getNewsTags())
                .add("newsCategories", getNewsCategories())
                .build();

        }

        NewsRepo news = opt.get();
        return ResponseEntity.ok(news.toJson().toString());
        
    }  

    
}
