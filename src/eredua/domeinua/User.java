package eredua.domeinua;

public class User {

	private String userName;	
	private String pasahitza;
	private int mota; //0 balio du erabiltzaile arrunta bada eta 1 administradorea bada
	private double dirKop;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	public int getMota() {
		return mota;
	}
	public void setMota(int mota) {
		this.mota = mota;
	}
	public double getDirKop() {
		return dirKop;
	}
	public void setDirKop(double dirKop) {
		this.dirKop = dirKop;
	}
	
	
}
