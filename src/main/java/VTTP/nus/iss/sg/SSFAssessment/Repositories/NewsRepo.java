package VTTP.nus.iss.sg.SSFAssessment.Repositories;

import java.util.Optional;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import jakarta.json.JsonValue;

@Repository
public class NewsRepo {
    
    @Autowired
    @Qualifier ("redislab")
    private static RedisTemplate<String, STRING> redisTemplate;

    public static void save (String articles, STRING payload){
        ValueOperations<String, STRING> valueOp = redisTemplate.opsForValue();
        valueOp.set(articles.toLowerCase(), payload);
    }

    public Optional<STRING> get(String articles) {
        ValueOperations<String, STRING> valueOp = redisTemplate.opsForValue();
        STRING value = valueOp.get(articles.toLowerCase());
        if (null == value)
            return Optional.empty();
            return Optional. of(value);
    }

    public static void save(String news, String payload) {
    }

    public static void save(String news, Object payload) {
    }

    public Object toJson() {
        return null;
    }

    public static JsonValue getNewsPublishedOn() {
        return null;
    }

    public static JsonValue getNewsTitle() {
        return null;
    }
}
