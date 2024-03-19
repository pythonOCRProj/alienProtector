package dto_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommuteDTO {
	String id, name;
	Date goTime, leaveTime;
	int cnt, hire;
	
	
	public int getHire() {
		return hire;
	}
	public void setHire(int hire) {
		this.hire = hire;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String getGoTimeStr() {
		return sdf.format(goTime);
	}
	public void setGoTimeStr(String goTime) {
		try {
			this.goTime = sdf.parse(goTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getLeaveTimeStr() {
		return sdf.format(leaveTime);
	}
	public void setLeaveTimeStr(String leaveTime) {
		try {
			this.leaveTime = sdf.parse(leaveTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getGoTime() {
		return goTime;
	}
	public void setGoTime(Date goTime) {
		this.goTime = goTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
}
