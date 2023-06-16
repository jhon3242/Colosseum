package colosseum.colosseum.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
	private static final Map<Long, User> repository = new HashMap<>();
	private static Long sequence = 0L;

	public User save(User user) {
		user.setId(sequence++);
		repository.put(user.getId(), user);
		return user;
	}

	public User findById(Long id) {
		return repository.get(id);
	}

	public List<User> finaAll() {
		return new ArrayList<>(repository.values());
	}
}
