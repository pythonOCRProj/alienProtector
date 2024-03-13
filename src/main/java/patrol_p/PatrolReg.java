package patrol_p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import dao_p.PatrolDAO;
import dao_p.WorkerDAO;
import dto_p.PatrolDTO;
import dto_p.WorkerDTO;
import etc_p.FileUp;
import etc_p.RedirectionPage;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import service_p.PatrolService;

public class PatrolReg implements PatrolService {
	public void service(HttpServletRequest request, HttpServletResponse response) {
	
		try {
			HttpSession session = request.getSession();
			WorkerDTO res = (WorkerDTO)session.getAttribute("Worker");
			
			PatrolDTO dto = new PatrolDTO();
			
			// 파일 업로드와 파이썬 ocr
			FileUp fileup = new FileUp(request);
			String file = fileup.fileUpload(request.getPart("photo"));
			PatrolOcr pyOcr = new PatrolOcr();
			String pos = pyOcr.ocr(file,request,response);
			
		
			
			// 날짜 계산
			Date now = new Date();
			SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
			String nowDate = smf.format(now);
			if(new WorkerDAO().hire(res.getId())) {
			// 특이사항 1000자 넘는지 판별
				if(request.getParameter("special").length() > 1000) {
					new RedirectionPage(request, response).goMain("1000자 이내로 작성해주세요");
				}
			
				// 등록된 사진의 turn
				int turnCnt = new PatrolDAO().turnCnt(res.getId());
				int turn = 0;
				if(turnCnt >= 5 && turnCnt < 10) {
					turn = 2;
				}else if(turnCnt >= 10) {
					turn = 3;
				}else {
					turn = 1;
				}
				
				// 해당 회차에 이미 등록된 장소 중복 확인
				int chk = new PatrolDAO().overlap(res.getId(), pos, turn);
				if(chk >= 1) {
					
					new RedirectionPage(request, response).goMain("이미 등록된 장소입니다.");
				}
				
				// 등록된 사진이 당일에 찍은게 아닐 때
				else if(pyOcr.date == null || !pyOcr.date.equals(nowDate) || pyOcr.time == null){
					
					new RedirectionPage(request, response).goMain("당일 등록 날짜가 아닙니다.");
			
				// 등록된 사진이 정상일 때
				}else if(pyOcr.date.equals(nowDate) && pos != null && pyOcr.time != null) {
					String lastStr = new PatrolDAO().count(res.getId());
					if(lastStr.equals("")) {
				    	lastStr = "00:00:00";
				    }
					System.out.println(lastStr);
					
					SimpleDateFormat smf2 = new SimpleDateFormat("HH:mm:ss");
				    Calendar last = Calendar.getInstance();
				    Calendar up = Calendar.getInstance();
				    
				 
				    last.setTime(smf2.parse(lastStr));
				    up.setTime(smf2.parse(pyOcr.time));
				    
				    //마지막 찍은 사진 시간 +20
				    last.add(Calendar.SECOND, 20);
				    
				    //현재 올린 사진의 시간이 마지막 찍은 사진의 시간에서 20초 지났는지 판별 
				    int compare = (smf2.format(up.getTime())).compareTo(smf2.format(last.getTime()));
				    
				    // 20초 지났으면 메타 데이터 뽑아오기 -> 과거 시간도 불가
					if(compare >= 0) {
						
						String [] sh = pyOcr.time.split(":");
						int hour = Integer.parseInt(sh[0]);
						
						// 찍은 사진으로 근무조 판별
						String shift = "";
						if(hour>=23 || (0<=hour && 7>hour)) {
							shift = "야간";
						}else if(hour>=7 && hour <15) {
							shift = "주간";
						}else if(hour>=15 && hour<23) {
							shift = "오후";
						}
						
						dto.setPosition(pos);
						dto.setPhoto(file);
						dto.setId(res.getId());
						dto.setSpecial(request.getParameter("special"));
						dto.setDate(pyOcr.date);
						dto.setTime(pyOcr.time);
						dto.setShift(shift);
						dto.setTurn(turn);
						
						new PatrolDAO().write(dto);
						new RedirectionPage(request, response).goMain( pos+" 등록이 되었습니다.");
						boolean aa = new WorkerDAO().hire(res.getId());
					
					}// 시간이 20초 안에 찍었거나 과거 시간일 때
					else {
						
						new RedirectionPage(request, response).goMain("올바른 시간이 아닙니다.");
					}
				
				}else if(pos == null) {
					new RedirectionPage(request, response).goMain("올바른 이미지가 아닙니다.");
				}
			}else {
				request.getSession().invalidate();
				new RedirectionPage(request, response).goMain("등록 가능 권한이 없습니다");
				
			}
			} catch (NullPointerException e) {
				new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

	}


}
