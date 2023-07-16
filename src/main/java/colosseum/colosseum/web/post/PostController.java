package colosseum.colosseum.web.post;

import colosseum.colosseum.domain.post.Post;
import colosseum.colosseum.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@RequestMapping("/post")
@RequiredArgsConstructor
@Controller
public class PostController {

	private final PostRepository postRepository;

	@GetMapping
	public String postList(Model model) {
		log.info("post 페이지 요청");
		model.addAttribute("posts", postRepository.findAll());
		return "post/postList";
	}

	@PostMapping
	public String newPostRedirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/post/new");
		return "redirect:/post/";
	}

	@GetMapping("new")
	public String newPostPage() {
		return "/post/newPost";
	}
}
