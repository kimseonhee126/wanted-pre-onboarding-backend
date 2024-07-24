package kimseonhee126.wantedpreonboardingbackend.post.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateRequestDto {
    private Long postId;
    private String position;
    private Integer money;
    private String content;
    private String skill;
}
