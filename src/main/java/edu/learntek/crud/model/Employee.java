/**
 * 
 */
package edu.learntek.crud.model;

/**
 * @author ADMIN
 *
 */
public class Employee {
	private int eid;
	private String name;
	private int sal;
	private String userid;
	private String password;
	
	public int getEid() {
		return eid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}		
}
