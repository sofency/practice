package printStream;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintTest {
	public static void main(String[] args) {
		
		//��ӡ��
		
		PrintStream ps=System.out;
		ps.println("��ӡ��");
		ps.println("sofency");
		
		try {// ������  ������         �����  ������
			ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("file.txt")),true);
			
			ps.println("hello world");
			ps.println("sofency");
			
			
            //�ض��������
			System.setOut(ps);//����������õ�ps����
			System.out.println("change");
			
			//�ض���������
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
			System.out.println("i am backing..");
			
			
			ps.flush();
			ps.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
