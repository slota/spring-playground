package com.example;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Map;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RestController
public class PagesController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @PostMapping("/tasks")
    public String createTask() {
        return "You're a poster";
    }

    @PatchMapping("/patchTask")
    public String patchTask() {
        return "Patch";
    }

    @DeleteMapping("/deleteTask")
    public String deleteTask() {
        return "delete";
    }

    @GetMapping("/vehicles")
    public String vehicles(@RequestParam String year, @RequestParam String doors) {
        return String.format("year is: %s, and number is: %s", year, doors);
    }

    @GetMapping("/hash")
    public String vehicles(@RequestParam Map queryString) {
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

    @GetMapping("/math/pi")
    public String getPi() {
        return String.format("3.141592653589793");
    }

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam(value = "operation", defaultValue = "add") String operation, @RequestParam String x, @RequestParam String y) {
        System.out.println(operation);
        if (operation.equals("subtract")) return Integer.toString((Integer.parseInt(x) - Integer.parseInt(y)));
        if (operation.equals("multiply")) return Integer.toString((Integer.parseInt(x) * Integer.parseInt(y)));
        return Integer.toString((Integer.parseInt(x) + Integer.parseInt(y)));

    }

    @PostMapping("/math/sum")
    public String sum(@RequestParam MultiValueMap<String, String> numbers) {
        Iterator values = numbers.get("n").iterator();

        int total = 0;

        for (int i = 0; i < numbers.get("n").size(); i++) {
            total += Integer.parseInt(values.next().toString());
        }


        return Integer.toString(total);
    }

    @PostMapping("/math/volume/{x}/{y}/{z}")
    public String sum(@PathVariable String x, @PathVariable String y, @PathVariable String z) {


        return Integer.toString((Integer.parseInt(x) * Integer.parseInt(y) * Integer.parseInt(z)));
    }

}
