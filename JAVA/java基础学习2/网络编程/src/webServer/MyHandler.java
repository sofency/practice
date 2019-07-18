package webServer;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	//׼��һ���������xml���ݵļ��� ����Girl��
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
		System.out.println("��ʼ����xml�ļ�");
		girls=new ArrayList<Girl>();
		
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, 
			Attributes attributes) throws SAXException {
		
		super.startElement(uri, localName, qName, attributes);//qNameָ����girl  ���ܱ�ǩ�ڲ����ֱ�ǩ
		//������ʼ
		System.out.println(qName+"--->������ʼ");
		tag=qName;
		if("girl".equals(qName)) {
			girl=new Girl();
		}
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		//����������
		System.out.println(qName+"--->����������");
		if("girl".equals(qName)) {
			girls.add(girl);
		}
		tag="";///��Ҫ��һ��  ��Ϊ���ݽ���ʱ��ѻ����ַ�Ҳ���н���
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		
		if(!tag.equals("")) {
			
			//���������� �����޷��ж�������һ��Ԫ��
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
		System.out.println("����xml�ļ�����");
	}
	
	
	
}
