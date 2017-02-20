package com.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by johnslota on 2/19/17.
 */
@RestController
public class PagesController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping("/tasks")
    public String createTask(){
        return "You're a poster";
    }

    @PatchMapping("/pathTask")
    public String patchTask(){
        return "Patch";
    }

    @DeleteMapping("/deleteTask")
    public String deleteTask(){
        return "delete";
    }
}
