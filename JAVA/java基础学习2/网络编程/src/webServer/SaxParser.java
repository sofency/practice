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
			//创建解析工厂
			SAXParserFactory  saxParserFactory=SAXParserFactory.newInstance();
			//获取解析器
			SAXParser saxParser=saxParserFactory.newSAXParser();
//			调用方法进行解析xml文件
			File file=new File("H:\\eclipse_workspace\\多线程\\src\\webserver\\girl.xml");
			MyHandler dh=new MyHandler();
			saxParser.parse(file, dh);
			List<Girl> girls=dh.getGirls();
			//输出集合
			System.out.println(girls);
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
