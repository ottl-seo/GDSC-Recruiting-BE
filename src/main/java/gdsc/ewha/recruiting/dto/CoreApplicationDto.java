package gdsc.ewha.recruiting.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gdsc.ewha.recruiting.domain.Application;
import gdsc.ewha.recruiting.domain.CoreApplication;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor
public class CoreApplicationDto {
    private InfoDto info;
    private String firstInput;
    private String secondInput;
    private String thirdInput;
    private String fourthInput;
    private String fifthInput;

    @Builder
    public CoreApplicationDto(CoreApplication application){
        this.firstInput = application.getFirstInput();
        this.secondInput = application.getSecondInput();
        this.thirdInput = application.getThirdInput();
        this.fourthInput = application.getFourthInput();
        this.fifthInput = application.getFifthInput();
        this.info = InfoDto.builder()
                .name(application.getInfo().getName())
                .email(application.getInfo().getEmail())
                .studentNum(application.getInfo().getStudentNum())
                .major(application.getInfo().getMajor())
                .tel(application.getInfo().getTel())
                .isCore(application.getInfo().getIsCore())
                .build();
    }
}