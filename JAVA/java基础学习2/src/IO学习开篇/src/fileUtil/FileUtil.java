package fileUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * 实现功能的封装
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void main(String[] args) {
		
		try {
			InputStream inputStream=new FileInputStream("hha.txt");
			OutputStream outputStream=new FileOutputStream("hha-copy.txt");
			copy(inputStream, outputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		//将图片写到字节数组中
		InputStream in=null;
		ByteArrayOutputStream baos=null;
		try {
			in = new FileInputStream("copy.jpg");
			baos=new ByteArrayOutputStream();
			copy(in, baos);//将图片写到字节数组中
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//将字节数组写到输出流中
		try {
			InputStream is= new ByteArrayInputStream(baos.toByteArray());//将字符数组输入到文件中
		    OutputStream os=new FileOutputStream("p-copy.jpg");
		    copy(is, os);
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		
	}
	
	/**
	 * 
	 * @param in
	 * @param out
	 */
	public static void copy(InputStream in,OutputStream out) {//传入输入流，传入输出流
	    //3.操作
		try/*(in;out)*/ {//这种写法只能在1.9以上才能使用  这样做的目的是释放掉流
			byte[] flush=new byte[1024*1024];//缓冲大小
			int len=-1;//
			while((len=in.read(flush))!=-1) {
				out.write(flush,0,len);
			}
			out.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(out!=null) {
				  out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(in!=null) {
				  in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}

	}
	
	
	public static void close(InputStream is,OutputStream os) {
		try {
			if(null!=os) {
				os.close();
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			if(null!=is) {
				is.close();
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//释放资源
	public static void close(Closeable ... ios) {
		for (Closeable io : ios) {
			try {
				if(io!=null) {
					io.close();
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}

}
