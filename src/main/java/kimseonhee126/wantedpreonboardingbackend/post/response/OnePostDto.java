package kimseonhee126.wantedpreonboardingbackend.post.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class OnePostDto {
    private PostListDto postDto;
    private String content;
    private List<Long> postList;
}
