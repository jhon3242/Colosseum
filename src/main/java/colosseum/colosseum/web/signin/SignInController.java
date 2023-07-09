package colosseum.colosseum.web.signin;

import colosseum.colosseum.SessionConst;
import colosseum.colosseum.domain.signin.SignInService;
import colosseum.colosseum.domain.user.User;
import colosseum.colosseum.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/sign-in")
public class SignInController {

	private final UserRepository userRepository;
	private final SignInService signInService;

	@GetMapping
	public String signInForm(@ModelAttribute SignInDto signInDto) {
		return "sign-in/form";
	}

	@PostMapping
	public String signIn(@Validated @ModelAttribute SignInDto signInDto,
	                     BindingResult bindingResult, HttpServletRequest request) {

		User findUser = signInService.signIn(signInDto.getEmail(), signInDto.getPassword());

		if (findUser == null || !findUser.isMatchPassword(signInDto.getPassword())) {
			bindingResult.reject("NotMatch");
		}
		if (bindingResult.hasErrors()) {
			return "sign-in/form";
		}
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_USER, findUser);
		log.info("유저 로그인 완료 {}", findUser);
		return "redirect:/";
	}
}
