package 方法引用.测试;

public class MyStringOps {
	//静态方法反转字符串
	public static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
