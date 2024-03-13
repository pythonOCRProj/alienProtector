package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
		sql = "select id, no, name, hire from worker where id = ? and pwd = ?";
		
		
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
				res.setHire(rs.getInt("hire"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	public int attend(WorkerDTO dto) {
		int res = 0;
		
		sql = "insert into commute(id, go_time) values (?, ?)";
		
		try{
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getAttendTimeStr());
			res = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	
	/** 정운만 - 근무자 퇴근처리 합니다*/
	public int getOutWork(WorkerDTO dto) {
		int res = 0;
		
		sql = "update commute set leave_time = ? where id = ? and go_time = ?";

		try{
			psmt = con.prepareStatement(sql);
			System.out.println(dto.getId()+" : "+dto.getLeaveTimeStr() + " : "+ dto.getAttendTimeStr());
			psmt.setString(1, dto.getLeaveTimeStr());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getAttendTimeStr());
			
			
			
			res = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	/**정운만 - 근무자의 정보를 얻습니다.*/
	public WorkerDTO getWorkerInfo(WorkerDTO dto) {
		WorkerDTO res = null;
		
		sql = "select id, pwd, join_date, profile_img, email, phone_num, name, addr, hire  from worker where id = ?";
		
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());  //회원이 입력한 값입니다!
			psmt.setString(2, dto.getPwd());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {	
				res = new WorkerDTO();
				res.setId(rs.getString("id"));
				res.setPwd(rs.getString("pwd"));
				res.setJoinDate(rs.getDate("join_date"));
				res.setProfileImg(rs.getString("profile_img"));
				res.setEmail(rs.getString("email"));
				res.setPhoneNum(rs.getString("phone_num"));
				res.setName(rs.getString("name"));
				res.setAddr(rs.getString("addr"));
				res.setHire(rs.getInt("hire"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	//정운만
	/** 근무자의 정보를 저장합니다.*/
	public int updateWorker(WorkerDTO dto) {
		int res = 0;
		
		sql = "update worker set pwd = ?, phone_num = ?, profile_img = ? where id = ? ";
		
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getPwd());
			psmt.setString(2, dto.getPhoneNum());
			psmt.setString(3, dto.getProfileImg());
			psmt.setString(4, dto.getId());
			
			res = psmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return res;
	}
	//정운만
	/** 재직중인 혹은 퇴사한 근무자 아이디가 있는지 확인합니다.*/
	public boolean checkHiredWorker(String id) {
		boolean res = false;
		
		sql = "select id from worker where id = ?";
		
		try {
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				res = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public int updateReturning(WorkerDTO dto) {
		int res = 0;
		
		sql = "update worker set hire = ? where id = ?";
		
		try {
			
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, dto.getHire());
			psmt.setString(2, dto.getId());
			
			res = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	
	//회원목록을 list 형식으로 리턴 -박민수
	public ArrayList<WorkerDTO> list() {
		// list객체 인스턴스
		ArrayList<WorkerDTO> res = new ArrayList<WorkerDTO>();
		sql = "select * from worker";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
					
				WorkerDTO dto = new WorkerDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setProfileImg(rs.getString("profile_img"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoneNum(rs.getString("phone_num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setJoinDate(rs.getTimestamp("join_date"));
				dto.setHire(rs.getInt("hire"));
					
				res.add(dto);
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	//근무자등록 - 박민수
	public int join(WorkerDTO dto) {
				
		int cnt = 0;
		
		sql = "insert into worker(id, pwd, profile_img, email, phone_num, name, addr) values (?,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
					
					
			psmt.setString(1,  dto.getId());
			psmt.setString(2,  dto.getPwd());
			psmt.setString(3,  dto.getProfileImg());
			psmt.setString(4,  dto.getEmail());
			psmt.setString(5,  dto.getPhoneNum());
			psmt.setString(6,  dto.getName());
			psmt.setString(7,  dto.getAddr());
			psmt.executeUpdate();
			cnt = psmt.executeUpdate();
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
				
		return cnt;
				
	}
	
}
