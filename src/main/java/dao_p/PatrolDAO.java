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
	
	
	public ArrayList<PatrolDTO> list(String id,int turn){
		ArrayList<PatrolDTO> patrol = new ArrayList<PatrolDTO>();
		sql = "select * from work_log wl join commute c on str_to_date(c.go_time , '%Y-%m-%d') = curdate() "
				+ "where wl.`date` = curdate() and  wl.id = ? and wl.turn = ? group by no";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1,id);
			psmt.setInt(2, turn);
			rs = psmt.executeQuery();
			while(rs.next()) {

				PatrolDTO dto = new PatrolDTO();
				dto.setPhoto(rs.getString("photo"));
				dto.setId(rs.getString("id"));
				dto.setSpecial(rs.getString("special"));
				dto.setPosition(rs.getString("position"));
				dto.setDate(rs.getString("date"));
				dto.setTime(rs.getString("time"));
				dto.setShift(rs.getString("shift"));
				dto.setNo(rs.getInt("no"));
				

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
		sql = "insert into work_log (photo, date, special, position, id, time,shift, turn) values (?,?,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			
	
			psmt.setString(1,dto.getPhoto());
			psmt.setString(2, dto.getDate());
			psmt.setString(3,dto.getSpecial());
			psmt.setString(4,dto.getPosition());
			psmt.setString(5,dto.getId());
			psmt.setString(6,dto.getTime());
			psmt.setString(7,dto.getShift());
			psmt.setInt(8,dto.getTurn());
	
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public String count(String id) {
		String time = "";
		sql = "select (select max(no) from work_log) as max_no ,date,time from work_log wl "
				+ "where wl.id  = ? and wl.`date` = curdate()  "
				+ "order by date desc ,time desc limit 0,1";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
		if(rs.next()) {
			time = rs.getString(3);
		}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return time;
	}
	

	public int turnCnt(String id) {
		int cnt = 0;
		
		sql = "select count(position) from work_log wl where wl.id = ? and wl.`date` = curdate()";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1,id);
			rs = psmt.executeQuery();
			
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return cnt;
	}
	public int overlap(String id, String pos, int turn) {
		int cnt = 0;
		sql = "select count(position) from work_log wl where wl.id = ? and wl.`date` = curdate() and wl.`position` = ? and turn = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1,id);
			psmt.setString(2,pos);
			psmt.setInt(3,turn);
		
			rs = psmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return cnt;
	}
	
	
} 
