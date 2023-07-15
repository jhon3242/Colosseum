package colosseum.colosseum.domain.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
	private Long postId;
	private String title;
	private String content;
	private String username;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedDate;
}
