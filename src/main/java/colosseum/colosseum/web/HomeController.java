package colosseum.colosseum.web;

import colosseum.colosseum.SessionConst;
import colosseum.colosseum.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

	@GetMapping("/")
	public String mainPage(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) User user,
	                       Model model){
		if (user == null) {
			return "home";
		}
		model.addAttribute("user", user);
		return "loginHome";
	}
}
