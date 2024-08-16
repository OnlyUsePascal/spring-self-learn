package example.c03_mvc.c02_spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/")
public class Controller_ {

    @Autowired
    Model model;

    @RequestMapping(value = "/all")
    public List<Student> getStudents() {
        return model.getStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String changeStudent(@PathVariable("id") Integer id,
                                @RequestBody(required = false) String name) {
        try {
            model.changeStudent(id, name);
            return "update success";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
