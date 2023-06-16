package colosseum.colosseum.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter @ToString
public class User {

	@NotNull
	private Long id;
	@NotBlank
	private String username;
	@NotBlank
	private String email;
	@NotBlank
	private String password;

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
