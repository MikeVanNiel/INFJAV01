package nl.hr0152110.springcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nl.hr0152110.springcore.service.UtilityService;

@RestController
public class WordController {

    @Value("${reverse_action}")
    private String reverseAction;

    private final UtilityService utilService;

    @Autowired
    public WordController(UtilityService utilService) {
        this.utilService = utilService;
    }

    @RequestMapping("/")
    public String getHome() {
        return "<h1>Welcome to Word Magic!</h1>" +
                "<p><a href='/word/reverse'>Reverse a word</a></p>" +
                "<p><a href='/word/count'>Count words</a></p>";
    }


    @RequestMapping("/word/reverse")
    public String getReversed() {
        return "Please provide a word to reverse ('/word/reverse/word_to_reverse').";
    }


    @RequestMapping("/word/reverse/{word}")
    public String getReversed(@PathVariable String word) {
        if (reverseAction == "CAPS") {
            return this.utilService.getWordInCaps(word);
        } else {
            return this.utilService.getWordReversed(word);
        }
    }


    @RequestMapping("/word/count")
    public String getCount() {
        return "Please provide some text to count for words ('/word/count/words_to_count').";
    }

    @RequestMapping("/word/count/{text}")
    public String getCount(@PathVariable String text) {
        return "number of words: " + this.utilService.getWordCount(text);
    }
}
