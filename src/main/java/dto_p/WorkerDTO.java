package dto_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkerDTO {
	Date joinDate;
	String id, pwd, profileImg, email, phone_num, name, addr, attendTimeStr;
	int no, hire;
	Date attendTime, leaveTime;
	private String leaveTimeStr;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	

	public Date getAttendTime() {
		return attendTime;
	}
	public void setAttendTime(Date attendTime) {
		this.attendTime = attendTime;
		this.attendTimeStr = sdf.format(attendTime);
	}
	public String getLeaveTimeStr() {
		return leaveTimeStr;
	}
	public void setLeaveTimeStr(String leaveTimeStr) {
		this.leaveTimeStr = leaveTimeStr;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public void setAttendTimeStr(String attendTimeStr) {
		this.attendTimeStr = attendTimeStr;
		try {
			this.attendTime = sdf.parse(attendTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getAttendTimeStr() {
		return attendTimeStr;
	}


	public String getJoinDateStr() {
		return sdf.format(joinDate);
	}
	public void setJoinDateStr(String joinDate) {
		try {
			this.joinDate = sdf.parse(joinDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHire() {
		return hire;
	}
	public void setHire(int hire) {
		this.hire = hire;
	}
	
}
