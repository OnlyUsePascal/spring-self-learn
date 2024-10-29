package example.c05_secure.cc02_data.controllers;

import example.c05_secure.cc02_data.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping("")
    public Student myProfile () {
        return new Student(123, "Joun");
    }

    // if error 403, it was becasue CSRF-attack prevention
    // either add _csrf to request body, or disable csrf feature
    @PostMapping("")
    public Student changeMyProfile(@RequestParam("id") int id,
                                   @RequestParam("name") String name) {
        return new Student(id, name);
    }

    @GetMapping("/all")
    public List<Student> allProfiles() {
        return Arrays.asList(new Student(234, "jeff"),
                new Student(333, "jay"));
    }

}
