package example.c03_mvc.cc03_xml_pojo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {
    @GetMapping(value = "/")
    public String home(Model model) {
        System.out.println("home!!");
        model.addAttribute("user", "Joun");
        return "index";
    }
}
