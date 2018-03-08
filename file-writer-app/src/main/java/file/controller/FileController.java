package file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import file.dao.FileRepository;
import file.model.FileData;

@RestController
//Max uploaded file size (here it is 20 MB)
@MultipartConfig(fileSizeThreshold = 20971520)
public class FileController {
	
	MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
	
	@Autowired
	FileRepository fileRepository;

	private static final String UPLOAD_FOLDER = "D:/uploadedFiles/";
	
	@PostMapping("/upload")

	public String uploadFile(@RequestParam("uploadFile") MultipartFile file) throws IOException{
	
		String fileName = file.getOriginalFilename();
		
		 MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
		 
		String path = UPLOAD_FOLDER + fileName;

		File outputFile = new File(path);
		
		FileInputStream reader = null;
		FileOutputStream writer = null;
		
		try {
		    outputFile.createNewFile();
		    reader = (FileInputStream) file.getInputStream();
		    writer = new FileOutputStream(outputFile);
		} catch (IOException e) {
		    e.printStackTrace();
		}finally{
		    try {
		        reader.close();
		        writer.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		FileData entity = new FileData();
		entity.setFileName(fileName);
		entity.setCreationTime(new Date());
		entity.setFileSize(file.getSize());
		entity.setMimeType(mimeTypesMap.getContentType(file.getName()));
		entity.setFilePath(UPLOAD_FOLDER);
	
		fileRepository.save(entity);
		
		return "File uploaded successfully!";
	}
	
	@GetMapping("/files")
	public List<FileData> getAllFiles(){
		return fileRepository.findAll();
	}
	
	@GetMapping("/files/{id}")
	public FileData getFileById(@PathVariable(value="id") Long fileId) {
		FileData data = fileRepository.findById(fileId).orElse(null);
		return data;
	}
	
}
