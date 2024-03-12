package notice_p;

import java.io.IOException;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeWriteReg implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("NoticeWriteReg 자바 진입");
		
		NoticeDTO dto =new NoticeDTO();
		
		String upFileName;
		
		try {
			upFileName = new FileUp(request).fileUpload(request.getPart("upfile"));
			
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			dto.setImg(upFileName);
			System.out.println(upFileName);
			//System.out.println(dto.getContent());
			new NoticeDAO().write(dto);
			
			int no = new NoticeDAO().newNo();

			request.setAttribute("incUrl", "components/moveUrl.jsp");
			request.setAttribute("msg", "작성되었습니다.");
			request.setAttribute("move", "NoticeList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
