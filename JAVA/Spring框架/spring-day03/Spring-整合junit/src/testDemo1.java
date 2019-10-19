import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sofency.transferService.transfer;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class testDemo1 {
	//整合junit 
	@Autowired
	private transfer transfer;//注入
	@Test
	public void demo() {
//		String xmlPath ="applicationContext.xml";
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
//		transfer transfer = (transfer)applicationContext.getBean("transferServiceId");
		//注意不能写transferimpl  因为springaop实现的代理类  和之前的实现类不能进行互转
		transfer.transferMoney("jack", "rose", 1000);   
	}

}
