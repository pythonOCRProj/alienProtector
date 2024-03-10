package patrol_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import dao_p.PatrolDAO;
import dto_p.PatrolDTO;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.PatrolService;

public class PatrolReg implements PatrolService {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		String path = "ailenPython/patrol_python/ocr.py";
		String photo = "/Users/zuzooclub/Desktop/Proj/java/hone/src/main/webapp/img/102.jpeg";
		ProcessBuilder pb = new ProcessBuilder("python3", path, photo);
		PatrolDTO dto = new PatrolDTO();
		try {
			Process process = pb.start();
//			InputStreamReader isr = new InputStreamReader(process.getInputStream(), "ms949");
			FileReader fr = new FileReader("/Users/zuzooclub/Desktop/Proj/java/alienProtector/ailenPython/text/aaa.txt");
//			BufferedReader br = new BufferedReader(isr);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
				char [] ocr = line.trim().toCharArray();  
				
				switch(ocr[2]) {
					case '1':
						System.out.println("101호");
						dto.setPosition("101호");
						break;
					case '2':
						System.out.println("102호");
						dto.setPosition("102호");
						break;
					case '3':
						System.out.println("103호");
						dto.setPosition("103호");
						break;
					case '4':
						System.out.println("104호");
						dto.setPosition("104호");
						break;
					case '5':
						System.out.println("105호");
						dto.setPosition("105호");
						break;
				}
				dto.setPhoto("사진이다잉");
				dto.setId("김명주");
				dto.setSpecial("xmrxmrxmr");
				dto.setDate(new Date(1, 1, 1));
				
				new PatrolDAO().write(dto);
			}
			
			br.close();
//			isr.close();
			fr.close();
			int exitCode = process.waitFor();
			System.out.println("종료 코드 : " + exitCode);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("incUrl", "components/alert.jsp");
		request.setAttribute("goUrl", "/alienProtector/patrol/PatrolWrite");
	}
	

}
