package colosseum.colosseum.web.post;

import colosseum.colosseum.SessionConst;
import colosseum.colosseum.domain.post.Post;
import colosseum.colosseum.domain.post.PostRepository;
import colosseum.colosseum.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@RequestMapping("/post")
@RequiredArgsConstructor
@Controller
public class PostController {

	private final PostRepository postRepository;

	@GetMapping
	public String postList(Model model) {
		log.info("post 리스트 요청");
		model.addAttribute("posts", postRepository.findAll());
		return "post/postList";
	}

	@PostMapping
	public String newPostRedirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/post/new");
		return "redirect:/post/";
	}

	@GetMapping("new")
	public String newPostPage(@ModelAttribute Post post, HttpServletRequest request) {
		post.setAuthor(getAuthor(request));
		return "/post/newPost";
	}

	private String getAuthor(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute(SessionConst.LOGIN_USER);
		return user.getUsername();
	}

	@PostMapping("new")
	public String newPost(@ModelAttribute Post post, HttpServletRequest request) {
		setPostInfo(post, request);
		log.info("post 새 글 작성 = {}", post);
		return "redirect:/post";
	}

	private void setPostInfo(Post post, HttpServletRequest request) {
		post.setCreatedDate(LocalDateTime.now());
		post.setModifiedDate(LocalDateTime.now());
		post.setAuthor(getAuthor(request));
		postRepository.save(post);
	}

	@GetMapping("{postId}")
	public String postPage(@PathVariable Long postId, Model model) {
		Post post = postRepository.findById(postId);
		if (post == null) {
			log.error("post not found");
			return "redirect:/post";
		}
		log.info("post 페이지 요청 결과 = {}", post);
		model.addAttribute("post", post);
		return "/post/postPage";
	}

}