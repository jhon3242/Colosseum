package colosseum.colosseum;

import colosseum.colosseum.domain.User;
import colosseum.colosseum.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDefaultInit {

	private final UserRepository userRepository;

	/**
	 * 테스트용 유저 추가
	 */
	@PostConstruct
	public void init() {
		User test = new User("test", "test@test.com", "test!");
		userRepository.save(test);
	}

}
