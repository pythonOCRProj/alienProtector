package patrol_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import dao_p.PatrolDAO;
import dao_p.WorkDAO;
import dto_p.PatrolDTO;
import dto_p.PlaceDTO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service_p.PatrolService;

public class PatrolWrite implements PatrolService{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			int turn = 0;
			HttpSession session = request.getSession();
			WorkerDTO res = (WorkerDTO)session.getAttribute("Worker");
			String id = res.getId();
			
			Date date = new Date();
			SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
			String day = smf.format(date);
			
			
			//회차 정보 체크 리스트
			ArrayList<Boolean> turnChk = new ArrayList<Boolean>();
			
			
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
		
			if(turnCnt >= 5) {
				turnChk.set(0, true);
			}
			if(turnCnt >= 10) {
				turnChk.set(1, true);
			}
			if(turnCnt >= 15) {
				turnChk.set(2, true);
			}
			
			ArrayList<PatrolDTO> data = new PatrolDAO().list(id,turn);
			ArrayList<PlaceDTO> place = new WorkDAO().placeList(); 
			
			
			request.setAttribute("data", data);
			request.setAttribute("place", place);
			request.setAttribute("turn", turnChk);
			request.setAttribute("day", day);
		}catch(NullPointerException e) {
			new RedirectionPage(request, response).goMain("로그인 해주세요.");
		}

	}

}
