import java.io.File;

import org.apache.commons.io.FileUtils;

public class CIOTest01 {

	public static void main(String[] args) {
		
		//�ļ��Ĵ�С
		long len=FileUtils.sizeOf(new File("sofency.java"));
		System.out.println(len);
		
		//Ŀ¼�Ĵ�С  ֮ǰҪʹ�õݹ�
		len=FileUtils.sizeOf(new  File("H:\\eclipse_workspace"));
		System.out.println(len);
	}
}
