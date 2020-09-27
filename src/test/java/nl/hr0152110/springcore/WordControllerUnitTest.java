package nl.hr0152110.springcore;

import nl.hr0152110.springcore.controller.WordController;
import nl.hr0152110.springcore.service.UtilityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(WordController.class)
public class WordControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UtilityService utilityService;


    @Test
    public void testWordReverseStatus() throws Exception {
        mockMvc.perform(get("/word/reverse/jumbo"))
                .andExpect(status().isOk());
    }

    @Test
    public void testWordReverseContent() throws Exception {
        mockMvc.perform(get("/word/reverse/jumbo"))
                .andExpect(content().string(""));
    }

    @Test
    public void testWordCountStatus() throws Exception {
        mockMvc.perform(get("/word/count/jumbo"))
                .andExpect(status().isOk());
    }

    @Test
    public void testWordCountContent() throws Exception {
        mockMvc.perform(get("/word/count/jumbo jumbo"))
                .andExpect(content().string("number of words: null"));
    }
}
