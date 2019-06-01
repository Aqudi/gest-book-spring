package taejung.student.gestbook;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor // 의존성주입 lombok
public class WebController {

    private ArticleRepository articleRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring";
    }

    @PostMapping("/create")
    public void saveArticle(@RequestBody Dto  dto){
        articleRepository.save(dto.toEntity());
    }
}
