package patrol_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import dao_p.PatrolDAO;
import dto_p.PatrolDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.PatrolService;

public class PatrolWrite implements PatrolService{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("순찰 등록 페이지");
		ArrayList<PatrolDTO> data = new PatrolDAO().list();
		ArrayList<Boolean> chk = new ArrayList<Boolean>();
		
		for (int i = 0; i < 5; i++) {
			chk.add(false);
			
		}
		for (PatrolDTO dto : data) {
			int len = dto.getPosition().length();
			int no = Integer.parseInt( dto.getPosition().substring(len-2,len-1) );
			chk.set(no-1, true);
		}
		
		
		request.setAttribute("data", data);
		request.setAttribute("pos", chk);
		
	}

}
