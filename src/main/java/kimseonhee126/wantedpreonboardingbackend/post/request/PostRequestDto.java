package kimseonhee126.wantedpreonboardingbackend.post.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostRequestDto {
    private Long companyId;
    private String position;
    private Integer money;
    private String content;
    private String skill;
}
