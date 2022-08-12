package VTTP.nus.iss.sg.SSFAssessment.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import VTTP.nus.iss.sg.SSFAssessment.Models.Articles;
import VTTP.nus.iss.sg.SSFAssessment.Services.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsSvc;

    @GetMapping
    public String getNews(Model model, @RequestParam String articles) {
        List<Articles> news = newsSvc.getNews(articles);
        model.addAttribute("articles", articles.toUpperCase());
        model.addAttribute("news", news);
        return "news";
}
    
    @PostMapping(value = "/saveArticles")

        public String saveArticles (Model model,
            @ModelAttribute ("Articles"), Articles articles) {
                
        String articles = articleForm.getArticles ();
        
        if (articles > 0) {
            Articles newArticles = new Articles();
            newsSvc.addArtciles(newArticles);
        }
                
        model.addAttribute("errorMessage", errorMessage);    
        return "Articles";

        }
    }