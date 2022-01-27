package gdsc.ewha.recruiting.domain;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "apply")
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    private String firstInput;
    @Column
    private String secondInput;
    @Column
    private String thirdInput;

    @Builder
    public Apply(String firstInput, String secondInput, String thirdInput){
        this.firstInput = firstInput;
        this.secondInput = secondInput;
        this.thirdInput = thirdInput;
    }
}
