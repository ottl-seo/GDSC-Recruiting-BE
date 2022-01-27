package gdsc.ewha.recruiting.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "info")
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String tel;
    @Column
    private String major;
    @Column
    private String studentNum;
    @Column
    private int isCore; // 0,1로 구분

    @Builder
    public Info(String name, String email, String tel, String major, String studentNum, int isCore){
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.major = major;
        this.studentNum = studentNum;
        this.isCore = isCore;
    }
    /* 참고.
    //Application.java에서는 이렇게
        @ManyToOne
        @JoinColumn(name="Info")
        private Info info;
     */
}
