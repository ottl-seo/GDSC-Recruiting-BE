package gdsc.ewha.recruiting.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gdsc.ewha.recruiting.domain.Info;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InfoDto {
    private int userId;
    private String name;
    private String tel;
    private String email;
    private String major;
    private String studentNum;
    private int isCore;
}
