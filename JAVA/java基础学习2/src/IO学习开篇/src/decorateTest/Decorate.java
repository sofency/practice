package decorateTest;

/**
 * װ����
 * 1.��ʵ�ַŴ����Ĺ���
 * @author sofency
 *
 */
public class Decorate {

	public static void main(String[] args) {
		
		Person person=new Person();
		person.speak();
		
		
		Amplifier amplifier=new Amplifier(person);//�Ѷ���������ʹ����ӹ���
		amplifier.speak();
	}
	
}

interface say{
	public void speak();
}

class Person implements say{

	private int voice=10;//Ĭ�Ϸֱ���10
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("������---"+this.voice);
	}
	public int getVoice() {
		return this.voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	} 
	
	
}

class Amplifier implements say{

	private Person p;//��Ҫ���εĶ�����װ������
	public Amplifier(Person p) {
		// TODO Auto-generated constructor stub
		this.p=p;
	}
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println(p.getVoice()*100);//���н��������װ��
		System.out.println("����");
	}
	
}
