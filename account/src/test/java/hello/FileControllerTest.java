package hello;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by mariusz.przybysz on 2017-04-01.
 */
@SpringBootTest
public class FileControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new FileController()).build();
    }

    @Test
    public void delTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/files"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    public void postTest() throws Exception {
        //new File("test.txt").delete();
        mockMvc.perform(MockMvcRequestBuilders.delete("/files"));

        mockMvc.perform(MockMvcRequestBuilders.post("/files")
                .content("test3"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/files"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0]", equalTo("test3")));
    }



}
