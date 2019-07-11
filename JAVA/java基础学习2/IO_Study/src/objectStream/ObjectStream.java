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
		//发送对象流  序列化
		//1. 先设置输出流
		ByteArrayOutputStream baos=new ByteArrayOutputStream();//可以改为任意一个输出流进行传输
		//2. 再设置对象输出流
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(baos));
		
		//开始写对象
		Employee num=new Employee("sofency", 18, 15000);//创建员工对象
		//oos.writeObject("sofency");
		oos.writeObject(num);//写进对象
		oos.flush();
		oos.close();
		baos.close();
		
		//接受对象流  反序列化
		//1. 先设置输入流
		byte[] datas=baos.toByteArray();
		ByteArrayInputStream bais=new ByteArrayInputStream(datas);
		//2. 设置对象输出流
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(bais));
		
		try {
			//String nameString=(String)ois.readObject();
			Employee num1=(Employee)ois.readObject();//读取对象
			System.out.println(num1.getName()+","+num1.getAge()+","+num1.getSalary());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
		bais.close();
	}

}


class Employee implements Serializable{/**要实现序列化
	 * 
	 */
	private static final long serialVersionUID = 1L;
//传输的对象要实现序列化才能进行传输
	private  transient String name;//名字透明不实现序列化
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
