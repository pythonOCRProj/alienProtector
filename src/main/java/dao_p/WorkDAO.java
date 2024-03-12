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
import dto_p.PlaceDTO;
import dto_p.WorkerDTO;

public class WorkDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public WorkDAO() {
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
	
	
	public ArrayList<PatrolDTO> dateList(){
		ArrayList<PatrolDTO> res = new ArrayList<PatrolDTO>();
		PatrolDTO dto = null;
		
		sql = "select date from work_log group by date "
				+"order by date desc";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new PatrolDTO();
				dto.setDate(rs.getString("date"));
				
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
	
	public ArrayList<WorkerDTO> workerList(){
		ArrayList<WorkerDTO> res = new ArrayList<WorkerDTO>();
		WorkerDTO dto = null;
		
		sql = "select name, id, no from worker "
				+"order by no";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new WorkerDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setNo(rs.getInt("no"));
				
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
	
	public ArrayList<PlaceDTO> placeList(){
		ArrayList<PlaceDTO> res = new ArrayList<PlaceDTO>();
		PlaceDTO dto = null;
		
		sql = "select * from place "
				+"order by position";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new PlaceDTO();
				dto.setPosition(rs.getString("position"));
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
	
	
	public ArrayList<PatrolDTO> workData(){
		ArrayList<PatrolDTO> res = new ArrayList<PatrolDTO>();
		PatrolDTO dto = null;
		
		sql = "select * from work_log "
				+"order by date, time";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new PatrolDTO();
				dto.setId(rs.getString("id"));
				dto.setPosition(rs.getString("position"));
				dto.setSpecial(rs.getString("special"));
				dto.setDate(rs.getString("date"));
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
