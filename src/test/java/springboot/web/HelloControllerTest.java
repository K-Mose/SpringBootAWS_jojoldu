package springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.hamcrest.Matchers.is;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import springboot.web.dto.HelloResponseDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_return_upper_hello() throws Exception{

            String hello_upper = "HELLO";

            mvc.perform(get("/hello"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(hello_upper));

    }

    @Test
    public void helloDto_return_test() throws Exception {
        String name = "Mose";
        int amount = 999;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}