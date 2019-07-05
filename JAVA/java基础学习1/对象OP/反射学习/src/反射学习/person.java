package ∑¥…‰—ßœ∞;

public class person {
	public String pname;
	protected int age;
	String pfav;
	private String psex;
	
	public String  getHi(String h) {
		System.out.println(h);
		return "Hi";
	}
	
	public String pHi() {
		return "Hi reflect";
	}
	
	public String pHi(String str) {
		return str;
	}
	
	protected void Phello() {
		System.out.println("person.phello(protected)");
	}
	
	private void Phello1() {
		System.out.println("person.Phello1(private)");
	}
	void Phello2() {
		System.out.println("person.Phello2(default)");
	}
	
}
