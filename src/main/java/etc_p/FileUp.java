package etc_p;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUp {
	String dir;
	
	public FileUp(HttpServletRequest request) {		
		dir = request.getServletContext().getRealPath("img/");	


		dir = "C:\\woong\\workspace\\alienProtector\\src\\main\\webapp\\img\\"; //운만


//		dir = "C:\\CSJ\\workspace\\alienProtector\\src\\main\\webapp\\img\\"; //성재
//		dir = "C:\\gunwoopark\\workspace\\alienProtector\\src\\main\\webapp\\img\\"; //건우
		dir = "D:\\kmj\\javaProj\\alienProtector\\src\\main\\webapp\\img\\";

	}
	
	/** 파일 올리기 : new FileUp(request).fileUpload(request.getPart("upFile"));
	 * input type=file name = upFile로 getPart / String type 으로 파일이름 지정하여 설정하세요 
	 * */
	public String fileUpload(Part file) {
		if(!file.getSubmittedFileName().equals("")) {
			String upFileName = file.getSubmittedFileName();
			try {	
				
				int cnt = 1;
				String extension = upFileName.substring(upFileName.lastIndexOf("."));			
				String fileName = upFileName.substring(0,upFileName.lastIndexOf("."));
				File nowFile = new File(dir+upFileName);
				while(nowFile.exists()) {
					
					upFileName = fileName+"("+cnt+")"+extension;
					nowFile = new File(dir+upFileName);
					cnt++;
					
				}
				file.write(dir+upFileName);
				file.delete();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return upFileName;	
		}
		return null;				
	}
	
	
	public void fileDelete(String upFileName) {
		
		new File(dir+upFileName).delete();		
	}
		
}
