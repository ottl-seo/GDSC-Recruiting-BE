package gdsc.ewha.recruiting.controller;

import gdsc.ewha.recruiting.dto.ApplicationDto;
import gdsc.ewha.recruiting.dto.InfoRequestDto;
import gdsc.ewha.recruiting.service.ApplicationService;
import gdsc.ewha.recruiting.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }
    @PostMapping("/api/application/general")
    public int postApplication(@RequestBody ApplicationDto applicationDto) throws Exception {
        int userId = applicationService.createApplication(applicationDto.getInfo().getUserId(), applicationDto.getFirstInput(), applicationDto.getSecondInput(), applicationDto.getThirdInput());
        return userId;
    }
}
