package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 1.��һ����������������
 * @author sofency
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 */
public class IOStream {
	public static void main(String[] args) throws FileNotFoundException {
		//����Դ
		File src=new File("test.txt");
		//ѡ����
		InputStream  is=null;
		//����
		int temp;
		try {
			is=new FileInputStream(src);
			while((temp=is.read())!=-1) {//�Ƚ�is.read()��ֵ��temp Ȼ��temp��-1���бȽ�
				System.out.print((char)temp);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
