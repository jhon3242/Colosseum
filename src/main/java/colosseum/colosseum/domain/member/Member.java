package colosseum.colosseum.domain.member;

import colosseum.colosseum.web.signup.SignUpDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter @Setter @ToString @EqualsAndHashCode
public class Member {

	private Long id;
	private String username;
	private String email;
	private String password;
	private int age;
	private String birthday;
	private Gender gender;

	public Member() {
	}

	public Member(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Member(SignUpDto signUpDto) {
		this.username = signUpDto.getUsername();
		this.email = signUpDto.getEmail();
		this.password = signUpDto.getPassword();
		this.age = signUpDto.getAge();
		this.birthday = signUpDto.getBirthday();
		this.gender = signUpDto.getGender();
	}

	public boolean isMatchPassword(String password) {
		return Objects.equals(this.password, password);
	}
}
