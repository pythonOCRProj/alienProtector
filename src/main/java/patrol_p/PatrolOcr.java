package patrol_p;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import jakarta.servlet.http.HttpServletRequest;

public class PatrolOcr {
	String photo, path, position, date, time;
	
	public String ocr(String  file, HttpServletRequest request) {
		
		path = "D:/kmj/javaProj/alienProtector/alienPython/patrol_python/ocr.py";
		photo = "D:\\kmj\\javaProj\\alienProtector\\src\\main\\webapp\\img\\"+file;
		
		//path = "C:/CSJ/workspace/alienProtector/alienPython/patrol_python/ocr.py"; //성재
		//photo = "C:/CSJ/workspace/alienProtector/src/main/webapp/img/"+file;        //성재
		ProcessBuilder pb = new ProcessBuilder("python", path, photo);

		try {
			Process process = pb.start();
			
			// 실행중에 print()로 출력하는 내용 가져오기
			
			InputStreamReader isr = new InputStreamReader(process.getInputStream(), "ms949");
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			ArrayList<String> arr = new ArrayList<String>();
			while((line=br.readLine())!=null) {
				arr.add(line.trim());
			}
			String [] str = arr.get(0).split(",");
			if(!str[1].equals("")) {
				String [] dateTime = str[1].split(" ");
				
				date = dateTime[0].replace(":", "-");
				time = dateTime[1];
			}else {
				date = null;
				time = null;
			}
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
			System.out.println("종료 코드 : " + exitCode);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return position;
		
	}

}
