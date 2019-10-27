package com.sofency.listenertype;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

  
	//application中添加属性
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         String attrName=scae.getName();//目前正在操作的属性名
         String attrValue = (String) scae.getServletContext().getAttribute(attrName);
         System.out.println("当前application添加属性值是"+attrValue);
    }
    //application里面删除属性
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	String attrName=scae.getName();//目前正在操作的属性名
        String attrValue = (String) scae.getServletContext().getAttribute(attrName);
        System.out.println("当前application删除属性值是"+attrValue);
    }
    //application里面替换属性表
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	String attrName=scae.getName();//目前正在操作的属性名
        String attrValue = (String) scae.getServletContext().getAttribute(attrName);
        System.out.println("当前application替换属性值是"+attrValue);
    }
    
    //request里面删除属性
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	String attrName=srae.getName();//目前正在操作的属性名
        String attrValue = (String) srae.getServletRequest().getAttribute(attrName);
        System.out.println("当前application删除属性值是"+attrValue);
    }

  //request中添加属性
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	String attrName=srae.getName();//目前正在操作的属性名
        String attrValue = (String) srae.getServletRequest().getAttribute(attrName);
        System.out.println("当前application添加属性值是"+attrValue);
    }

	//request里面替换属性
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	String attrName=srae.getName();//目前正在操作的属性名
        String attrValue = (String) srae.getServletRequest().getAttribute(attrName);
        System.out.println("当前application替换属性值是"+attrValue);
    }

	//session里面添加属性
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         
    	String attrName = se.getName();//获取正在操作的属性
    	String attrValue = (String)se.getSession().getAttribute(attrName);
    	System.out.println("检测到session添加属性值为"+attrValue);
    }

	//session里面删除属性
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName();//获取正在操作的属性
    	String attrValue = (String)se.getSession().getAttribute(attrName);
    	System.out.println("检测到session删除属性值为"+attrValue);
    }

	//session里面替换属性
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName();//获取正在操作的属性
    	String attrValue = (String)se.getSession().getAttribute(attrName);
    	System.out.println("检测到session替换属性值为"+attrValue);
    }

}
