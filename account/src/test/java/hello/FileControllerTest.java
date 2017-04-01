package hello;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by mariusz.przybysz on 2017-04-01.
 */
@SpringBootTest
public class FileControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new FileController()).build();
    }

    @Test
    public void getTest() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/files"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0]",equalTo("aa")));
    }
    @Test
    public void postTest() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/files")
                .param("lineToSave","gg"))
                .andDo(MockMvcResultHandlers.print());
    }
}
