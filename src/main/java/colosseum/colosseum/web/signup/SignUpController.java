package colosseum.colosseum.web.signup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/sign-up")
@Slf4j
public class SignUpController {

	@GetMapping
	public String SignUpForm() {
		return "sign-up/form";
	}

	@PostMapping
	public String SignUp(@RequestParam Map<String, String> param) {
		try{
			validateParam(param);
		} catch (Exception error) {
			log.error("Error = {}", error);
			return "sign-up/form";
		}

		return "redirect:/";
	}

	private void validateParam(Map<String, String> param) {
		String username = param.get("username");
		String email = param.get("email");
		String password = param.get("password");
		String confirmPassword = param.get("confirm-password");

		if (username.length() < 3) {
			throw new IllegalArgumentException("유저 이름은 3자 이상이여야합니다.");
		}

	}


}
