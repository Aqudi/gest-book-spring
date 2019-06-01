package taejung.student.gestbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taejung.student.gestbook.Service.WebService;

@Controller
@AllArgsConstructor
public class WebController {

    private WebService webService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("article", webService.findAllData());
        return "main";
    }

}
