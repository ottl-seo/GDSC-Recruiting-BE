package gdsc.ewha.recruiting.service;

import gdsc.ewha.recruiting.domain.Application;
import gdsc.ewha.recruiting.domain.CoreApplication;
import gdsc.ewha.recruiting.domain.Info;
import gdsc.ewha.recruiting.repository.ApplicationRepository;
import gdsc.ewha.recruiting.repository.CoreApplicationRepository;
import gdsc.ewha.recruiting.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@RequiredArgsConstructor
@Service
@Transactional
public class CoreApplicationService {
    private final CoreApplicationRepository applicationRepository;
    private final InfoRepository infoRepository;

    @Transactional
    public int createCoreApplication(int userId, String firstInput, String secondInput, String thirdInput, String fourthInput, String fifthInput) throws Exception{
        Optional<Info> info = infoRepository.findById(userId);
        CoreApplication application = new CoreApplication(info.get(), firstInput, secondInput, thirdInput, fourthInput, fifthInput);
        applicationRepository.save(application);
        return application.getInfo().getUserId();
    }
}