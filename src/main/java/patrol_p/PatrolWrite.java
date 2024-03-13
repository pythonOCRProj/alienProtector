package patrol_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import dao_p.PatrolDAO;
import dto_p.PatrolDTO;
import dto_p.WorkerDTO;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service_p.PatrolService;

public class PatrolWrite implements PatrolService{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		int turn = 0;
		HttpSession session = request.getSession();
		WorkerDTO res = (WorkerDTO)session.getAttribute("Worker");
		String id = res.getId();
		ArrayList<Boolean> chk = new ArrayList<Boolean>();
		ArrayList<Boolean> turnChk = new ArrayList<Boolean>();
		System.out.println(id);
		for (int i = 0; i < 3; i++) {
			turnChk.add(false);
		}
		
		int turnCnt = new PatrolDAO().turnCnt(id);	
		
		if(turnCnt <= 5) {
			turn = 1;
			
		
		}else if(turnCnt > 5 && turnCnt <= 10) {
			turn = 2;
			
		}else if(turnCnt > 10) {
			turn = 3;
			
			
		}
		

		
			
		ArrayList<PatrolDTO> data = new PatrolDAO().list(id,turn);

		for (int i = 0; i < 5; i++) {
			chk.add(false);
		}
	
		
		for (PatrolDTO dto : data) {
			int len = dto.getPosition().length();
			int no = Integer.parseInt( dto.getPosition().substring(len-2,len-1));
			chk.set(no-1, true);
			
		}
		if(turnCnt >= 5) {
			turnChk.set(0, true);
		}
		if(turnCnt >= 10) {
			turnChk.set(1, true);
		}
		if(turnCnt >= 15) {
			turnChk.set(2, true);
		}
		
		request.setAttribute("data", data);
		request.setAttribute("pos", chk);
		request.setAttribute("turn", turnChk);


	}

}
