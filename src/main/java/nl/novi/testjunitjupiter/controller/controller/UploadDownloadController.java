package nl.novi.testjunitjupiter.controller.controller;

import nl.novi.testjunitjupiter.model.model.UploadDownload;
import nl.novi.testjunitjupiter.payload.request.UploadDownloadRequestDto;
import nl.novi.testjunitjupiter.payload.response.UploadDownloadResponseDto;
import nl.novi.testjunitjupiter.service.service.UploadDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("upload_download")
@CrossOrigin
public class UploadDownloadController {

    @Autowired
    UploadDownloadService uploadDownloadService;

    @GetMapping("/files")
    public ResponseEntity<Object> getFiles() {
        Iterable<UploadDownload> files = uploadDownloadService.getFiles();
        return ResponseEntity.ok().body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<Object> getFileInfo(@PathVariable long id) {
        UploadDownloadResponseDto response = uploadDownloadService.getFileById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/files/{id}/download")
    public ResponseEntity downloadFile(@PathVariable long id) {
        Resource resource = uploadDownloadService.downloadFile(id);
        String mediaType = "application/octet-stream";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mediaType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    /*
    @PutMapping(value = "/files/{id}")
    public ResponseEntity<Object> updateUploadFile(@PathVariable("id") long id, @RequestBody uploadDownloadService uploadDownloadService) {
        uploadDownloadService.updateUploadFile(id, uploadDownloadService);
        return ResponseEntity.noContent().build();
    }
     */

    @PostMapping(value = "/files",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> uploadFile(UploadDownloadRequestDto uploadDownloadDto) {
        long newId = uploadDownloadService.uploadFile(uploadDownloadDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @DeleteMapping("/files/{id}")
    public ResponseEntity<Object> deleteFile(@PathVariable long id) {
        uploadDownloadService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }

}
