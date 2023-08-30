package colosseum.colosseum.domain.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest {
	MemberRepositoryImp memberRepository = new MemberRepositoryImp();

	@BeforeEach
	void saveUser() {
		Member member = new Member();
		member.setEmail("test@test.com");
		member.setUsername("test");
		member.setAge(20);
		member.setGender(Gender.Male);
		memberRepository.save(member);
	}

	@Test
	void findById() {
		Member member = memberRepository.findById(1L);
		assertThat(member.getUsername()).isEqualTo("test");
		assertThat(member.getAge()).isEqualTo(20);
		assertThat(member.getEmail()).isEqualTo("test@test.com");
	}

	@Test
	void findByEmail() {
		Member member = memberRepository.findByEmail("test@test.com").get();
		assertThat(member.getUsername()).isEqualTo("test");
		assertThat(member.getAge()).isEqualTo(20);
		assertThat(member.getEmail()).isEqualTo("test@test.com");
	}

	@Test
	void finaAll() {
		Member member = new Member();
		member.setEmail("test2@test.com");
		member.setUsername("test2");
		member.setAge(22);
		member.setGender(Gender.Female);
		memberRepository.save(member);
		assertThat(memberRepository.findAll().size()).isEqualTo(2);
	}
}