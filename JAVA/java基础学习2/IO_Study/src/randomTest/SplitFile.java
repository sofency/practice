package randomTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
/**
 * �ֿ齫�ļ������ڲ�ͬ���ļ�����
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class SplitFile {
	private  File src;//Դ�ļ�  Ŀ���и��ļ�
	private String dest;//Ŀ��洢�ļ�
	private List<File> destString;//Ŀ��洢�ļ���
	private int blockSize;//ÿ��Ĵ�С
	private int size;//����
	
	private  void  init() {
		long len =this.src.length();//�ļ��Ĵ�С
		//ÿ��Ĵ�С
		int blockSize=128;
		//����
		this.size=(int)Math.ceil(len*1.0/blockSize);
		//·��
		for(int i=0;i<this.size;i++) {
			this.destString.add(new File(this.dest+"/"+i+this.src.getName()));//����Ȼ���ٸ��������ֽ����½��ļ�
		}
	}
	
	
	public SplitFile(String StringPath, String dest, int blockSize) {
		super();
		this.src = new File(StringPath);
		this.dest = dest;
		this.blockSize = blockSize;
		this.destString=new ArrayList<File>();
		init();
	}


	public void split() throws IOException {
		
		long len=this.src.length();//����
		int beginIndex=0;//��ʼ�Ķ���
		int actualSize=(int)(this.blockSize>len?this.blockSize:len);
		for (int i = 0; i < this.size; i++) {
			beginIndex=i * this.blockSize;//ÿһҳ��ʼ�Ķ���
			if(this.size-1==i) {
				actualSize=(int)len;
			}else{
				actualSize=this.blockSize;
				len -= actualSize;
			}
			this.test01(i, beginIndex, actualSize, this.blockSize);
		}
	}
	
	/**
	 *  ��ɢ�е��ļ� �ϲ���һ���ļ���
	 * @param i
	 * @param beginIndex
	 * @param actualSzie
	 * @param blockSize
	 * @throws IOException
	 */
	
	public void merge(String destPath) throws IOException {
		//����� д����
		try {
			OutputStream oS=new BufferedOutputStream(new FileOutputStream(new File(destPath),true));
			
			//������  д����
			for(int i=0;i<destString.size();i++) {
				InputStream in=new BufferedInputStream(new FileInputStream(destString.get(i)));//�ó��ľ����ļ�
				
				
				byte[] flush=new byte[5];//������
				int len=-1;
				while((len=in.read(flush))!=-1) {
					oS.write(flush,0,len);
				}
				oS.flush();
				in.close();
			}	
			oS.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}
	
	
	
	
	//�ֿ��ȡ�����С������

	private  void test01(int i,int beginIndex,int actualSzie,int blockSize) throws IOException {
		
		@SuppressWarnings("resource")
		RandomAccessFile rafAccessFile=new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2=new RandomAccessFile(this.destString.get(i), "rw");
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
