package gdsc.ewha.recruiting.dto;

import gdsc.ewha.recruiting.domain.Info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class InfoRequestDto {
    // 2-2. 채우기
    //private int userId; //자동생성이므로 지움
    private String name;
    private String tel;
    private String email;
    private String major;
    private String studentNum;
    private int isCore;

    @Builder
    public InfoRequestDto(Info entity){
        this.name = entity.getName();
        this.tel = entity.getTel();
        this.email = entity.getEmail();
        this.major = entity.getMajor();
        this.studentNum = entity.getStudentNum();
        this.isCore = entity.getIsCore();
    }
}
