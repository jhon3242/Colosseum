package colosseum.colosseum.domain;

import colosseum.colosseum.web.signup.SignUpDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter @ToString
public class User {

	private Long id;
	private String username;
	private String email;
	private String password;
	private int age;
	private String birthday;
	private String gender;

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(SignUpDto signUpDto) {
		this.username = signUpDto.getUsername();
		this.email = signUpDto.getEmail();
		this.password = signUpDto.getPassword();
		this.age = signUpDto.getAge();
		this.birthday = signUpDto.getBirthday();
		this.gender = signUpDto.getGender();
	}
}
