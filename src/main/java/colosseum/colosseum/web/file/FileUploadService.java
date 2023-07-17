package colosseum.colosseum.web.file;

import colosseum.colosseum.domain.file.UploadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class FileUploadService {

	@Value("${file.dir}")
	private String fileDir;

	public List<UploadFile> storeFiles(List<MultipartFile> files) throws IOException {
		List<UploadFile> result = new ArrayList<>();
		if (files.isEmpty()) {
			return null;
		}
		for (MultipartFile file : files) {
			UploadFile uploadFile = storeFile(file);
			result.add(uploadFile);
		}
		return result;
	}

	private UploadFile storeFile(MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			return null;
		}
		String originalFilename = file.getOriginalFilename();
		String storeFilename = createStoreFilename(originalFilename);
		file.transferTo(new File(getFullPath(storeFilename)));
		return new UploadFile(originalFilename, storeFilename);
	}

	public String getFullPath(String storeFilename) {
		return fileDir + storeFilename;
	}

	private String createStoreFilename(String originalFilename) {
		String uuid = UUID.randomUUID().toString();
		String ext = getExt(originalFilename);
		return uuid + "." + ext;
	}

	private String  getExt(String originalFilename) {
		int pos = originalFilename.indexOf(".");
		return originalFilename.substring(pos + 1);
	}
}
