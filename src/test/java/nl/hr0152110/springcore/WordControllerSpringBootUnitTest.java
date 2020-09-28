package nl.hr0152110.springcore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import nl.hr0152110.springcore.service.UtilityService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WordControllerSpringBootUnitTest {

    @Autowired
    private UtilityService utilityService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(utilityService).isNotNull();
    }

    @Test
    public void testWordReverseContent() throws Exception {
        assertThat(utilityService.getWordReversed("jumbo").equals("obmuj"));
    }

    @Test
    public void testWordCountContent() throws Exception {
        assertThat(utilityService.getWordCount("jumbo jumbo").equals("number of words: 2"));
    }

    @Test
    public void testWordInCaps() throws Exception {
        assertThat(utilityService.getWordCount("JUMBO").equals("JUMBO"));
    }
}
