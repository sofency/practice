package webServer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxParser {
	public static void main(String[] args) {
		
		try {
			//������������
			SAXParserFactory  saxParserFactory=SAXParserFactory.newInstance();
			//��ȡ������
			SAXParser saxParser=saxParserFactory.newSAXParser();
//			���÷������н���xml�ļ�
			File file=new File("H:\\eclipse_workspace\\���߳�\\src\\webserver\\girl.xml");
			MyHandler dh=new MyHandler();
			saxParser.parse(file, dh);
			List<Girl> girls=dh.getGirls();
			//�������
			System.out.println(girls);
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
