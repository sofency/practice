package Ա������ϵͳ1;

public class Test {
	
	public static void main(String[] args) {
		ServiceImpl carryService=new ServiceImpl();
		//չʾ����ѡ�񴰿�
		carryService.showChoice();
		//����ѡ��
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
