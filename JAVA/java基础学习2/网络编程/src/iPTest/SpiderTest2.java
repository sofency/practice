package iPTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * ��������ԭ��
 * @author sofency
 *
 */
public class SpiderTest2 {
	public static void main(String[] args) throws IOException {
		//��ȡURL
		URL url=new URL("https://www.dianping.com");//ץȡ����
		//������Դ
		//ģ���������¼
		HttpsURLConnection conn=(HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
		//����
		BufferedReader read=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		//
		String msg=null;
		while(null!=(msg=read.readLine())) {
			System.out.println(msg);
		}
		read.close();
	}
}
