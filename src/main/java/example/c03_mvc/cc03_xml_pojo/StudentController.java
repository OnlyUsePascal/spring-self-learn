package example.c03_mvc.cc03_xml_pojo;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/student",  produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    @GetMapping(value = "/{sid}")
    public Student findOne(@PathVariable("sid") int sid) {
        return new Student(sid, "Joun");
    }

    //http://localhost:8080/testMvc2/student/all?name=joun
    @GetMapping(value = "/all")
    public List<Student> findAll(@RequestParam(value = "name", required = false) String name) {
        System.out.printf("finding students with name: " + name);

        List<Student> students = new ArrayList<>();
        students.add(new Student(13, "dat pham"));
        students.add(new Student(14, "joun"));
        return students;
    }
}
