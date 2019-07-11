import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * д������
 * @author sofency
 *
 */
public class CIOTest4 {

	public static void main(String[] args) throws IOException  {
	   FileUtils.write(new File("hello.txt"), "����һ��С�ϻ�\n","GBK");
	   FileUtils.writeStringToFile(new File("hello.txt"), "����һ��С�ϻ�\n","GBK",true);
	   
	   FileUtils.writeByteArrayToFile(new File("hello.txt"), "��һ��С�ϻ�\n".getBytes("GBK"),true);//�ڲ��Զ�ʵ���ֽ�������String��ת��
	
	
	   //д���б�
	   
	   List<String> dataStrings=new ArrayList<String>();
	   dataStrings.add("sofency");
	   dataStrings.add("alice");
	   dataStrings.add("ahoj");
	   
	   FileUtils.writeLines(new File("test.txt"), dataStrings,"----",true);//���ļ���д���б�
	
	}
}
