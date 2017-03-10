package com.example;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(JSONResponseController.class)
public class JSONResponseControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testObject() throws Exception {
        this.mvc.perform(
                get("/json/flights/flight")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tickets[0].passenger.firstName", is("Dwayne")))
                .andExpect(jsonPath("$.tickets[0].passenger.lastName", is("Johnson")))
                .andExpect(jsonPath("$.tickets[0].price", is(200)));

    }

    @Test
    public void testObjects() throws Exception {
        this.mvc.perform(
                get("/json/flights")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tickets[0].passenger.firstName", is("Dwayne")))
                .andExpect(jsonPath("$.tickets[0].passenger.lastName", is("Johnson")))
                .andExpect(jsonPath("$.tickets[0].price", is(200)))
                .andExpect(jsonPath("$.tickets[1].passenger.firstName", is("Bob")))
                .andExpect(jsonPath("$.tickets[1].passenger.lastName", is("Wayne")))
                .andExpect(jsonPath("$.tickets[1].price", is(600)));

    }


}
