package colosseum.colosseum.web.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/sign-in")
public class SignInController {

	@GetMapping
	public String signInForm() {
		return "sign-in/form";
	}

	@PostMapping
	public String signIn(@RequestParam Map<String, String> param) {
		String email = param.get("email");
		String password = param.get("password");
		return "redirect:/";
	}
}
