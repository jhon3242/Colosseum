package colosseum.colosseum.domain.post;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PostRepository {
	private final Map<Long, Post> store = new ConcurrentHashMap<>();
	private Long sequence = 0L;

	public Post save(Post post) {
		post.setPostId(++sequence);
		store.put(post.getPostId(), post);
		return post;
	}

	public Post findById(Long id) {
		return store.get(id);
	}

	public List<Post> findAll() {
		return new ArrayList<>(store.values());
	}
}
