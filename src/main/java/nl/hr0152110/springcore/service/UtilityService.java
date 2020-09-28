package nl.hr0152110.springcore.service;

import nl.hr0152110.springcore.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtilityService {

    private final TextRepository repository;

    @Autowired
    public UtilityService(TextRepository textRepository) {
        this.repository = textRepository;
    }

    public String getWordReversed(String word) {
        String returnValue = "";

        if (word != null) {
            for (int i = word.length() - 1; i >= 0; i--) {
                returnValue += word.charAt(i);
            }
        }

        return returnValue;
    }

    public String getWordInCaps(String word) {
        String returnValue = "";

        if (word != null) {
            returnValue = word.toUpperCase();
        }

        return returnValue;
    }

    public String getWordCount(String text) {
        Integer count = 0;

        if (text != null) {
            count = this.repository.findByKey(text);

            if (count == null || count == 0) {
                count = text.split(" ").length;
                this.repository.save(text, count);
            }
        }

        return count.toString();
    }
}
