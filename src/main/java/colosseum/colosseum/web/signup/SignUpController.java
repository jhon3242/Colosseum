package colosseum.colosseum.web.signup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/sign-up")
@Slf4j
public class SignUpController {

	@GetMapping
	public String SignUpForm(@ModelAttribute("user") SignUpDto user) {
		return "sign-up/form";
	}

	@PostMapping
	public String SignUp(@Validated @ModelAttribute("user") SignUpDto user,
	                     BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			log.error("회원 가입 에러 발생");
			return "sign-up/form";
		}

		return "redirect:/";
	}




}
