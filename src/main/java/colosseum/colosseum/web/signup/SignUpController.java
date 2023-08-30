package colosseum.colosseum.web.signup;

import colosseum.colosseum.domain.member.Gender;
import colosseum.colosseum.domain.member.Member;
import colosseum.colosseum.domain.member.MemberRepositoryImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/sign-up")
public class SignUpController {

	private final MemberRepositoryImp userRepository;

	@GetMapping
	public String SignUpForm(@ModelAttribute("user") SignUpDto user, Model model) {
		model.addAttribute("genders", Gender.values());
		return "sign-up/form";
	}

	@PostMapping
	public String SignUp(@Validated @ModelAttribute("user") SignUpDto signUpDto,
	                     BindingResult bindingResult) {

		if (!Objects.equals(signUpDto.getPassword(), signUpDto.getConfirmPassword())) {
			bindingResult.rejectValue("password", "NotMatch", "비밀번호가 서로 일치하지 않습니다.");
		}
		if (bindingResult.hasErrors()) {
			log.error("회원 가입 에러 발생 {}", bindingResult);
			return "sign-up/form";
		}

		Member user = new Member(signUpDto);
		userRepository.save(user);
		log.info("회원 가입 완료 {}", user);
		return "redirect:/";
	}




}
