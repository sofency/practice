package createDirectory;

import java.io.File;

/**
 * mkdir() ȷ���ϼ�Ŀ¼����
 * mkdirs() �ϼ�Ŀ¼������  �ȴ����ϼ�Ŀ¼
 * @author sofency
 *
 */
public class CreateFile {
	public static void main(String[] args) {
		
		File file =new File("H:\\eclipse_workspace\\IOѧϰ��ƪ\\dir\\test");
		
		boolean flag=file.mkdir();//����ʧ��
		System.out.println(flag);
		
		flag=file.mkdirs();//�����ɹ�
		System.out.println(flag);
	}

}
