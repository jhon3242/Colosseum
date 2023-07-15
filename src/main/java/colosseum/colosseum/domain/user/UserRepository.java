package colosseum.colosseum.domain.user;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
	private static final Map<Long, User> repository = new ConcurrentHashMap<>();
	private static Long sequence = 0L;

	public User save(User user) {
		user.setId(++sequence);
		repository.put(user.getId(), user);
		return user;
	}

	public User findById(Long id) {
		return repository.get(id);
	}

	public Optional<User> findByEmail(String email) {
		 return finaAll().stream()
				.filter(user -> Objects.equals(user.getEmail(), email))
				.findFirst();
	}

	public List<User> finaAll() {
		return new ArrayList<>(repository.values());
	}
}
