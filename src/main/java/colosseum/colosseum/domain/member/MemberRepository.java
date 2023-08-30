package colosseum.colosseum.domain.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
	Member save(Member member);

	Member findById(Long id);

	Optional<Member> findByEmail(String email);

	List<Member> findAll();

	void delete(Member member);
}
