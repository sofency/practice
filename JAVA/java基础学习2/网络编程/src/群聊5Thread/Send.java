package х╨ад5Thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
	private BufferedReader buf;
	private DataOutputStream doS;
	private boolean flag=true;
	private String name;
	public Send(Socket client,String name) {
		this.name=name;
		buf=new BufferedReader(new InputStreamReader(System.in));
		try {
			doS= new  DataOutputStream(client.getOutputStream());
			send(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		
		try {
			doS.writeUTF(msg);
			doS.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			try {
				doS.close();
				buf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				flag=false;
				e.printStackTrace();
				System.out.println("error");
			}
		}
	}
	
	
	public  String receive() {
		
		String msg = "";
		try {
			msg = buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
		
	}
	@Override
	public void run() {
		while (flag) {
			String string=receive();
			send(string);
		}
	}
}
