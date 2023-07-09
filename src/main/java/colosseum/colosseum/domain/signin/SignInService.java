package colosseum.colosseum.domain.signin;

import colosseum.colosseum.domain.user.User;
import colosseum.colosseum.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SignInService {
	private final UserRepository userRepository;


	/**
	 * @return 이 null 이면 로그인 실패
	 */
	public User signIn(String email, String password) {
		return userRepository.findByEmail(email)
				.filter(user -> user.isMatchPassword(password))
				.orElse(null);
	}
}
