package gdsc.ewha.recruiting.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "core_application")
public class CoreApplication { // 외래키 가지는 쪽 (연관관계 주인)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applyId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Info info;

    @Column
    private String firstInput;
    @Column
    private String secondInput;
    @Column
    private String thirdInput;
    @Column
    private String fourthInput;
    @Column
    private String fifthInput;

    @Builder
    public CoreApplication(Info info, String firstInput, String secondInput, String thirdInput, String fourthInput, String fifthInput){
        this.info = info;
        this.firstInput = firstInput;
        this.secondInput = secondInput;
        this.thirdInput = thirdInput;
        this.fourthInput = fourthInput;
        this.fifthInput = fifthInput;
    }
}
