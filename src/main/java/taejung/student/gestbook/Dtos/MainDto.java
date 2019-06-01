package taejung.student.gestbook.Dtos;

import lombok.Getter;
import taejung.student.gestbook.Article;

@Getter
public class MainDto {

    private Long id;
    private String title;
    private String content;

    public MainDto(Article a){
        id = a.getId();
        title = a.getTitle();
        content = a.getContent();
    }
}
