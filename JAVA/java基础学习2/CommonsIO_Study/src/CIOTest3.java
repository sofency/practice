import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * ��ȡ����
 * @author sofency
 *
 */
public class CIOTest3 {

	public static void main(String[] args) throws IOException {
		//��ȡ�ļ�
		
		String msg=FileUtils.readFileToString(new File("test.txt"),"GBK");
		System.out.println(msg);
		
		//��ȡת��Ϊ�ֽ�����
		byte[] datas=FileUtils.readFileToByteArray(new File("test.txt"));
		System.out.println(datas.length);
		
		
		///���ж�ȡ
		List<String> msgStrings=FileUtils.readLines(new File("test.txt"),"GBK");
		
		for (String string : msgStrings) {
			System.out.println(string);
		}
		
		//���������ж�ȡ
		LineIterator iterator=FileUtils.lineIterator(new File("test.txt"),"GBK");
		while (iterator.hasNext()) {
			System.out.println(iterator.nextLine());
		}
	}
}
