package colosseum.colosseum.domain.signin;

import colosseum.colosseum.domain.member.Member;
import colosseum.colosseum.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SignInService {
	private final MemberRepository userRepository;


	/**
	 * @return 이 null 이면 로그인 실패
	 */
	public Member signIn(String email, String password) {
		return userRepository.findByEmail(email)
				.filter(user -> user.isMatchPassword(password))
				.orElse(null);
	}
}
