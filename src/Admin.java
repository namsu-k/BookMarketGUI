
public class Admin {
	private String id = "admin";
	private String pw = "123";
	private boolean isLogIn = false;

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public boolean getIsLogin() {
		return this.isLogIn;
	}

	public void setIsLogin() {
		this.isLogIn = true;
	}

}
