import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * 读取内容
 * @author sofency
 *
 */
public class CIOTest3 {

	public static void main(String[] args) throws IOException {
		//读取文件
		
		String msg=FileUtils.readFileToString(new File("test.txt"),"GBK");
		System.out.println(msg);
		
		//读取转化为字节数组
		byte[] datas=FileUtils.readFileToByteArray(new File("test.txt"));
		System.out.println(datas.length);
		
		
		///逐行读取
		List<String> msgStrings=FileUtils.readLines(new File("test.txt"),"GBK");
		
		for (String string : msgStrings) {
			System.out.println(string);
		}
		
		//迭代器逐行读取
		LineIterator iterator=FileUtils.lineIterator(new File("test.txt"),"GBK");
		while (iterator.hasNext()) {
			System.out.println(iterator.nextLine());
		}
	}
}
