package com.sofency.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sofency.Entity.User;

public class ognlTest extends ActionSupport{
	
	private String uname;//������request���漴action����
	private User user=new User();
	public String getUname() {//����Ҫ������Ӧ��get����ǰ�˾��Ǹ���get�������л�ȡֵ
		return uname;
	}
	
	public User getUser() {
		return user;
	}


	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		stack.set("GirlObject", "����");//�洢��Map����
		
		
		stack.push("hello");//����ջ��
		uname = "sofency";//���Է�װ дset����
		
		user.setUserName("sophia");
		user.setUserAge("21");
		
		return "success";
	}

	
}
