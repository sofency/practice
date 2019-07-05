package 员工管理系统1;

public class Test {
	
	public static void main(String[] args) {
		ServiceImpl carryService=new ServiceImpl();
		//展示功能选择窗口
		carryService.showChoice();
		//功能选择
		switch (carryService.ChooseChoice()) {
		case 1:
			carryService.resultAllSearch();
			break;
		case 2:
			carryService.ResultSearch();
			break;
		case 3:
			carryService.ResultInsert();
		default:
			break;
		}
	}
}
