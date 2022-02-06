package gdsc.ewha.recruiting.service;
import gdsc.ewha.recruiting.domain.Application;
import gdsc.ewha.recruiting.domain.Info;
import gdsc.ewha.recruiting.dto.ApplicationDto;
import gdsc.ewha.recruiting.dto.InfoDto;
import gdsc.ewha.recruiting.dto.InfoRequestDto;
import gdsc.ewha.recruiting.repository.ApplicationRepository;
import gdsc.ewha.recruiting.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final InfoRepository infoRepository;

    @Transactional
    public int createApplication(int userId, String firstInput, String secondInput, String thirdInput) throws Exception{
        Optional<Info> info = infoRepository.findById(userId);
        Application application = new Application(info.get(), firstInput, secondInput, thirdInput);
        applicationRepository.save(application);
        return application.getInfo().getUserId();
    }
    @Transactional
    public List<ApplicationDto> getAll(){
        List<Application> applicationList;
        applicationList = applicationRepository.findAll();
        List<ApplicationDto> applicationDtoList = new ArrayList<>();
        for(Application application: applicationList){
            ApplicationDto applicationDto = ApplicationDto.builder().application(application).build();
            applicationDtoList.add(applicationDto);
        }
        return applicationDtoList;
    }
}
