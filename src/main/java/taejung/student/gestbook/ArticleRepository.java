package taejung.student.gestbook;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a " +
            "FROM Article a " +
            "ORDER BY a.id DESC")
        // 내림차순정렬
    Stream<Article> findAllData();
}
