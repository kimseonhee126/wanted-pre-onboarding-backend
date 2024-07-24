package kimseonhee126.wantedpreonboardingbackend.post;

import kimseonhee126.wantedpreonboardingbackend.post.request.PostRequestDto;
import kimseonhee126.wantedpreonboardingbackend.post.request.UpdateRequestDto;
import kimseonhee126.wantedpreonboardingbackend.post.response.OnePostDto;
import kimseonhee126.wantedpreonboardingbackend.post.response.PostListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    // 전체 채용 공고 확인하기
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/posts")
    public List<PostListDto> getAllPosts() {
        return postService.getAllPosts();
    }

    // 특정 채용 공고 확인하기
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/post/{postId}")
    public OnePostDto getOnePost(@PathVariable(name = "postId") Long postId) {
        return postService.getOnePost(postId);
    }

    // TODO: 채용 공고 검색하기 기능
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/post")
    public List<PostListDto> searchByKeyword(@RequestParam("search") String keyword) {
        return postService.searchByKeyword(keyword);
    }

    // TODO: 사용자는 채용공고에 지원하기

    // 채용 공고 등록하기
    @PostMapping("/post")
    public ResponseEntity<String> makePost(@RequestBody PostRequestDto postRequestDto) {
        postService.makePost(postRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("채용공고가 정상적으로 등록되었습니다");
    }

    // 채용 공고 수정하기
    @PutMapping("/post")
    public ResponseEntity<String> updatePost(@RequestBody UpdateRequestDto updateRequestDto) {
        postService.updatePost(updateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body("채용공고가 정상적으로 수정되었습니다");
    }

    // 채용 공고 삭제하기
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "postId") Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("채용공고가 정상적으로 삭제되었습니다");
    }
}
