package patrol_p;

import java.io.File;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUpload {
String directory;
	
	public FileUpload(HttpServletRequest request) {
		directory = request.getServletContext().getRealPath("img/");
		directory = "D:\\kmj\\javaProj\\alienProtector\\src\\main\\webapp\\img\\";//추후 수정 필요
	}	
	
	public String uploadFile(Part file) throws Exception {
		//getSubmittedFileName : 업로드한 파일의 원래 이름
		if(!file.getSubmittedFileName().equals("")) {

			String fileName = file.getSubmittedFileName();
			int dot = fileName.lastIndexOf(".");
			String domain = fileName.substring(0, dot);
			String ext = fileName.substring(dot);
			int cnt = 1;
			
			File userFile = new File(directory+fileName);
			
			while(userFile.exists()) {
				fileName = domain+"("+cnt+")"+ext;
				userFile = new File(directory+fileName);
				cnt++;
			}
			file.write(directory+fileName);
			file.delete();
			
			return fileName;
		}
		return null;
	}
	
	public void deleteFile(String fileName) {
		new File(directory+fileName).delete();
	}
}
