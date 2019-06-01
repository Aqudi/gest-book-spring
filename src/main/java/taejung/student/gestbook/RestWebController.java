package taejung.student.gestbook;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor // 의존성주입 lombok
public class RestWebController {

    private ArticleRepository articleRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring";
    }

    @PostMapping("/create")
    public void saveArticle(@RequestBody Dto  dto){
        articleRepository.save(dto.toEntity());
    }

//    @PostMapping("/delete")
//    public void deleteArticle(@RequestBody long id){
//        articleRepository.deleteById(id);
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public void updateArticle(long id, Dto  dto){
//        Article article = articleRepository.getOne(id);
//        System.out.println(article);
//        article.setTitle(dto.getTitle());
//        article.setContent(dto.getContent());
//        articleRepository.save(article);
//    }
}
