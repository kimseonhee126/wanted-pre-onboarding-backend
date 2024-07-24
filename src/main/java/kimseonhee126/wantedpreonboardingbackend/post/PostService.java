package kimseonhee126.wantedpreonboardingbackend.post;

import kimseonhee126.wantedpreonboardingbackend.company.Company;
import kimseonhee126.wantedpreonboardingbackend.company.CompanyRepository;
import kimseonhee126.wantedpreonboardingbackend.post.request.PostRequestDto;
import kimseonhee126.wantedpreonboardingbackend.post.request.UpdateRequestDto;
import kimseonhee126.wantedpreonboardingbackend.post.response.OnePostDto;
import kimseonhee126.wantedpreonboardingbackend.post.response.PostListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CompanyRepository companyRepository;

    // 회사 찾기
    private Company findCompany(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid company ID"));
    }

    // 채용 공고 찾기
    private Post findPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID"));
    }

    // 채용 공고 내용 찾기
    private PostListDto getPostDetail(Post post) {
        return new PostListDto(
                post.getPostId(),
                post.getCompany().getCompanyName(),
                post.getCompany().getCompanyCountry(),
                post.getCompany().getCompanyRegion(),
                post.getPosition(),
                post.getMoney(),
                post.getSkill());
    }

    // 전체 채용공고 확인하기
    public List<PostListDto> getAllPosts() {
        List<Post> postList = postRepository.findAll();

        return postList.stream()
                .map(this::getPostDetail)
                .toList();
    }

    // 특정 채용공고 확인하기
    public OnePostDto getOnePost(Long postId) {
        Post post = findPost(postId);

        PostListDto postDetail = getPostDetail(post);

        String content = post.getContent();

        List<Long> postIdList = post.getCompany().getPosts().stream()
                .map(Post::getPostId)
                .filter(id -> !id.equals(postId))
                .toList();

        return new OnePostDto(
                postDetail,
                content,
                postIdList
        );
    }

    // 특정 키워드로 채용공고 확인하기
    public List<PostListDto> searchByKeyword(String keyword) {
        HashSet<Long> postIdSet = new HashSet<>();

        List<Company> companiesByName = companyRepository.findByCompanyName(keyword);
        List<Company> companiesByCountry = companyRepository.findByCompanyCountry(keyword);
        List<Company> companiesByRegion = companyRepository.findByCompanyRegion(keyword);

        companiesByName.forEach(company ->
                company.getPosts().forEach(post -> postIdSet.add(post.getPostId())));
        companiesByCountry.forEach(company ->
                company.getPosts().forEach(post -> postIdSet.add(post.getPostId())));
        companiesByRegion.forEach(company ->
                company.getPosts().forEach(post -> postIdSet.add(post.getPostId())));

        List<Post> postIdByPosition = postRepository.findByPosition(keyword);
//        List<Post> postIdByMoney = postRepository.findByMoney(Integer.parseInt(keyword));
        List<Post> postIdBySkill = postRepository.findBySkill(keyword);

        postIdByPosition.forEach(post -> postIdSet.add(post.getPostId()));
//        postIdByMoney.forEach(post -> postIdSet.add(post.getPostId()));
        postIdBySkill.forEach(post -> postIdSet.add(post.getPostId()));

        return postRepository.findAllById(postIdSet).stream()
                .map(post -> new PostListDto(
                        post.getPostId(),
                        post.getCompany().getCompanyName(),
                        post.getCompany().getCompanyCountry(),
                        post.getCompany().getCompanyRegion(),
                        post.getPosition(),
                        post.getMoney(),
                        post.getSkill()
                )).toList();
    }

    // 채용공고 등록하기
    @Transactional
    public void makePost(PostRequestDto postRequestDto) {
        Company saveCompany = findCompany(postRequestDto.getCompanyId());

        Post post = Post.builder()
                .company(saveCompany)
                .position(postRequestDto.getPosition())
                .money(postRequestDto.getMoney())
                .content(postRequestDto.getContent())
                .skill(postRequestDto.getSkill())
                .build();

        postRepository.save(post);
    }

    // 채용 공고 수정하기
    @Transactional
    public void updatePost(UpdateRequestDto updateRequestDto) {
        Post post = findPost(updateRequestDto.getPostId());

        post.updatePosition(updateRequestDto.getPosition());
        post.updateMoney(updateRequestDto.getMoney());
        post.updateContent(updateRequestDto.getContent());
        post.updateSkill(updateRequestDto.getSkill());
    }

    // 채용 공고 삭제하기
    @Transactional
    public void deletePost(Long postId) {
        Post post = findPost(postId);

        postRepository.delete(post);
    }
}
