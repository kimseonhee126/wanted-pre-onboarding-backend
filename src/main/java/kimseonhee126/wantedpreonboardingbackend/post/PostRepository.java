package kimseonhee126.wantedpreonboardingbackend.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByPosition(String position);
    List<Post> findByMoney(Integer money);
    List<Post> findBySkill(String skill);
}
