package randomTest;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 分块将文件储存在不同的文件里面
 * 使用序列流
 *  
 */

public class SplitFile2 {
	private  File src;//源文件  目标切割文件
	private String dest;//目标存储文件
	private List<File> destString;//目标存储文件夹
	private int blockSize;//每块的大小
	private int size;//块数
	
	private  void  init() {
		long len =this.src.length();//文件的大小
		//每块的大小
		int blockSize=128;
		//块数
		this.size=(int)Math.ceil(len*1.0/blockSize);
		//路径
		for(int i=0;i<this.size;i++) {
			this.destString.add(new File(this.dest+"/"+i+this.src.getName()));//名字然后再根据这名字进行新建文件
		}
	}
	
	
	public SplitFile2(String StringPath, String dest, int blockSize) {
		super();
		this.src = new File(StringPath);
		this.dest = dest;
		this.blockSize = blockSize;
		this.destString=new ArrayList<File>();
		init();
	}


	public void split() throws IOException {
		
		long len=this.src.length();//长度
		int beginIndex=0;//开始的顶点
		int actualSize=(int)(this.blockSize>len?this.blockSize:len);
		for (int i = 0; i < this.size; i++) {
			beginIndex=i * this.blockSize;//每一页开始的顶点
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
	 *  将散列的文件 合并到一个文件中
	 * @param i
	 * @param beginIndex
	 * @param actualSzie
	 * @param blockSize
	 * @throws IOException
	 */
	
	public void merge(String destPath) throws IOException {
		//输出流 写入流
		try {
			OutputStream oS=new BufferedOutputStream(new FileOutputStream(new File(destPath),true));
			
			
			Vector<InputStream> vector=new  Vector<InputStream>();//设置序列流
			
			SequenceInputStream sis=null;  //由原来需要创建多个输入流  转化成一个序列流
			//输入流  写出流
			for(int i=0;i<destString.size();i++) {
				vector.add(new BufferedInputStream(new FileInputStream(destString.get(i))));//得出的就是文件
			}	
			sis=new SequenceInputStream(vector.elements());//将所有的流通过序列化整合到一起
			
			byte[] flush=new byte[5];//缓冲器
			int len=-1;
			while((len=sis.read(flush))!=-1) {
				oS.write(flush,0,len);
			}
			oS.flush();
			sis.close();
			oS.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}
	
	
	
	
	//分块读取所需大小的内容

	private  void test01(int i,int beginIndex,int actualSzie,int blockSize) throws IOException {
		
		@SuppressWarnings("resource")
		RandomAccessFile rafAccessFile=new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2=new RandomAccessFile(this.destString.get(i), "rw");
		rafAccessFile.seek(beginIndex);//开始读取文件的位置
		
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
