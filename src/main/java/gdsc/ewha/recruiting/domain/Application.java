package gdsc.ewha.recruiting.domain;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "application")
public class Application { // 외래키 가지는 쪽 (연관관계 주인)
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

    @Builder
    public Application(Info info, String firstInput, String secondInput, String thirdInput){
        this.info = info;
        this.firstInput = firstInput;
        this.secondInput = secondInput;
        this.thirdInput = thirdInput;
}
}
