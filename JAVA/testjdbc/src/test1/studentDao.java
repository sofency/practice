package test1;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class studentDao {
	
	public static void main(String[] args) {
		//����testSelect����
		testSelect tSelect=new testSelect();
		ArrayList<stu> list=tSelect.getStudentInfo();//����stu�������б�
		for (stu stu : list) {
			System.out.println(stu);
		}
	}
	
	
	

}
