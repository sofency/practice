package objectStream;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ObjectStream {
	public static void main(String[] args) throws IOException {
		//���Ͷ�����  ���л�
		//1. �����������
		ByteArrayOutputStream baos=new ByteArrayOutputStream();//���Ը�Ϊ����һ����������д���
		//2. �����ö��������
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(baos));
		
		//��ʼд����
		Employee num=new Employee("sofency", 18, 15000);//����Ա������
		//oos.writeObject("sofency");
		oos.writeObject(num);//д������
		oos.flush();
		oos.close();
		baos.close();
		
		//���ܶ�����  �����л�
		//1. ������������
		byte[] datas=baos.toByteArray();
		ByteArrayInputStream bais=new ByteArrayInputStream(datas);
		//2. ���ö��������
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(bais));
		
		try {
			//String nameString=(String)ois.readObject();
			Employee num1=(Employee)ois.readObject();//��ȡ����
			System.out.println(num1.getName()+","+num1.getAge()+","+num1.getSalary());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
		bais.close();
	}

}


class Employee implements Serializable{/**Ҫʵ�����л�
	 * 
	 */
	private static final long serialVersionUID = 1L;
//����Ķ���Ҫʵ�����л����ܽ��д���
	private  transient String name;//����͸����ʵ�����л�
	private int age;
	private double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
}
