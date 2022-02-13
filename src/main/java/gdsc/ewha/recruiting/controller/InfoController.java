package gdsc.ewha.recruiting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gdsc.ewha.recruiting.dto.InfoDto;
import gdsc.ewha.recruiting.dto.InfoRequestDto;
import gdsc.ewha.recruiting.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class InfoController {
    @Autowired
    InfoService infoService;

    public InfoController(InfoService infoService){
        this.infoService = infoService;
    }

    @PostMapping("/api/info")
    public int postInfo(@RequestBody InfoRequestDto infoRequestDto) throws Exception {
        //InfoRequestDto requestDto = new ObjectMapper().readValue(requestDtoString, InfoRequestDto.class);
        int userId = infoService.createUser(infoRequestDto); //서비스
        return userId;
    }
    @GetMapping("/api/info/list")
    public List<InfoDto> getInfoList() {
        return infoService.getAll();
    }
}
