package kimseonhee126.wantedpreonboardingbackend.company;

import jakarta.persistence.*;
import kimseonhee126.wantedpreonboardingbackend.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(nullable = false, length = 20)
    private String companyName;

    @Column(nullable = false, length = 10)
    private String companyCountry;

    @Column(nullable = false, length = 10)
    private String companyRegion;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();
}
