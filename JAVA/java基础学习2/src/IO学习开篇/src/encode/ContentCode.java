package encode;

import java.io.UnsupportedEncodingException;

public class ContentCode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msgString="姓名生命使命q";
		byte[] datas=msgString.getBytes();//默认使用工程的字符集
		//将字符转化为字节  称为编码
		System.out.println(datas.length);
	
		datas=msgString.getBytes("utf8");//默认每个字符都是三个字节  如果字符编码不统一会乱码
		System.out.println(datas.length);
		//解码：将字节转化为字符	
//		msgString=new String(datas,0,9,"utf8");
//		System.out.println(msgString);
		msgString=new String(datas,0,datas.length-4,"utf8");
		System.out.println(msgString);
		
		
	}

}
