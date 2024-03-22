package patrol_p;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PatrolOcr {
	String photo, path, position, date, time;
	
	public String ocr(String  file, HttpServletRequest request, HttpServletResponse response) {
		path = request.getServletContext().getRealPath("alienPython/patrol_python/");
		photo = request.getServletContext().getRealPath("img/");

		
		//path = "C:/CSJ/workspace/alienProtector/alienPython/patrol_python/ocr.py"; //성재
		//photo = "C:/CSJ/workspace/alienProtector/src/main/webapp/img/"+file;        //성재


		 //path = "D:/kmj/javaProj/alienProtector/alienPython/patrol_python/ocr.py"; // 명주꺼
		 //photo = "D:\\kmj\\javaProj\\alienProtector\\src\\main\\webapp\\img\\"+file; // 명주꺼
		
		// path = "C:\\gunwoopark\\workspace\\alienProtector\\alienPython\\patrol_python\\ocr.py"; // 건우꺼
		// photo = "C:\\gunwoopark\\workspace\\alienProtector\\src\\main\\webapp\\img\\"+file; // 건우꺼
		

		//path = "C:/woong/workspace/alienProtector/alienPython/patrol_python/ocr.py";
		//photo = "C:\\woong\\workspace\\alienProtector\\src\\main\\webapp\\img\\"+file;


		ProcessBuilder pb = new ProcessBuilder("python", path+"ocr.py", photo+file);

		try {
			Process process = pb.start();
			
			
			InputStreamReader isr = new InputStreamReader(process.getInputStream(), "ms949");
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			ArrayList<String> arr = new ArrayList<String>();
			
			while((line=br.readLine())!=null) {
				arr.add(line.trim());
			}
			// 메타데이터 시간
			String [] str = arr.get(0).split(",");
			
			
			if(!str[1].equals("")) {
				String [] dateTime = str[1].split(" ");
				
				date = dateTime[0].replace(":", "-");
				time = dateTime[1];
			}else {
				date = null;
				time = null;
			}
			
			
			// 장소 판별
			if(!arr.get(1).equals("")) {
				char [] ocr = arr.get(1).toCharArray();  
				switch(ocr[2]) {
					case '1':
						System.out.println("101호");
						position = "101호";
						break;
					case '2':
						System.out.println("102호");
						position = "102호";
						break;
					case '3':
						System.out.println("103호");
						position = "103호";
						break;
					case '4':
						System.out.println("104호");
						position = "104호";
						break;
					case '5':
						System.out.println("105호");
						position = "105호";
						break;
					default:
						System.out.println("구분못함");
						position = null;
						break;
				}
			}else {
				position = null;
			}
			
			
			br.close();
			isr.close();
			int exitCode = process.waitFor();
			
		} catch (Exception e) {
			new RedirectionPage(request, response).goMain("형식 오류입니다.");
			e.printStackTrace();
		}
		return position;
		
	}

}
