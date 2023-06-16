package colosseum.colosseum.web.signup;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class SignUpDto {

	@NotBlank
	private String username;

	@Email
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private String confirmPassword;

	@Max(100)
	@Min(0)
	private int age;
	private String birthday;
	private String gender;

}
