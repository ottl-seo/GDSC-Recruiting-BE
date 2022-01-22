package gdsc.ewha.recruiting.service;

import gdsc.ewha.recruiting.domain.Info;
import gdsc.ewha.recruiting.dto.InfoRequestDto;
import gdsc.ewha.recruiting.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class InfoService {
    // 3 . createUser 메서드 만들기
    private final InfoRepository infoRepository;

    @Transactional
    public int createUser(InfoRequestDto requestDto) throws Exception{
        Info info = new Info(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getTel(),
                requestDto.getMajor(),
                requestDto.getStudentNum(),
                requestDto.getIsCore()
        );
        infoRepository.save(info);
        return info.getUserId();
    }
}
