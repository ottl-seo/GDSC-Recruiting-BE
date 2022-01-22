package gdsc.ewha.recruiting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gdsc.ewha.recruiting.dto.InfoRequestDto;
import gdsc.ewha.recruiting.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class InfoController {
    @Autowired
    InfoService infoService;

    public InfoController(InfoService infoService){
        this.infoService = infoService;
    }

    @PostMapping("/api/info")
    public int postNewInfo(@RequestParam(value = "requestDto") String requestDtoString) throws Exception {
        InfoRequestDto requestDto = new ObjectMapper().readValue(requestDtoString, InfoRequestDto.class);
        int userId = infoService.createUser(requestDto); //서비스
        return userId;
    }
}
