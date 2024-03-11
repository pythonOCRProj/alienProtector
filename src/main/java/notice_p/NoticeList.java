package notice_p;

import java.util.ArrayList;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeList implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("에일리언 노티스리스트 진입");
		
		ArrayList<NoticeDTO> listData = new NoticeDAO().list();
		request.setAttribute("noticeData", listData);
	}
}
