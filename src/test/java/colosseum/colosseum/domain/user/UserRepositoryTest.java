package colosseum.colosseum.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
	UserRepository userRepository = new UserRepository();

	@BeforeEach
	void saveUser() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setUsername("test");
		user.setAge(20);
		user.setGender(Gender.Male);
		userRepository.save(user);
	}

	@Test
	void findById() {
		User user = userRepository.findById(1L);
		assertThat(user.getUsername()).isEqualTo("test");
		assertThat(user.getAge()).isEqualTo(20);
		assertThat(user.getEmail()).isEqualTo("test@test.com");
	}

	@Test
	void findByEmail() {
		User user = userRepository.findByEmail("test@test.com").get();
		assertThat(user.getUsername()).isEqualTo("test");
		assertThat(user.getAge()).isEqualTo(20);
		assertThat(user.getEmail()).isEqualTo("test@test.com");
	}

	@Test
	void finaAll() {
		User user = new User();
		user.setEmail("test2@test.com");
		user.setUsername("test2");
		user.setAge(22);
		user.setGender(Gender.Female);
		userRepository.save(user);
		assertThat(userRepository.finaAll().size()).isEqualTo(2);
	}
}