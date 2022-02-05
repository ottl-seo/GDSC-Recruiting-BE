package gdsc.ewha.recruiting.controller;

import gdsc.ewha.recruiting.dto.ApplicationDto;
import gdsc.ewha.recruiting.dto.CoreApplicationDto;
import gdsc.ewha.recruiting.service.ApplicationService;
import gdsc.ewha.recruiting.service.CoreApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class CoreApplicationController {
    @CrossOrigin("*")
    @RestController
    public class ApplicationController {
        @Autowired
        CoreApplicationService coreApplicationService;

        public ApplicationController(CoreApplicationService coreApplicationService){
            this.coreApplicationService = coreApplicationService;
        }
        @PostMapping("/api/application/core")
        public int postCoreApplication(@RequestBody CoreApplicationDto applicationDto) throws Exception {
            int userId = coreApplicationService.createCoreApplication(
                    applicationDto.getInfo().getUserId(),
                    applicationDto.getFirstInput(),
                    applicationDto.getSecondInput(),
                    applicationDto.getThirdInput(),
                    applicationDto.getFourthInput(),
                    applicationDto.getFifthInput());
            return userId;
        }
    }
}
