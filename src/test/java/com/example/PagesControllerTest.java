package com.example;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by johnslota on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(PagesController.class)


public class PagesControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testHomepage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));

    }

    @Test
    public void testPatch() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.patch("/patchTask");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Patch"));

    }

    @Test
    public void testDelete() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/deleteTask");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("delete"));

    }

    @Test
    public void testIndexEndpoint() throws Exception {
        this.mvc.perform(get("/vehicles?year=1987&doors=2"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("1987")))
                .andExpect(content().string(Matchers.containsString("2")));
    }

    @Test
    public void testHashEndpoint() throws Exception {
        this.mvc.perform(get("/hash?year=1987&doors=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("{year=1987, doors=2}"));
    }

    @Test
    public void testObjectEndpoint() throws Exception {
        this.mvc.perform(get("/hash?year=1987&doors=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("{year=1987, doors=2}"));
    }

    @Test
    public void testTask() throws Exception {
        TaskInfo task = new TaskInfo();
        this.mvc.perform(get("/tasks?sortBy=title&owner=Chloe"))
                .andExpect(status().isOk())
                .andExpect(content().string("sort-by is title; owner is Chloe"));
    }
}
