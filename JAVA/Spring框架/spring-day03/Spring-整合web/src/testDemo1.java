import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sofency.transferService.transfer;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class testDemo1 {
	//����junit 
	@Autowired
	private transfer transfer;//ע��
	@Test
	public void demo() {
//		String xmlPath ="applicationContext.xml";
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
//		transfer transfer = (transfer)applicationContext.getBean("transferServiceId");
		//ע�ⲻ��дtransferimpl  ��Ϊspringaopʵ�ֵĴ�����  ��֮ǰ��ʵ���಻�ܽ��л�ת
		transfer.transferMoney("jack", "rose", 1000);   
	}

}
