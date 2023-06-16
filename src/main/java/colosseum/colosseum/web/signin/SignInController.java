package colosseum.colosseum.web.signin;

import colosseum.colosseum.domain.User;
import colosseum.colosseum.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@Controller
@RequiredArgsConstructor
@RequestMapping("/sign-in")
public class SignInController {

	private final UserRepository userRepository;

	@GetMapping
	public String signInForm(@ModelAttribute("user") SignInDto signInDto) {
		return "sign-in/form";
	}

	@PostMapping
	public String signIn(@Validated @ModelAttribute("user") SignInDto signInDto, BindingResult bindingResult) {
		User findUser = userRepository.finaAll().stream().filter(v -> Objects.equals(v.getEmail(), signInDto.getEmail()))
				.findAny()
				.orElse(null);
		if (findUser == null || !findUser.isMatchPassword(signInDto.getPassword())) {
			bindingResult.rejectValue("password", "NotMatch");
		}
		if (bindingResult.hasErrors()) {
			return "sign-in/form";
		}
		return "redirect:/";
	}
}
