package accountbook.vo;

import java.util.Date;

public class UserinfoVO {
	private int no;
	private String id;
	private String password;
	private String name;
	private Date regdate;
	
	public UserinfoVO() {
	
	}
	
	// 로그인을 하고 AccountFrame으로 name를 넘겨주기 위해서 만든 생성자 
	public UserinfoVO(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the regdate
	 */
	public Date getRegdate() {
		return regdate;
	}

	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "UserinfoVO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", regdate="
				+ regdate + "]";
	}
	
	
	
}
