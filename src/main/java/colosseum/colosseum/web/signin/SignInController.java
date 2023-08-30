package colosseum.colosseum.web.signin;

import colosseum.colosseum.SessionConst;
import colosseum.colosseum.domain.signin.SignInService;
import colosseum.colosseum.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@RequiredArgsConstructor
public class SignInController {

	private final SignInService signInService;

	@GetMapping("/sign-in")
	public String signInForm(@ModelAttribute SignInDto signInDto) {
		return "sign-in/signInForm";
	}

	@PostMapping("/sign-in")
	public String signIn(@Validated @ModelAttribute SignInDto signInDto,
	                     BindingResult bindingResult, HttpServletRequest request) {

		Member findUser = signInService.signIn(signInDto.getEmail(), signInDto.getPassword());

		if (findUser == null || !findUser.isMatchPassword(signInDto.getPassword())) {
			bindingResult.reject("SignInFail");
		}
		if (bindingResult.hasErrors()) {
			return "sign-in/signInForm";
		}
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_USER, findUser);
		String requestURL = getRequestURL(request);
		log.info("유저 로그인 완료 {} redirect={}", findUser, requestURL);
		return "redirect:" + requestURL;
	}

	private String getRequestURL(HttpServletRequest request) {
		String requestURL = request.getParameter("requestURL");
		if (requestURL == null) requestURL = "";
		return requestURL;
	}

	@PostMapping("/sign-out")
	public String signOut(HttpServletRequest request) {
		log.info("로그아웃 요청");
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}
