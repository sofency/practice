package changeStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 */
public class ConventTest2 {
	public static void main(String[] args) {

		BufferedReader in=null;
		BufferedWriter out=null;
		try {
		    in=new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"));//需要制定正确的字符集
		    out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("code.html")),"UTF-8"));
			String temp;
			while((temp=in.readLine())!=null) {
				out.write(temp);
				out.newLine();
			}
			out.flush();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

}
