package patrol_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PatrolWrite {

	public static void main(String[] args) {
		String path = "C:\\woong\\workspace\\alienProtector\\ailenPython\\patrol_python\\ocr.py";

		ProcessBuilder pb = new ProcessBuilder("python", path);
		try {
			Process process = pb.start();
			
			// 실행중에 print()로 출력하는 내용 가져오기
			InputStreamReader isr = new InputStreamReader(process.getInputStream(), "ms949");
//			FileReader fr = new FileReader("ailenPython/text/aaa.txt");
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
				char [] ocr = line.trim().toCharArray();            
				switch(ocr[2]) {
					case '1':
						System.out.println("101");
						break;
					case '2':
						System.out.println("102");
						break;
					case '3':
						System.out.println("103");
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
