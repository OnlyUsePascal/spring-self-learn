package example.c05_secure.cc01_basic.controllers;

import example.c05_secure.cc01_basic.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping("")
    public Student myProfile () {
        return new Student(123, "Joun");
    }

    @GetMapping("/all")
    public List<Student> allProfiles() {
        return Arrays.asList(new Student(234, "jeff"),
                new Student(333, "jay"));
    }
}
