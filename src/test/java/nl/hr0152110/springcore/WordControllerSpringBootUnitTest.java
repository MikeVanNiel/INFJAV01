package nl.hr0152110.springcore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import nl.hr0152110.springcore.controller.WordController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WordControllerSpringBootUnitTest {
    @Autowired
    private WordController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testWordReverseContent() throws Exception {
        assertThat(controller.getReversed("jumbo").startsWith("obmuj"));
    }

    @Test
    public void testWordCountContent() throws Exception {
        assertThat(controller.getCount("jumbo jumbo").equalsIgnoreCase("number of words: 2"));
    }
}
