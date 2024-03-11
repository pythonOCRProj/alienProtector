package dao_p;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.PatrolDTO;


public class PatrolDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public PatrolDAO() {
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
		if(rs!=null) { try { rs.close();} catch (SQLException e) {}}
		if(psmt!=null) { try { psmt.close();} catch (SQLException e) {}}
		if(con!=null) { try { con.close();} catch (SQLException e) {}}
	}
	
	
	public ArrayList<PatrolDTO> list(){
		ArrayList<PatrolDTO> patrol = new ArrayList<PatrolDTO>();
		sql = "select * from work_log";
		
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {

				PatrolDTO dto = new PatrolDTO();
				dto.setPhoto(rs.getString("photo"));
				dto.setId(rs.getString("id"));
				dto.setSpecial(rs.getString("special"));
				dto.setPosition(rs.getString("position"));
				

				patrol.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		
		return patrol;
		
	}
	
	public void write(PatrolDTO dto){
		sql = "insert into work_log (photo, date, special, position, id) values (?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
	
	
			psmt.setString(1,dto.getPhoto());
			psmt.setDate(2,(Date) dto.getDate());
			psmt.setString(3,dto.getSpecial());
			psmt.setString(4,dto.getPosition());
			psmt.setString(5,dto.getId());
		
	
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
} 
