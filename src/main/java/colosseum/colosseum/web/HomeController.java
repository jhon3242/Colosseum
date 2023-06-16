package colosseum.colosseum.web;

import colosseum.colosseum.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

	@GetMapping("/")
	public String mainPage(){
		return "home";
	}
}
