package taejung.student.gestbook.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import taejung.student.gestbook.ArticleRepository;
import taejung.student.gestbook.Dtos.Dto;
import taejung.student.gestbook.Dtos.MainDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class WebService {
    private ArticleRepository articleRepository;

    @Transactional // DB 작업이 성공적으로 마쳤을 시에만 저장
    public Long save(Dto dto) {
        return articleRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<MainDto> findAllData() {
        return articleRepository.findAllData()
                .map(MainDto::new)
                .collect(Collectors.toList());
    }
}
