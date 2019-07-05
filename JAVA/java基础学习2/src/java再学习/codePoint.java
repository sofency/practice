package java再学习;

public class codePoint {
	public static void main(String[] args) {
		String string="hello";
		int  n=string.length();//获取字符串的长度
		
		System.out.println(n);//码点的理解 对于字符串的长度而言 有些字符可能无法使用两个unicode进行表示而扩重字编码形式
		int cpCount=string.codePointCount(0,n);
		int aCount=string.codePointAt(1);
		System.out.println(string.charAt(1)+","+cpCount);
		System.out.println(aCount);
		
	}

}
