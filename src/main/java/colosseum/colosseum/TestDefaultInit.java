package colosseum.colosseum;

import colosseum.colosseum.domain.post.Post;
import colosseum.colosseum.domain.post.PostRepository;
import colosseum.colosseum.domain.member.Member;
import colosseum.colosseum.domain.member.MemberRepositoryH2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TestDefaultInit {

	private final MemberRepositoryH2 userRepository;
	private final PostRepository postRepository;

	/**
	 * 테스트용 유저 추가
	 */
	@PostConstruct
	public void init() {
		initUser();
		initPost();
	}

	private void initPost() {
		Post post = new Post();
		post.setAuthor("test");
		post.setTitle("test title");
		post.setContent("this is test content");
		post.setCreatedDate(LocalDateTime.now());
		post.setModifiedDate(LocalDateTime.now());
		postRepository.save(post);
	}

	private void initUser() {
		Member test = new Member("test", "test@test.com", "test!");
		userRepository.save(test);
	}
}
