package tn.Dari.spring.service;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@ApplicationScope
public class StorageService {
	final String CONTENT_DIR = "/content/";

    public String store(MultipartFile file) throws IOException {
        String id = UUID.randomUUID().toString();
        file.transferTo(new File(CONTENT_DIR.concat(id)));
        return id;
    }

    public Resource load(String id) {
        return new FileSystemResource(CONTENT_DIR.concat(id));
    }

    public void delete(String id) throws IOException {
        Files.delete(Paths.get(CONTENT_DIR.concat(id)));
    }
}
