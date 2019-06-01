package taejung.student.gestbook;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // 데이터 베이스에 저장될 클래스임을 명시함
@Builder // lombok의 기능 Builder 모델의 패턴 적용을 쉽게 해준다.
@Getter // lombok의 기능 Getter를 추가해준다.
public class Article {

    @Id // 글 들을 구분할 구분자라고 생각하면됨
    @GeneratedValue // 자동생성
    private Long id;

    @Column(length=20, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Override
    public String toString(){
        return "제목 : " + title + "\n내용 : " + content;
    }
}