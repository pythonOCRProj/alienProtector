package notice_p;
import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;


public class NoticeDelete  implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDTO dto = new NoticeDAO().detail(no);
		
		new NoticeDAO().delete(no);
		System.out.println("노티스삭제JAVA진입");
		request.setAttribute("incUrl", "components/moveUrl.jsp");
		request.setAttribute("msg", "삭제되었습니다.");
		request.setAttribute("move", "NoticeList");
		
	}
	
}
