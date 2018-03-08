package file.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="filedata")
public class FileData {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="file_name")
	private String fileName;
	@Column(name="file_size")
	private Long fileSize;
	@Column(name="creation_time")
	private Date creationTime;
	@Column(name="mime_type")
	private String mimeType;
	@Column(name="file_path")
	private String filePath;
	
	public FileData() {
		
	}

	public FileData(Long id, String fileName, Long fileSize, Date creationTime, String mimeType, String filePath) {
		this.id = id;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.creationTime = creationTime;
		this.mimeType = mimeType;
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
	
}
