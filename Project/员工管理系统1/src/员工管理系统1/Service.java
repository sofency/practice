package 员工管理系统1;

public interface Service {
//展示功能选择
	public void showChoice();
//选择功能
	public int ChooseChoice();
//业务层处理相应的业务
	public void resultAllSearch();
//根据员工编号查询结果
	public void ResultSearch();
//向表中插入数据
	public void ResultInsert();

}
