package nl.novi.testjunitjupiter.repository.repository;

import nl.novi.testjunitjupiter.model.model.UploadDownload;
import org.springframework.data.repository.CrudRepository;

public interface UploadDownloadRepository extends CrudRepository<UploadDownload, Long> {
}
