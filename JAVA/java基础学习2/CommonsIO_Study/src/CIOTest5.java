import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * ����
 * @author sofency
 *
 */
public class CIOTest5 {

	public static void main(String[] args) throws IOException  {
		//�����ļ�
		//FileUtils.copyFile(new File("test.txt"), new File("test-copy.txt"));
		//�����ļ���Ŀ¼
		//FileUtils.copyFileToDirectory(new File("test.txt"), new File("txt"));
		//����Ŀ¼��Ŀ¼
		
		//FileUtils.copyDirectoryToDirectory(new File("txt"), new File("txt-copy"));
		//����Ŀ¼
		//FileUtils.copyDirectory(new File("txt"), new File("txt1"));  //��ԭ���ļ����µ����ݸ��Ƶ����ڵ��ļ�����
	
		//����url�������Դ�������ļ�
		String urlString="http://pic37.nipic.com/20140113/8800276_184927469000_2.png";
		
		//FileUtils.copyURLToFile(new URL(urlString), new File("horse.png"));
	
		
		String data=IOUtils.toString(new URL("http://www.163.com"), "GBK");
		System.out.println(data);
	}
}
