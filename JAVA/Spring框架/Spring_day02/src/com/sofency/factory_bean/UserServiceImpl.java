package com.sofency.factory_bean;

public class UserServiceImpl implements UserService {
	/* (non-Javadoc)
	 * @see com.sofency.factory_bean.UserService#addUser()
	 */
	@Override
	public void addUser() {
		System.out.println("添加用户");
	}
	
	/* (non-Javadoc)
	 * @see com.sofency.factory_bean.UserService#deleteUser()
	 */
	@Override
	public void deleteUser() {
		System.out.println("删除用户");
	}

}
