package ����ѧϰ;

public class student extends person{
	
	public String nameString="����";
	protected int age;
	String sfavString;
	private String ssex="Ů";
	public static int money=1000;
	
	public student() {//�޲ι�����
		super();
	}
	
	public String sHi() {
		System.out.println("Hi Reflect");
		return "Hi reflect";
	}
	
	public static String sHi(String str) {
		System.out.println(str);
		return str;
	}
	
	protected void Shello() {
		System.out.println("student.Shello(protected)");
	}
	
	private void Shello1() {
		System.out.println("student.Shello1(private)");
	}
	void Shello2() {
		System.out.println("student.Shello2(default)");
	}
	

}
