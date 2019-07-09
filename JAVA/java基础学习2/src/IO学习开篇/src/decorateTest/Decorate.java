package decorateTest;

/**
 * 装饰器
 * 1.简单实现放大器的功能
 * @author sofency
 *
 */
public class Decorate {

	public static void main(String[] args) {
		
		Person person=new Person();
		person.speak();
		
		
		Amplifier amplifier=new Amplifier(person);//把对象拉进来使劲添加功能
		amplifier.speak();
	}
	
}

interface say{
	public void speak();
}

class Person implements say{

	private int voice=10;//默认分贝是10
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("音量是---"+this.voice);
	}
	public int getVoice() {
		return this.voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	} 
	
	
}

class Amplifier implements say{

	private Person p;//将要修饰的对象传入装饰器中
	public Amplifier(Person p) {
		// TODO Auto-generated constructor stub
		this.p=p;
	}
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println(p.getVoice()*100);//进行将对象进行装饰
		System.out.println("噪音");
	}
	
}
