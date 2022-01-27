package gdsc.ewha.recruiting.service;

import gdsc.ewha.recruiting.domain.Apply;
import gdsc.ewha.recruiting.dto.ApplyDto;
import gdsc.ewha.recruiting.repository.ApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ApplyService {
    private final ApplyRepository applyRepository;

    @Transactional
    public int createApply(ApplyDto applyDto) throws Exception{
        Apply apply = new Apply(
                applyDto.getFirstInput(),
                applyDto.getSecondInput(),
                applyDto.getThirdInput()
        );
        applyRepository.save(apply);
        return apply.getUserId();
    }
}