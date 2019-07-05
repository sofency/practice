package ����ѧϰ;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author sofency
 * ����ѧϰ
 *    1.��ȡ�����   Class.forName("���ȫ�޶�·��")��
 *    2.���������ķ��� 
 *    3.���������ķ���
 */
public class testReflect {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException ,IllegalArgumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
	  //�������������
		
		//operField();
//		getCla();
		//getField();
		operMethod();
	}
	
	
	//��������
	public static void operMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//��ȡ�����
		Class class1=Class.forName("����ѧϰ.student");
		//��ȡ�෽��
		System.out.println("--------��ȡ���е���ͷ�����������object��----------");
		Method[]  msMethods=class1.getMethods();
		for (Method method : msMethods) {
			System.out.println(method.getName());
		}
		System.out.println("---------��ȡ�Լ������ķ���----------");
		Method[] methods=class1.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
 		
		//ʹ�÷�����þ�̬�ķ���
		Method m1=class1.getDeclaredMethod("sHi", String.class);
		m1.invoke(null, "����");
		//ʹ�÷�����÷Ǿ�̬�ķ���
		Object object=class1.newInstance();
		Method m2=class1.getDeclaredMethod("sHi");//��һ��������������� �����Ǵ���Ĳ���
		m2.invoke(object);//��һ��������ʵ���������
	}
	
	
	
	public static void operField() throws ClassNotFoundException{
		//��ȡ�����
		Class cla=Class.forName("����ѧϰ.student");
		//��ȡ������ļ������Ҹ���Ĺ����ֶ�����
		Field[] fields=cla.getFields();
		
		for (Field field : fields) {
			System.out.println("��ȡ������-----"+field.getName());
			System.out.println("��ȡ������η�---->"+field.getType());//�������͵������
		}
		
		//��ȡָ�����ֶ�
		//Field f=cla.getFieled("�ֶ���")�� Ȼ����ʹ��f.getName()��ʾ������
		//Field f2=cla.getDeclaredField("�ֶ���") //ָ����ȡ��������ֶ�  ˽�еĺ͹����Ķ����Խ��в���
		//Field f3=cla.getSuperclass().getDeclaredField("�ֶ���")��ȡ�����������ֶ�
		
		//������̬����ֵ
		//�����ֶ�ֵ
		//Field fs=cla.getDeclaredField("�ֶ���");
		//��ȡ��̬�ֶ���������ֵ
		//System.out.println(fs.get(null));
		
		//�����Ǿ�̬����ֵ
		//Field fd=cla.getDeclaredField("�ֶ���");
		//System.out.println(fd.get(cla.newInstance()));
		
		
	}
	public static void getField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		System.out.println("-----------������̬����------------");
		Class cla=Class.forName("����ѧϰ.student");//ȫ�޶�·��
		Field f=cla.getDeclaredField("money");//��ȡ����
		//��ȡ��̬���Ե��ֶκ�����ֵ
		System.out.println(f.getName());//��ʾ�ֶ�����û�л�ȡ���ֶε�ֵ
		System.out.println("-----------������̬����ֵǰ------------");
		System.out.println(f.get(null)); //��ȡ��̬����ֵ
		
		//������̬���Ե�ֵ
		System.out.println("-----------������̬����ֵ��------------");
		f.set(null, 2000);
		System.out.println(f.get(null)); //��ȡ��̬����ֵ
		
		//��ȡ�������������
		System.out.println("----------��ȡ�������������------------");
		Field[] f1=cla.getSuperclass().getDeclaredFields();
		for (Field field : f1) {
			System.out.println(field.getName());
		}
		
		//�����Ǿ�̬����ֵ  cla.newInstance ���ظö����ʵ��������
		                  // Ҳ���Ǵ������� ��Ϊÿ�����󶼿��Բ���Ĭ�ϵ�����ֵ
		System.out.println("----------��ȡ�Ǿ�̬������ֵ---------------");
		Field f2=cla.getDeclaredField("nameString");
		Object object=cla.newInstance();
		System.out.println("----------�����Ǿ�̬����ǰ----------");
		System.out.println(f2.get(object));
		System.out.println("----------�����Ǿ�̬���Ժ�--------------");
		f2.set(object, "������");
		System.out.println(f2.get(object));
		
		//�²��ܷ����˽������  
		//�ó�����޷�����˽������
		
//		Field field3=cla.getDeclaredField("ssex");
//		System.out.println(field3.get(cla.newInstance()));  ��Ϊ���ص��Ƕ��� �����޷�����˽������
		
		//�����������˽�л�����
		Field f3=cla.getDeclaredField("ssex");
		f3.setAccessible(true);//�������� ����˽�л����Բ���ȫ
		Object object2=cla.newInstance();//��ȡʵ��������
		System.out.println(f3.get(object2));	
	}
	public static void getCla() throws ClassNotFoundException{
		
		person  p=new person();
		//��һ�ַ���
		Class class1=Class.forName("����ѧϰ.person");
		//�ڶ��ַ���
		Class class2=person.class;
		//�����ַ���
		Class class3=new person().getClass();
		
		System.out.println(class1==class2);
		
		System.out.println("��ȡ�����İ���---->"+class1.getPackage());
		System.out.println("��ȡ������η�---->"+class1.getModifiers());
		System.out.println("��ȡ�������(ȫ�޶�)---->"+class1.getName());
		System.out.println("��ȡ�������(����)---->"+class1.getSimpleName());
		System.out.println("��ȡ��ĸ���������---->"+class1.getSuperclass());
		
	}

}
