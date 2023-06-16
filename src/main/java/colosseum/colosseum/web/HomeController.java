package colosseum.colosseum.web;

import colosseum.colosseum.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String mainPage(Model model){
		User user = (User)model.getAttribute("user");
		if (user != null) {
			return "loginHome";
		}
		return "home";
	}
}
