package com.sofency.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sofency.Entity.User;

public class ognlTest extends ActionSupport{
	
	private String uname;//放置在request里面即action里面
	private User user=new User();
	public String getUname() {//必须要设置相应的get方法前端就是根据get方法进行获取值
		return uname;
	}
	
	public User getUser() {
		return user;
	}


	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		stack.set("GirlObject", "吴婷");//存储在Map里面
		
		
		stack.push("hello");//放入栈中
		uname = "sofency";//属性封装 写set方法
		
		user.setUserName("sophia");
		user.setUserAge("21");
		
		return "success";
	}

	
}
