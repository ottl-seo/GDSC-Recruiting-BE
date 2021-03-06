package gdsc.ewha.recruiting.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gdsc.ewha.recruiting.domain.Application;
import gdsc.ewha.recruiting.domain.Info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor
public class ApplicationDto {
    private InfoDto info;
    private String firstInput;
    private String secondInput;
    private String thirdInput;
    private String fourthInput;
    private String stacks;
    private String paths;
    private String portfolio;

    @Builder
    public ApplicationDto(Application application){
        this.firstInput = application.getFirstInput();
        this.secondInput = application.getSecondInput();
        this.thirdInput = application.getThirdInput();
        this.fourthInput = application.getFourthInput();
        this.stacks = application.getStacks();
        this.paths = application.getPaths();
        this.portfolio = application.getPortfolio();
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