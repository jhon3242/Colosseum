package colosseum.colosseum.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

	@BeforeEach
	void saveUser() {
		UserRepository userRepository = new UserRepository();
		User user = new User();
		user.setUsername("test");
		user.setAge(20);
		user.setGender(Gender.Male);
		userRepository.save(user);
	}

	@Test
	void findById() {
	}

	@Test
	void findByEmail() {
	}

	@Test
	void finaAll() {
	}
}