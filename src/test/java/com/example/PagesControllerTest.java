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
 * Created by johnslota on 3/10/17.
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
    public void testPost() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/tasks");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("You're a poster"));

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

    @Test
    public void namePath() throws Exception {
        TaskInfo task = new TaskInfo();
        this.mvc.perform(get("/tv-shows/genre/fantasy/length/1h"))
                .andExpect(status().isOk())
                .andExpect(content().string("genre:fantasy length:1h"));
    }

    @Test
    public void hashPath() throws Exception {
        TaskInfo task = new TaskInfo();
        this.mvc.perform(get("/test/house/stark/name/ned"))
                .andExpect(status().isOk())
                .andExpect(content().string("{house=stark, name=ned}"));
    }

    @Test
    public void objectPath() throws Exception {
        TaskInfo task = new TaskInfo();
        this.mvc.perform(get("/test/tasks/hola/comments/boom"))
                .andExpect(status().isOk())
                .andExpect(content().string("taskId is hola; commentId is boom"));
    }

    @Test
    public void getPi() throws Exception {
        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void mathCalculateAdd() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    public void mathCalculateMultiply() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("24"));
    }

    @Test
    public void mathCalculateSubtract() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }

    @Test
    public void mathCalculateDefault() throws Exception {
        this.mvc.perform(get("/math/calculate?x=30&y=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("35"));
    }

    @Test
    public void mathSum() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=4&n=5&n=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("15"));

    }


    @Test
    public void volumeOne() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/volume/3/4/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("60"));

    }

    @Test
    public void volumeTwo() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/volume/5/5/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("125"));


    }
}

