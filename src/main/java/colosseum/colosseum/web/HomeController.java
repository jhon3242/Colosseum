package colosseum.colosseum.web;

import colosseum.colosseum.SessionConst;
import colosseum.colosseum.domain.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String mainPage(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) User user,
	                       Model model){
		if (user == null) {
			log.info("미 로그인 유저");
			return "home";
		}
		model.addAttribute("user", user);
		log.info("로그인 유저 {}", user);
		return "signInHome";
	}
}
