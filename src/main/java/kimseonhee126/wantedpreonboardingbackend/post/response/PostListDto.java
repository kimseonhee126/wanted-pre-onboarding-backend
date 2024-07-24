package kimseonhee126.wantedpreonboardingbackend.post.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostListDto {
    private Long postId;
    private String companyName;
    private String companyCountry;
    private String companyRegion;
    private String position;
    private Integer money;
    private String skill;
}
