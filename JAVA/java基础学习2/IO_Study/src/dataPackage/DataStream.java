package dataPackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DataStream {
	public static void main(String[] args) {
		
		
		
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);//
		
		byte[] datas=null;
		
		try {
			dos.writeUTF("");
			dos.writeBoolean(false);
			dos.writeInt(18);
			dos.writeChar('a');
			dos.flush();
		
			datas=baos.toByteArray();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(datas));
		
		try {
			String msg=dis.readUTF();
			Boolean flag=dis.readBoolean();
			int age=dis.readInt();
			char ch=dis.readChar();
			System.out.println(msg+","+flag+","+age+","+ch);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
