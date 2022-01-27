package gdsc.ewha.recruiting.dto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gdsc.ewha.recruiting.domain.Application;
import gdsc.ewha.recruiting.domain.Apply;
import gdsc.ewha.recruiting.domain.Info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor
public class ApplyDto {
    private String firstInput;
    private String secondInput;
    private String thirdInput;
    @Builder
    public ApplyDto(Apply entity){
        this.firstInput = entity.getFirstInput();
        this.secondInput = entity.getSecondInput();
        this.thirdInput = entity.getThirdInput();
    }
}
