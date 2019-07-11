import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * 拷贝
 * @author sofency
 *
 */
public class CIOTest5 {

	public static void main(String[] args) throws IOException  {
		//复制文件
		//FileUtils.copyFile(new File("test.txt"), new File("test-copy.txt"));
		//复制文件到目录
		//FileUtils.copyFileToDirectory(new File("test.txt"), new File("txt"));
		//复制目录到目录
		
		//FileUtils.copyDirectoryToDirectory(new File("txt"), new File("txt-copy"));
		//复制目录
		//FileUtils.copyDirectory(new File("txt"), new File("txt1"));  //将原来文件夹下的内容复制到现在的文件夹下
	
		//复制url上面的资源到本地文件
		String urlString="http://pic37.nipic.com/20140113/8800276_184927469000_2.png";
		
		//FileUtils.copyURLToFile(new URL(urlString), new File("horse.png"));
	
		
		String data=IOUtils.toString(new URL("http://www.163.com"), "GBK");
		System.out.println(data);
	}
}
