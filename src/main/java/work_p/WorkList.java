package work_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import dao_p.WorkDAO;
import dao_p.WorkerDAO;
import dto_p.CommuteDTO;
import dto_p.PatrolDTO;
import dto_p.PlaceDTO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkService;

public class WorkList implements WorkService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WorkList");
		
		try {
			WorkerDTO dto = (WorkerDTO)request.getSession().getAttribute("Worker");
			if(!dto.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			}else {
				WorkerDTO res = new WorkerDTO();
				res.setId(request.getParameter("id"));
				res = new WorkerDAO().getWorkerInfo(res);
				request.setAttribute("dto", res);
			}
		}catch (NullPointerException e) {
			System.out.println("Exception (WorkerModify) - dto 값 없음");
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");;
		}
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todayStr = sdf.format(today.getTime());
		
		String sort = request.getParameter("sort");
		String start = request.getParameter("start");
		String end = request.getParameter("end");

		ArrayList<PatrolDTO> shiftList = new WorkDAO().shiftList();
		
		ArrayList<WorkerDTO> workerList = new WorkDAO().workerList();
		
		ArrayList<PlaceDTO> placeList = new WorkDAO().placeList();
		
		
		

		if(sort==null) {
			sort = "shift";		
		}
		if(start==null) {
			start = todayStr;			
		}
		if(end==null) {
			end = todayStr;			
		}
		
		try {
			Date startDate = sdf.parse(start);
			Date endDate = sdf.parse(end);	
			
			if(startDate.after(today)){
				start = todayStr;
				end = todayStr;
			}
			
			if(endDate.after(today)){
				end = todayStr;
			}else if(endDate.before(startDate) && startDate.before(today)){
				end = sdf.format(startDate);
			} 
			
			
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		HashMap<String, String> params = new HashMap();
		params.put("sort", sort);
		params.put("start", start);
		params.put("end", end);
		
		ArrayList<CommuteDTO> commuteList = new WorkDAO().commuteList(start, end);
		ArrayList<PatrolDTO> workCnt = new WorkDAO().workCnt(start,end);
		ArrayList<PatrolDTO> workData = new WorkDAO().workData(start,end);
		
		request.setAttribute("workData", workData);		
		request.setAttribute("params",params);

		if(sort.equals("shift")) {		
			request.setAttribute("shiftList", shiftList);
		}else if(sort.equals("worker")) {
			request.setAttribute("workerList", workerList);
			request.setAttribute("workCnt", workCnt);
			request.setAttribute("commuteList", commuteList);
		}else if(sort.equals("position")) {
			request.setAttribute("placeList", placeList);
		}

	}

}
