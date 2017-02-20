package com.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PatchMapping("/patchTask")
    public String patchTask(){
        return "Patch";
    }

    @DeleteMapping("/deleteTask")
    public String deleteTask(){
        return "delete";
    }

    @GetMapping("/vehicles")
    public String vehicles(@RequestParam String year, @RequestParam String doors){
        return String.format("year is: %s, and number is: %s", year, doors);
    }

    @GetMapping("/hash")
    public String vehicles(@RequestParam Map queryString){
        return queryString.toString();
    }

    @GetMapping("/tasks")
    public String getTasks(TaskInfo taskInfo) {
        return String.format("sort-by is %s; owner is %s", taskInfo.getSortBy(), taskInfo.getOwner());
    }

    @GetMapping("/tv-shows/genre/{g}/length/{h}") // matches /individual-example/foo/bar
    public String getIndividualParams(@PathVariable String g, @PathVariable("h") String h) {
        return String.format("genre:%s length:%s", g, h);
    }

    @GetMapping("/test/house/{house}/name/{name}")
    public String getCommentsForTask(@PathVariable Map pathVariables) {
        return pathVariables.toString(); // {taskId=46, commentId=35}
    }

    @GetMapping("/test/tasks/{taskId}/comments/{commentId}")
    public String getCommentsForTask(TaskId ids) {
        return String.format("taskId is %s; commentId is %s", ids.getTaskId(), ids.getCommentId());
    }
}
