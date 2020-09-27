package nl.hr0152110.springcore.repository;

import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.HashMap;

@Repository
public class TextRepository {

    private Map<String, Integer> dictionary = new HashMap<String, Integer>();

    public Integer findByKey(String text) {
        return dictionary.get(text);
    }

    public void save(String text, Integer count) {
        dictionary.put(text, count);
    }
}
