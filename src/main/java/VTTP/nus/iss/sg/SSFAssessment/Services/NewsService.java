package VTTP.nus.iss.sg.SSFAssessment.Services;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import VTTP.nus.iss.sg.SSFAssessment.Models.Articles;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;


@Service
public class NewsService {

    private static final String NewsURL = "https://min-api.cryptocompare.com/data/v2/news/";


    @Value("${API_KEY}")
    private String apiKey;

    public List<Articles> getArticles(String news){


    String newsUrl = UriComponentsBuilder.fromUriString(NewsURL)
        .queryParam("lang","EN")
        .queryParam("api_key", apiKey)
        .toUriString();
        
        // Create the GET request, GET url
        RequestEntity<Void> req = RequestEntity.get(NewsURL).build();
        
        // Make the call to CryptoCompare
        RestTemplate restTemp = new RestTemplate();
        ResponseEntity<String> resp; 

        // Throws an exception if status code not in between 200-399
        resp = restTemp.exchange(req, String.class);

        // Get payload and exexute acton
        String payload = resp.getBody();
        System.out.println("payload:"+payload);

        /* NewsRepo.save(news, payload);
    } catch (Exception ex) {
        System.err.printf("Error: %s\n", ex.getMessage());
        return Collections.emptyList();
    } 
    }else{
        String payload = opt.get(0);
        System.out.printf(">>>> cache: %s\n", payload);

    } */
        // Convert payload to JsonObject;
        // Convert string to reader
        Reader strReader = new StringReader((String) payload);

        // Create Jsonreader from reader
        JsonReader jsonReader = Json.createReader(strReader);

        // Read payload as Json object
        JsonObject newsResult = jsonReader.readObject();
        JsonArray articles = newsResult.getJsonArray("data");

        List<Articles> list = new LinkedList <>();

        for(int i = 0; i < 10 ; i++) {
            JsonObject jo = articles.getJsonObject(i);
            list.add(Articles.create(jo));
        }

                return list;

        

    }

	public List<Articles> getNews(String articles) {
		return null;
	}

    
}
