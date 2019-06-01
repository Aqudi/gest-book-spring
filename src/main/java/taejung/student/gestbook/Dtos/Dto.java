package taejung.student.gestbook.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import taejung.student.gestbook.Article;

@Getter
@Setter
@NoArgsConstructor
public class Dto {

    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
