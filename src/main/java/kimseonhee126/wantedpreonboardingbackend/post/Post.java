package kimseonhee126.wantedpreonboardingbackend.post;


import jakarta.persistence.*;
import kimseonhee126.wantedpreonboardingbackend.company.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "position")
    private String position;

    @Column(name = "money")
    private Integer money;

    @Column(name = "content")
    private String content;

    @Column(name = "skill")
    private String skill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    // 포지션 변경하기
    public void updatePosition(String position) {
        this.position = position;
    }

    // 보상금 변경하기
    public void updateMoney(Integer money) {
        this.money = money;
    }

    // 채용내용 변경하기
    public void updateContent(String content) {
        this.content = content;
    }

    // 사용기술 변경하기
    public void updateSkill(String skill) {
        this.skill = skill;
    }

    @Builder
    public Post(Company company, String position, Integer money, String content, String skill) {
        this.company = company;
        this.position = position;
        this.money = money;
        this.content = content;
        this.skill = skill;
    }
}
