package gdsc.ewha.recruiting.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gdsc.ewha.recruiting.domain.Info;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InfoDto {
    // 2. 채우기
    //private int userId;
    private String name;
    private String tel;
    private String email;
    private String major;
    private String studentNum;
    private int isCore;

    @Builder
    public InfoDto(Info info){
        //this.userId = info.getUserId();
        this.name = info.getName();
        this.tel = info.getTel();
        this.email = info.getEmail();
        this.major = info.getMajor();
        this.studentNum = info.getStudentNum();
        this.isCore = info.getIsCore();
    }
}
