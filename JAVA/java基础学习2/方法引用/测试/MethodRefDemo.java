package ��������.����;

public class MethodRefDemo {
	
	 public static String stringOp(StringFunc sf, String s) {//��StringFunc ���˽� ���ܵĽӿ�ָ��MyStringOps�е�strReverse���ܵ�����
	        return sf.func(s);
	 }
	 
	 public static void main(String[] args) {
        String inStr = "lambda add power to Java";
        //MyStringOps::strReverse �൱��ʵ���˽ӿڷ���func() 
        // ���ڽӿڷ���func()������MyStringOps.strReverse()����
         String outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println("Original string: " + inStr);
        System.out.println("String reserved: " + outStr);
	  }
}
