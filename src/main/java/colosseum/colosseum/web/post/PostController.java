package colosseum.colosseum.web.post;

import colosseum.colosseum.SessionConst;
import colosseum.colosseum.domain.file.UploadFile;
import colosseum.colosseum.domain.post.Post;
import colosseum.colosseum.domain.post.PostForm;
import colosseum.colosseum.domain.post.PostRepository;
import colosseum.colosseum.domain.member.Member;
import colosseum.colosseum.web.file.FileUploadService;
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
import java.util.List;

@Slf4j
@RequestMapping("/post")
@RequiredArgsConstructor
@Controller
public class PostController {

	private final PostRepository postRepository;
	private final FileUploadService fileUploadService;

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
		Member user = (Member) session.getAttribute(SessionConst.LOGIN_USER);
		return user.getUsername();
	}

	@PostMapping("new")
	public String newPost(@ModelAttribute("post") PostForm postForm, HttpServletRequest request) throws IOException {
		Post post = getPost(postForm, request);
		List<UploadFile> uploadFiles = fileUploadService.storeFiles(postForm.getImages());
		post.setImages(uploadFiles);
		log.info("post 새 글 작성 = {}", post);
		return "redirect:/post";
	}

	private Post getPost(PostForm postForm, HttpServletRequest request) {
		Post post = new Post();
		post.setTitle(postForm.getTitle());
		post.setAuthor(postForm.getAuthor());
		post.setContent(postForm.getContent());
		post.setCreatedDate(LocalDateTime.now());
		post.setModifiedDate(LocalDateTime.now());
		post.setAuthor(getAuthor(request));
		return postRepository.save(post);
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
