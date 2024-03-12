package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.CommuteDTO;
import dto_p.PatrolDTO;


public class DashBoardDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	
	public DashBoardDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/alien");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void close() {
		if(rs!=null) { try { rs.close();} catch (SQLException e) {}}
		if(psmt!=null) { try { psmt.close();} catch (SQLException e) {}}
		if(con!=null) { try { con.close();} catch (SQLException e) {}}
	}
	
	
	public ArrayList<CommuteDTO> todayGo(String today){
		//System.out.println(today);
		ArrayList<CommuteDTO> res = new ArrayList<CommuteDTO>();
		CommuteDTO dto = null;
		
		sql = "select * from commute "
				+"where go_time >= ? and leave_time is null "
				+"order by go_time";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, today);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new CommuteDTO();
				dto.setId(rs.getString("id"));
				dto.setGoTime(rs.getTimestamp("go_time"));
				dto.setLeaveTime(rs.getTimestamp("leave_time"));
				
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
	
	public ArrayList<CommuteDTO> todayLeave(String today){
		ArrayList<CommuteDTO> res = new ArrayList<CommuteDTO>();
		CommuteDTO dto = null;
		
		sql = "select * from commute "
				+"where Date(leave_time) >= ? "
				+"order by go_time";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, today);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new CommuteDTO();
				dto.setId(rs.getString("id"));
				dto.setGoTime(rs.getTimestamp("go_time"));
				dto.setLeaveTime(rs.getTimestamp("leave_time"));
				
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
	
	public ArrayList<PatrolDTO> todayPatrol(String today){
		ArrayList<PatrolDTO> res = new ArrayList<PatrolDTO>();
		PatrolDTO dto = null;
		
		sql = "select * from work_log "
				+"where Date(date) >= ? "
				+"order by time";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, today);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new PatrolDTO();
				dto.setId(rs.getString("id"));
				dto.setSpecial(rs.getString("special"));
				dto.setPosition(rs.getString("position"));
				dto.setTime(rs.getString("time"));
				
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
}
