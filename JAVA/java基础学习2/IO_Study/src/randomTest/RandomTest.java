package randomTest;

/**
 * 分块将文件储存在不同的文件里面
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomTest {
	public static void main(String[] args) throws IOException {
		
		
		File file=new File("src/stream/CopyFile.java");
		long len=file.length();//文件的大小
		int blockSize=128;//每一块的大小
		int size=(int)Math.ceil((len*1.0/blockSize));

		System.out.println(size);
		int actualSize=(int)(blockSize>len?len:blockSize);//以防万一刚开始的实际大小大于文件的大小
		int beginSize=0;
		for(int i=0;i<size;i++) {
			beginSize=i*blockSize;
			if(i-1==size) {
				actualSize=(int)len;//将剩余量赋值给实际的大小
			}else {
				actualSize=blockSize;
				len-=actualSize;
			}
			test01(i,beginSize,actualSize,blockSize);
		}
		
	}

	
	//指出开始读取的位置读取剩下的所有内容
	public static void test01(int beginIndex) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("src/stream/CopyFile.java"), "r");
		//随机读取
		raf.seek(beginIndex);//从第二个字符开始读取
		
		//读取
		//3.操作
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			String string=new String(flush, 0, len);
			System.out.println(string);
		}
		raf.close();
	}
	
	
	//分块读取所需大小的内容

	public static void test01(int i,int beginIndex,int actualSzie,int blockSize) throws IOException {
		
		@SuppressWarnings("resource")
		RandomAccessFile rafAccessFile=new RandomAccessFile(new File("src/stream/CopyFile.java"), "r");
		RandomAccessFile raf2=new RandomAccessFile(new File("dest/"+i+"copy.java"), "rw");
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
