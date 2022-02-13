package gdsc.ewha.recruiting.service;

import gdsc.ewha.recruiting.domain.Info;
import gdsc.ewha.recruiting.dto.InfoDto;
import gdsc.ewha.recruiting.dto.InfoRequestDto;
import gdsc.ewha.recruiting.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    @Transactional
    public List<InfoDto> getAll(){
        List<Info> infoList;
        infoList = infoRepository.findAll();
        List<InfoDto> infoDtoList = new ArrayList<>();
        for(Info info: infoList){
            InfoDto infoDto = InfoDto.builder()
                    .userId(info.getUserId())
                    .name(info.getName())
                    .tel(info.getTel())
                    .email(info.getEmail())
                    .major(info.getMajor())
                    .studentNum(info.getStudentNum())
                    .isCore(info.getIsCore())
                    .build();
            infoDtoList.add(infoDto);
        }
        return infoDtoList;
    }
}
