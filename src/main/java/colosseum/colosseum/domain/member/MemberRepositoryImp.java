package colosseum.colosseum.domain.member;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepositoryImp implements MemberRepository {
	private static final Map<Long, Member> repository = new ConcurrentHashMap<>();
	private static Long sequence = 0L;

	public Member save(Member user) {
		user.setId(++sequence);
		repository.put(user.getId(), user);
		return user;
	}

	public Member findById(Long id) {
		return repository.get(id);
	}

	public Optional<Member> findByEmail(String email) {
		 return findAll().stream()
				.filter(user -> Objects.equals(user.getEmail(), email))
				.findFirst();
	}

	public List<Member> findAll() {
		return new ArrayList<>(repository.values());
	}
}
