

package model;

import java.io.Serializable;

public class MSTSEIHIN  implements Serializable{
	private String seihin_code;
	private String seihin_name;
	private int seihin_genka;
	private int seihin_teika;
	public MSTSEIHIN( String seihin_code,String seihin_name,int seihin_genka,int seihin_teika) {}
	public String getSeihin_code() {
		return seihin_code;
	}
	public void setSeihin_code(String seihin_code) {
		this.seihin_code = seihin_code;
	}
	public String getSeihin_name() {
		return seihin_name;
	}
	public void setSeihin_name(String seihin_name) {
		this.seihin_name = seihin_name;
	}
	public int getSeihin_genka() {
		return seihin_genka;
	}
	public void setSeihin_genka(int seihin_genka) {
		this.seihin_genka = seihin_genka;
	}
	public int getSeihin_teika() {
		return seihin_teika;
	}
	public void setSeihin_teika(int seihin_teika) {
		this.seihin_teika = seihin_teika;
	}
	
}
