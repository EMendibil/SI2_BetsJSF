package eredua.domeinua;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id 
	private String userName;	
	private String pasahitza;
	private int mota; //0 balio du erabiltzaile arrunta bada eta 1 administradorea bada
	private double dirKop; // erabiltzaile arruntentzat da, apustuak egiteko dirua kudeatzeko
	
	public User(){
		super();
	}
	
	public User(String userName, String pasahitza, int mota, double d){ //Eraikitzaile hau DataAccessHibernate-n adminak sortzeko da nagusiki
		this.userName = userName;
		this.pasahitza = pasahitza;
		this.mota = mota;
		this.dirKop = d;
	}
	
	public User(String userName, String pasahitza){ //Eraikitzaile hau erabiliko da aplikazioaren bidez erregistratzean
		this.userName = userName;
		this.pasahitza = pasahitza;
		this.mota = 0;
		this.dirKop = dirKop;
	}
	
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
	public void setDirKop(float dirKop) {
		this.dirKop = dirKop;
	}
	
	
}
