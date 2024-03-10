package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.NoticeDTO;

public class NoticeDAO {

	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public NoticeDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/alien");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void close() {
		if(rs!=null) {try {rs.close();} catch (SQLException e) {}}
		if(psmt!=null) {try {psmt.close();} catch (SQLException e) {}}
		if(con!=null) {try {con.close();} catch (SQLException e) {}}
	}
	
	
	public ArrayList<NoticeDTO> list() {
		ArrayList<NoticeDTO> res = new ArrayList<NoticeDTO>();
		
		sql = "select * from notice order by no desc";
		
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setNo(rs.getInt("no"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setImg(rs.getString("img"));
				dto.setTitle(rs.getString("title"));
				dto.setTime(rs.getTimestamp("time"));
				
				res.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	public NoticeDTO detail(int no) {
		NoticeDTO dto = null;
		
		sql = "select * from notice where no = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			
			rs = psmt.executeQuery();

			if(rs.next()) {
				dto = new NoticeDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setTime(rs.getTimestamp("time"));
				dto.setContent(rs.getString("content"));
				dto.setImg(rs.getString("img"));
				dto.setCnt(rs.getInt("cnt"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	

}