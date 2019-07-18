package iPTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 网络爬虫原理
 * @author sofency
 *
 */
public class SpiderTest {
	public static void main(String[] args) throws IOException {
		//获取URL
		URL url=new URL("https://www.dianping.com");//抓取不了
		//下载资源
		InputStream iStream=url.openStream();//打开流
		//分析
		BufferedReader read=new BufferedReader(new InputStreamReader(iStream,"UTF-8"));
		//
		String msg=null;
		while(null!=(msg=read.readLine())) {
			System.out.println(msg);
		}
		read.close();
	}
}
