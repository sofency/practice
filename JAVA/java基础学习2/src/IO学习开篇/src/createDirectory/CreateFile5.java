package createDirectory;

import java.io.File;

import javax.naming.directory.DirContext;

/**
 * ʹ���������鿴�ļ��Ĵ�С
 * �ݹ�鿴�ļ��Ĵ�С
 * @author sofency
 *
 */
public class CreateFile5 {
	public static void main(String[] args) {
		//�ݹ��ӡ�����ļ�
		countFIle file=new countFIle("H:\\eclipse_workspace\\IOѧϰ��ƪ");
		System.out.println(file.getSize());
		
		
		
		countFIle file1=new countFIle("H:\\eclipse_workspace\\IOѧϰ��ƪ\\src");
		System.out.println(file1.getSize());//ͳ�Ƹ��ļ��Ĵ�С
		System.out.println(file1.getNumFile());//ͳ�Ƹ��ļ����ļ�����Ŀ
	}
	

}

class countFIle{
	private String pathFile;//�ļ���·��
	private long size;//�ļ��Ĵ�С
	private File srcFile;//Դ�ļ�
	private int numDir;
	private int numFile;
	
	
	public int getNumDir() {
		return numDir;
	}

	public int getNumFile() {
		return numFile;
	}

	//ͳ���ļ��Ķ���  ͳ���ļ��еĶ���
	public long getSize() {
		return size;
	}

	public countFIle(String pathFile) {
		super();
		this.pathFile = pathFile;
		this.srcFile=new File(pathFile);//��ȡԴ�ļ�
		Count(srcFile);//�����ļ��Ĵ�С
	}
	
	private  void Count(File file) {
		//��ȡ��С
		if(file.exists()&&file!=null) {
			if(file.isFile()) {//������ļ��Ļ����ļ��Ĵ�С��size�ۼ�
				size+=file.length();
				this.numFile++;
			}else {
				this.numDir++;
				for (File src : file.listFiles()) {//
					Count(src);
				}
			}
		}
	}
}