package randomTest;

/**
 * �ֿ齫�ļ������ڲ�ͬ���ļ�����
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomTest {
	public static void main(String[] args) throws IOException {
		
		
		File file=new File("src/stream/CopyFile.java");
		long len=file.length();//�ļ��Ĵ�С
		int blockSize=128;//ÿһ��Ĵ�С
		int size=(int)Math.ceil((len*1.0/blockSize));

		System.out.println(size);
		int actualSize=(int)(blockSize>len?len:blockSize);//�Է���һ�տ�ʼ��ʵ�ʴ�С�����ļ��Ĵ�С
		int beginSize=0;
		for(int i=0;i<size;i++) {
			beginSize=i*blockSize;
			if(i-1==size) {
				actualSize=(int)len;//��ʣ������ֵ��ʵ�ʵĴ�С
			}else {
				actualSize=blockSize;
				len-=actualSize;
			}
			test01(i,beginSize,actualSize,blockSize);
		}
		
	}

	
	//ָ����ʼ��ȡ��λ�ö�ȡʣ�µ���������
	public static void test01(int beginIndex) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("src/stream/CopyFile.java"), "r");
		//�����ȡ
		raf.seek(beginIndex);//�ӵڶ����ַ���ʼ��ȡ
		
		//��ȡ
		//3.����
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			String string=new String(flush, 0, len);
			System.out.println(string);
		}
		raf.close();
	}
	
	
	//�ֿ��ȡ�����С������

	public static void test01(int i,int beginIndex,int actualSzie,int blockSize) throws IOException {
		
		@SuppressWarnings("resource")
		RandomAccessFile rafAccessFile=new RandomAccessFile(new File("src/stream/CopyFile.java"), "r");
		RandomAccessFile raf2=new RandomAccessFile(new File("dest/"+i+"copy.java"), "rw");
		rafAccessFile.seek(beginIndex);//��ʼ��ȡ�ļ���λ��
		
		byte[] flush=new  byte[blockSize];
		int len=-1;
		while((len=rafAccessFile.read(flush))!=-1) {
			
			if(actualSzie>len) {
				
				raf2.write(flush);
				actualSzie-=len;
			}else {
				raf2.write(flush);
				break;
			}
		}
	}
}
