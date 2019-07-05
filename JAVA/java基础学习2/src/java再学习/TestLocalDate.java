package java再学习;

import java.time.LocalDate;

public class TestLocalDate {
	public static void main(String[] args) {
		LocalDate localDate=LocalDate.now();//获取当前的时间
		System.out.println("当前的年份是："+localDate.getYear());
		System.out.println("当前的月份是："+localDate.getMonth());//返回的是英文的月份
		System.out.println("当前的日："+localDate.getDayOfMonth());
		
		
		System.out.println("当前时间加上1000天后的日期");
		LocalDate aThousandDate=localDate.plusDays(1000);
		System.out.println("1000天后年份是："+aThousandDate.getYear());
		System.out.println("1000天后月份是："+aThousandDate.getMonth());
		System.out.println("1000天后日："+aThousandDate.getDayOfMonth());
		
		//设置特定的日期
		LocalDate passDate=LocalDate.of(1998, 01, 20);
		
		System.out.println(passDate.getMonth());//自动设置日期
		
	}
}
