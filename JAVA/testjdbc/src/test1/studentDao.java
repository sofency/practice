package test1;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class studentDao {
	
	public static void main(String[] args) {
		//创建testSelect对象
		testSelect tSelect=new testSelect();
		ArrayList<stu> list=tSelect.getStudentInfo();//创建stu的数据列表
		for (stu stu : list) {
			System.out.println(stu);
		}
	}
	
	
	

}
