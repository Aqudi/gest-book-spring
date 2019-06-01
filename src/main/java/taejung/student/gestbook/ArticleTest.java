package taejung.student.gestbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {

    @Autowired
    ArticleRepository articleRepository;

//    public void cleanup() {
//        articleRepository.deleteAll();
//    }

    @Test
    public void saveAndRead() {
        // 데이터 생성
        articleRepository.save(Article.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .build());

        // 데이터 리스트 구성
        List<Article> articleList = articleRepository.findAll();

        Article posts = articleList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }
}