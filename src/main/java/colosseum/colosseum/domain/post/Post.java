package colosseum.colosseum.domain.post;

import colosseum.colosseum.domain.file.UploadFile;
import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Post {
	@NumberFormat(pattern = "000000")
	private Long postId;
	private String title;
	private String content;
	private String author;
	private List<UploadFile> images;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifiedDate;
}
