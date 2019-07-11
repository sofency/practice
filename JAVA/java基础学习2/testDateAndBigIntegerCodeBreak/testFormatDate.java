package java再学习;

import java.util.Date;

/**
 * 
 * @author sofency
 * 格式化输出日期的格式用法
 *
 */
public class testFormatDate {
	public static void main(String[] args) {
		Date  date=new Date();
		String year=String.format("%tY", date);
		String month=String.format("%tB", date);//显示的是中文的月份 eg:一月  二月
		String day=String.format("%td", date);
		
		System.out.println("完整的日期是"+date);
		System.out.println("今年是"+year+"年");
		System.out.println("月份是"+month);
		System.out.println("今天是"+day+"号");
		
		
		
		
	}
}
