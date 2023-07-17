package colosseum.colosseum.web.file;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FileController {

	private final FileUploadService fileUploadService;

	@Value("${file.dir}")
	private String fileDir;

	@GetMapping("/images/{filename}")
	public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
		log.info("filename = {}", filename);
		return new UrlResource("file:" + fileUploadService.getFullPath(filename));
	}
}
