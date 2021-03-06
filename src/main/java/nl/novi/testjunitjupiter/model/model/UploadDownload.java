package nl.novi.testjunitjupiter.model.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "upload_download_files")
public class UploadDownload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
//ordernummer One to one relation

    @Column(name = "media_type")
    private String mediaType;

    @Column(name = "location")
    private String location;

    @Column(name = "uploaded_timestamp")
    private Date uploadedTimestamp;

    @Column(name = "uploaded_by_username")
    private String uploadedByUsername;


/*
    @OneToMany(mappedBy = "upload_download",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JsonIgnoreProperties("upload_download")
    @JsonBackReference
//    @JsonManagedReference

    Set<CustomerDetailsUploadDownloadResult> results;
*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getUploadedTimestamp() {
        return uploadedTimestamp;
    }

    public void setUploadedTimestamp(Date uploadedTimestamp) {
        this.uploadedTimestamp = uploadedTimestamp;
    }

    public String getUploadedByUsername() {
        return uploadedByUsername;
    }

    public void setUploadedByUsername(String uploadedByUsername) {
        this.uploadedByUsername = uploadedByUsername;
    }
}
