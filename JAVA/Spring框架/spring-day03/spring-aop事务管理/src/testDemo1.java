import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sofency.transferService.transfer;
import com.sofency.transferServiceImpl.transferImpl;

public class testDemo1 {
	@Test
	public void demo() {
		String xmlPath ="applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		transfer transfer = (transfer)applicationContext.getBean("transferServiceId");
		//注意不能写transferimpl  因为springaop实现的代理类  和之前的实现类不能进行互转
		transfer.transferMoney("jack", "rose", 1000);   
	}

}
