package colosseum.colosseum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/sign-up")
public class SignUp {

	@GetMapping
	public String SignUpForm() {
		return "sign-up/form";
	}

	@PostMapping
	public String SignUp(@RequestParam Map<String, String> param) {
		String username = param.get("username");
		String email = param.get("email");
		String password = param.get("password");
		String confirmPassword = param.get("confirm-password");


		return "redirect:/";
	}
}
