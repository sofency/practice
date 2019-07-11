package java再学习;

import java.util.Scanner;

public class TestEnum {
	public static void main(String[] args) {
		
		Scanner  inScanner =new Scanner(System.in);
		System.out.println("enter a size:(SMALL,MEIDUM,LARGE,EXTRA_LARGE)");
		String inputString=inScanner.next().toUpperCase();//转化为大写
		Size size=Enum.valueOf(Size.class, inputString);//valueOf的用法 枚举的名字.class 选择的枚举参数
		System.out.println("size="+size);
		System.out.println("abbreviation="+size.getAbbreviation());
		if(size==Size.EXTRA_LARGE) {
			System.out.println("请注意这是超大号的衣服");
		}
		
		//测试values的用法
		Size[] value=Size.values();
		for(int i=0;i<value.length;i++) {
			System.out.println(value[i]+","+value[i].ordinal());//输出的是枚举类的类名  ordinal()输出的是类在枚举类中的位置
		}
		
	}
	
	enum Size{
		SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");  //抽象的理解为className("参数")
		private Size(String abbreviation) {
			this.abbreviation=abbreviation;
		}
		public String getAbbreviation() {//返回参数
			return abbreviation;
		}
		private String abbreviation;
	}

}
