package iPTest;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL��ͳһ��Դ��λ��  �����������ʯ֮һ��html http��������Դ
 * 1.Э��
 * 2.���� �����
 * 3.�˿� ��Ĭ��80
 * 4.������Դ
 * http://www.baidu.com:80/index.html?usrname=sofency&age=18#a  #����ê��
 * @author sofency
 *
 */
public class URLTest {

	public static void main(String[] args) throws MalformedURLException {
		URL url=new URL("http://www.baidu.com:80/index.html?usrname=sofency&age=18#a");
		
		//��ȡ�ĸ�ֵ
		
		System.out.println("Э�飺"+url.getProtocol());
		System.out.println("������"+url.getHost());
		System.out.println("�˿ڣ�"+url.getPort());
		System.out.println("������Դ: "+url.getFile());
		System.out.println("������Դ2: "+url.getPath());
		
		
		//����
		System.out.println("������"+url.getQuery());
		//ê��
		System.out.println("ê�㣺"+url.getRef());
		
		
	}
}
