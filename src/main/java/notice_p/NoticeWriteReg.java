package notice_p;

import java.io.IOException;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import etc_p.FileUp;
import etc_p.RedirectionPage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeWriteReg implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//System.out.println("NoticeWriteReg 자바 진입");
		
		NoticeDTO dto =new NoticeDTO();
		
		String upFileName;
		
		try {
			
			//System.out.println(request.getPart("upfile"));
			
			if(request.getParameter("title").equals("")||request.getParameter("content").equals("")) {
				new RedirectionPage(request, response).movePage("제목과 내용은 필수입력사항입니다.","NoticeList");
			}else {
				upFileName = new FileUp(request).fileUpload(request.getPart("upfile"));
				
				dto.setTitle(request.getParameter("title"));
				dto.setContent(request.getParameter("content"));
				dto.setImg(upFileName);
			
				new NoticeDAO().write(dto);
				int no = new NoticeDAO().newNo();
				new RedirectionPage(request, response).movePage("작성되었습니다","NoticeList" );
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
