package iPTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * ��������ԭ��
 * @author sofency
 *
 */
public class SpiderTest {
	public static void main(String[] args) throws IOException {
		//��ȡURL
		URL url=new URL("https://www.dianping.com");//ץȡ����
		//������Դ
		InputStream iStream=url.openStream();//����
		//����
		BufferedReader read=new BufferedReader(new InputStreamReader(iStream,"UTF-8"));
		//
		String msg=null;
		while(null!=(msg=read.readLine())) {
			System.out.println(msg);
		}
		read.close();
	}
}
