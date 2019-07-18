package webServer;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	//准备一个用于添加xml数据的集合 调用Girl类
	private List<Girl> girls;
	private Girl girl;
	private String tag;
	
	public List<Girl> getGirls() {
		return girls;
	}
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("开始解析xml文件");
		girls=new ArrayList<Girl>();
		
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, 
			Attributes attributes) throws SAXException {
		
		super.startElement(uri, localName, qName, attributes);//qName指的是girl  即总标签内部的字标签
		//解析开始
		System.out.println(qName+"--->解析开始");
		tag=qName;
		if("girl".equals(qName)) {
			girl=new Girl();
		}
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		//解析结点结束
		System.out.println(qName+"--->解析结点结束");
		if("girl".equals(qName)) {
			girls.add(girl);
		}
		tag="";///重要的一步  因为内容解析时会把换行字符也进行解析
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		
		if(!tag.equals("")) {
			
			//这里是内容 但是无法判断属于哪一个元素
			String string=new String(ch,start,length);
			System.out.println("character===="+string);
			if("name".equals(tag)) {
				girl.setName(string);
			}else if("age".equals(tag)){
				girl.setAge(string);
			}
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("解析xml文件结束");
	}
	
	
	
}
