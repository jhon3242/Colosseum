package colosseum.colosseum.domain.member;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	@TestConfiguration
	static class TestConfig {

		private final DataSource dataSource;

		public TestConfig(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		@Bean
		MemberRepository memberRepository() {
			return new MemberRepositoryH2(dataSource);
		}
	}

	@BeforeEach
	void saveUser() {
		Member member = new Member();
		member.setEmail("test@test.com");
		member.setUsername("test");
		member.setAge(20);
		member.setGender(Gender.Male);
		memberRepository.save(member);
	}

	@AfterEach
	void deleteMember() {
		Member findMember = memberRepository.findById(1L);
		memberRepository.delete(findMember);
	}

	@Test
	void findById() {
		Member member = memberRepository.findById(1L);
		assertThat(member.getUsername()).isEqualTo("test");
//		assertThat(member.getAge()).isEqualTo(20);
//		assertThat(member.getEmail()).isEqualTo("test@test.com");
	}

//	@Test
//	void findByEmail() {
//		Member member = memberRepository.findByEmail("test@test.com").get();
//		assertThat(member.getUsername()).isEqualTo("test");
//		assertThat(member.getAge()).isEqualTo(20);
//		assertThat(member.getEmail()).isEqualTo("test@test.com");
//	}
//
//	@Test
//	void finaAll() {
//		Member member = new Member();
//		member.setEmail("test2@test.com");
//		member.setUsername("test2");
//		member.setAge(22);
//		member.setGender(Gender.Female);
//		memberRepository.save(member);
//		assertThat(memberRepository.findAll().size()).isEqualTo(2);
//	}

//	@Test
//	void delete() {
//		Member findMember = memberRepository.findById(1L);
//		memberRepository.delete(findMember);
//		memberRepository.findAll();
//	}

}