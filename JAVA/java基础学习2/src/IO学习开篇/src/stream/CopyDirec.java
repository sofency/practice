package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ʵ��copy�ļ���  ʹ�õݹ�
 * @author sofency
 *
 */

public class CopyDirec {
	public static void main(String[] args) {
		try {
			copyDir("test","test1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		File file=new File("12.txt");
//		System.out.println(file.isFile());
	}
	
	
	public static void copy(String source,String destination) {
		//��������Դ�ļ�
		//ѡ����
		File sourceFile=new File(source);
		File destinationFile=new File(destination);
		
		InputStream in=null;
		OutputStream out=null;
		//����
	
		try {
			//��ԭ�ļ���ȡ����
			in=new FileInputStream(sourceFile);//������
			out=new FileOutputStream(destinationFile,true);//�����
			byte[] flush=new byte[1024*1024];//�����С
			int len=-1;
			while((len=in.read(flush))!=-1) {
				System.out.println(len);
				out.write(flush,0,len);
			}
			out.flush();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(out!=null) {
				  out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(in!=null) {
				  in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
	}
	
	public static void copyDir(String src,String dest) throws IOException {
		
		File srcFile=new File(src);
		
		dest=dest+"\\"+srcFile.getName();//��src����destĿ¼��  
		
		File destFile=new File(dest);
		
		if(srcFile.isFile()) {//������ļ��򴴽��ļ� ���򴴽��ļ���
			destFile.createNewFile();
		
			copy(srcFile.getAbsolutePath(),destFile.getAbsolutePath());
			return;
			
		}else if(srcFile.isDirectory()){
			destFile.mkdirs();//�����ļ�
			
			for (File f : srcFile.listFiles()) {
				
				copyDir(f.getAbsolutePath(), destFile.getAbsolutePath());
			}
		}
	}
}
/**
 * ˼·����
 * Ŀ�꣺ָ��һ��Դ�ļ��� ��Ŀ���ļ���  ��Դ�ļ����е�����copy��Ŀ���ļ�����
 * �����Ĺ�����  
 * ���src���ļ�������   dest=dest+"\\"+src.getNames() �����ļ���  destFile.mkdir()  �������ݹ�
 * ���src���ļ�   destFile.createNewFile()   �����ļ��� copy�ļ�   ע��Ҫʹ�þ���·��
 * 
 */
