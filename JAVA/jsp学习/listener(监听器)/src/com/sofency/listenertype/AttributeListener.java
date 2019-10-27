package com.sofency.listenertype;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

  
	//application���������
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         String attrName=scae.getName();//Ŀǰ���ڲ�����������
         String attrValue = (String) scae.getServletContext().getAttribute(attrName);
         System.out.println("��ǰapplication�������ֵ��"+attrValue);
    }
    //application����ɾ������
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	String attrName=scae.getName();//Ŀǰ���ڲ�����������
        String attrValue = (String) scae.getServletContext().getAttribute(attrName);
        System.out.println("��ǰapplicationɾ������ֵ��"+attrValue);
    }
    //application�����滻���Ա�
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	String attrName=scae.getName();//Ŀǰ���ڲ�����������
        String attrValue = (String) scae.getServletContext().getAttribute(attrName);
        System.out.println("��ǰapplication�滻����ֵ��"+attrValue);
    }
    
    //request����ɾ������
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	String attrName=srae.getName();//Ŀǰ���ڲ�����������
        String attrValue = (String) srae.getServletRequest().getAttribute(attrName);
        System.out.println("��ǰapplicationɾ������ֵ��"+attrValue);
    }

  //request���������
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	String attrName=srae.getName();//Ŀǰ���ڲ�����������
        String attrValue = (String) srae.getServletRequest().getAttribute(attrName);
        System.out.println("��ǰapplication�������ֵ��"+attrValue);
    }

	//request�����滻����
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	String attrName=srae.getName();//Ŀǰ���ڲ�����������
        String attrValue = (String) srae.getServletRequest().getAttribute(attrName);
        System.out.println("��ǰapplication�滻����ֵ��"+attrValue);
    }

	//session�����������
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         
    	String attrName = se.getName();//��ȡ���ڲ���������
    	String attrValue = (String)se.getSession().getAttribute(attrName);
    	System.out.println("��⵽session�������ֵΪ"+attrValue);
    }

	//session����ɾ������
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName();//��ȡ���ڲ���������
    	String attrValue = (String)se.getSession().getAttribute(attrName);
    	System.out.println("��⵽sessionɾ������ֵΪ"+attrValue);
    }

	//session�����滻����
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName();//��ȡ���ڲ���������
    	String attrValue = (String)se.getSession().getAttribute(attrName);
    	System.out.println("��⵽session�滻����ֵΪ"+attrValue);
    }

}
