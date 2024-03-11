package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.WorkerDTO;

public class WorkerDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public WorkerDAO() {

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
		
	/**로그인하기 - DB와 비교해서 동일하면 메인페이지, 틀리면 로그인 페이지 유지*/
	public WorkerDTO loginChk(WorkerDTO dto) {
		WorkerDTO res = null;
		
		sql = "select id, no, name from worker where id = ? and pwd = ?";
		
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());  //회원이 입력한 값입니다!
			psmt.setString(2, dto.getPwd());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {	
				res = new WorkerDTO();
				res.setId(rs.getString("id")); 
				res.setNo(rs.getInt("no"));
				res.setName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
}
