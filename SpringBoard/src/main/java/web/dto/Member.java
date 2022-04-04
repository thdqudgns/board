package web.dto;

public class Member {
	
	private String id;	//아이디(String)
	private String pw;	//비번(String)
	private String nick;//닉(String)
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", nick=" + nick + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	

}
