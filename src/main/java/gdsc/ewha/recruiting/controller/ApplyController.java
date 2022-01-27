package gdsc.ewha.recruiting.controller;

import gdsc.ewha.recruiting.dto.ApplyDto;
import gdsc.ewha.recruiting.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ApplyController {
    @Autowired
    ApplyService applyService;

    public ApplyController(ApplyService applyService){
        this.applyService = applyService;
    }

    @PostMapping("/api/apply")
    public int postApply(@RequestBody ApplyDto applyDto) throws Exception {
        int userId = applyService.createApply(applyDto);
        return userId;
    }
}