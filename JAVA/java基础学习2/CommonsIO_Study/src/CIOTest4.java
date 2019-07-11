import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 写入内容
 * @author sofency
 *
 */
public class CIOTest4 {

	public static void main(String[] args) throws IOException  {
	   FileUtils.write(new File("hello.txt"), "我是一个小老虎\n","GBK");
	   FileUtils.writeStringToFile(new File("hello.txt"), "又来一个小老虎\n","GBK",true);
	   
	   FileUtils.writeByteArrayToFile(new File("hello.txt"), "它一个小老虎\n".getBytes("GBK"),true);//内部自动实现字节数组向String的转化
	
	
	   //写出列表
	   
	   List<String> dataStrings=new ArrayList<String>();
	   dataStrings.add("sofency");
	   dataStrings.add("alice");
	   dataStrings.add("ahoj");
	   
	   FileUtils.writeLines(new File("test.txt"), dataStrings,"----",true);//向文件中写入列表
	
	}
}
