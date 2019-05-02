package mainPeckage;

public class Mitarbeiter {

	String name;
	int stundenlohn;
	
	public Mitarbeiter (String n, int s) {
		name = n;
		stundenlohn = s;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public int getStudenlohn() {
		return stundenlohn;
	}
	
	public void setStudenlohn(String newName) {
		this.name = newName;
	}
	
}
