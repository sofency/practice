package 反射学习;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author sofency
 * 反射学习
 *    1.获取类对象   Class.forName("类的全限定路径")；
 *    2.创建类对象的方法 
 *    3.接受类对象的方法
 */
public class testReflect {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException ,IllegalArgumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
	  //反射操作类属性
		
		//operField();
//		getCla();
		//getField();
		operMethod();
	}
	
	
	//操作方法
	public static void operMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//获取类对象
		Class class1=Class.forName("反射学习.student");
		//获取类方法
		System.out.println("--------获取所有的类和方法（上树到object）----------");
		Method[]  msMethods=class1.getMethods();
		for (Method method : msMethods) {
			System.out.println(method.getName());
		}
		System.out.println("---------获取自己声明的方法----------");
		Method[] methods=class1.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
 		
		//使用反射调用静态的方法
		Method m1=class1.getDeclaredMethod("sHi", String.class);
		m1.invoke(null, "吴婷");
		//使用反射调用非静态的方法
		Object object=class1.newInstance();
		Method m2=class1.getDeclaredMethod("sHi");//第一个属性是类的名字 后面是传入的参数
		m2.invoke(object);//第一个参数是实例化类对象
	}
	
	
	
	public static void operField() throws ClassNotFoundException{
		//获取类对象
		Class cla=Class.forName("反射学习.student");
		//获取反射类的及其左右父类的公共字段属性
		Field[] fields=cla.getFields();
		
		for (Field field : fields) {
			System.out.println("获取属性名-----"+field.getName());
			System.out.println("获取类的修饰符---->"+field.getType());//返回类型的类对象
		}
		
		//获取指定的字段
		//Field f=cla.getFieled("字段名")； 然后再使用f.getName()显示属性名
		//Field f2=cla.getDeclaredField("字段名") //指定获取类的所有字段  私有的和公共的都可以进行操作
		//Field f3=cla.getSuperclass().getDeclaredField("字段名")获取父类声明的字段
		
		//操作静态属性值
		//操作字段值
		//Field fs=cla.getDeclaredField("字段名");
		//获取静态字段名的属性值
		//System.out.println(fs.get(null));
		
		//操作非静态属性值
		//Field fd=cla.getDeclaredField("字段名");
		//System.out.println(fd.get(cla.newInstance()));
		
		
	}
	public static void getField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		System.out.println("-----------操作静态属性------------");
		Class cla=Class.forName("反射学习.student");//全限定路径
		Field f=cla.getDeclaredField("money");//获取属性
		//获取静态属性的字段和属性值
		System.out.println(f.getName());//显示字段名字没有获取到字段的值
		System.out.println("-----------更换静态属性值前------------");
		System.out.println(f.get(null)); //获取静态属性值
		
		//更换静态属性的值
		System.out.println("-----------更换静态属性值后------------");
		f.set(null, 2000);
		System.out.println(f.get(null)); //获取静态属性值
		
		//获取父类的所有属性
		System.out.println("----------获取父类的所有属性------------");
		Field[] f1=cla.getSuperclass().getDeclaredFields();
		for (Field field : f1) {
			System.out.println(field.getName());
		}
		
		//操作非静态属性值  cla.newInstance 返回该对象的实例化对象
		                  // 也就是创建对象 因为每个对象都可以操作默认的属性值
		System.out.println("----------获取非静态的属性值---------------");
		Field f2=cla.getDeclaredField("nameString");
		Object object=cla.newInstance();
		System.out.println("----------操作非静态属性前----------");
		System.out.println(f2.get(object));
		System.out.println("----------操作非静态属性后--------------");
		f2.set(object, "吴婷婷");
		System.out.println(f2.get(object));
		
		//猜测能否操作私有属性  
		//得出结果无法操作私有属性
		
//		Field field3=cla.getDeclaredField("ssex");
//		System.out.println(field3.get(cla.newInstance()));  因为返回的是对象 所以无法操作私有属性
		
		//暴力反射操作私有化属性
		Field f3=cla.getDeclaredField("ssex");
		f3.setAccessible(true);//暴力反射 操作私有化属性不安全
		Object object2=cla.newInstance();//获取实例化对象
		System.out.println(f3.get(object2));	
	}
	public static void getCla() throws ClassNotFoundException{
		
		person  p=new person();
		//第一种方法
		Class class1=Class.forName("反射学习.person");
		//第二种方法
		Class class2=person.class;
		//第三种方法
		Class class3=new person().getClass();
		
		System.out.println(class1==class2);
		
		System.out.println("获取类对象的包名---->"+class1.getPackage());
		System.out.println("获取类的修饰符---->"+class1.getModifiers());
		System.out.println("获取类的名称(全限定)---->"+class1.getName());
		System.out.println("获取类的名称(类名)---->"+class1.getSimpleName());
		System.out.println("获取类的父类的类对象---->"+class1.getSuperclass());
		
	}

}
