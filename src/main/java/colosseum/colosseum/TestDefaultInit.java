package colosseum.colosseum;

import colosseum.colosseum.domain.post.Post;
import colosseum.colosseum.domain.post.PostRepository;
import colosseum.colosseum.domain.user.User;
import colosseum.colosseum.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TestDefaultInit {

	private final UserRepository userRepository;
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
		User test = new User("test", "test@test.com", "test!");
		userRepository.save(test);
	}

}
