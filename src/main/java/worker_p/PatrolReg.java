package worker_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PatrolReg {
	public static void main(String[] args) {
		String path = "ailenPython/patrol_python/ocr.py";
		String photo = "/Users/zuzooclub/Desktop/Proj/java/hone/src/main/webapp/img/102.jpeg";
		ProcessBuilder pb = new ProcessBuilder("python3", path, photo);
		try {
			Process process = pb.start();
			InputStreamReader isr = new InputStreamReader(process.getInputStream(), "ms949");
//			FileReader fr = new FileReader("ailenPython/text/aaa.txt");
			BufferedReader br = new BufferedReader(isr);
//			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
				char [] ocr = line.trim().toCharArray();            
				switch(ocr[2]) {
					case '1':
						System.out.println("101호");
						break;
					case '2':
						System.out.println("102호");
						break;
					case '3':
						System.out.println("103호");
						break;
					case '4':
						System.out.println("104호");
						break;
					case '5':
						System.out.println("105호");
						break;
				}
				}
			
			br.close();
			isr.close();
//			fr.close();
			int exitCode = process.waitFor();
			System.out.println("종료 코드 : " + exitCode);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
