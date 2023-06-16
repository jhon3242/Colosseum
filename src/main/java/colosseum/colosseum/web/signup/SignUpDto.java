package colosseum.colosseum.web.signup;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignUpDto {

	@NotBlank
	private String username;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String confirmPassword;
	private int age;
	private String birthday;
	private String gender;

}
