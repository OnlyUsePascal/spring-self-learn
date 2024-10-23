package example.c03_mvc.cc04_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "Joun");
        return "greeting";
    }
}
