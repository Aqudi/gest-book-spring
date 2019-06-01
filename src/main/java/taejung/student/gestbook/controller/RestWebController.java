package taejung.student.gestbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taejung.student.gestbook.Article;
import taejung.student.gestbook.ArticleRepository;
import taejung.student.gestbook.Dtos.Dto;
import taejung.student.gestbook.Service.WebService;

@RestController
@AllArgsConstructor // 의존성주입 lombok
public class RestWebController {

    private WebService webService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring";
    }

    @PostMapping("/create")
    public Long saveArticle(@RequestBody Dto dto) {
        return webService.save(dto);
    }

    @PostMapping("/delete/{id}")
    public Long deleteArticle(@PathVariable Long id){
        return webService.delete(id);
    }

    @PostMapping("/update/{id}")
    public Long updateArticle(@PathVariable Long id, @RequestBody Dto dto){
        return webService.update(id, dto);
    }

    @GetMapping("/get/{id}")
    public Article getArticle(@PathVariable Long id){
        return webService.get(id);
    }
}
