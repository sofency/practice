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
		transfer transfer = (transferImpl)applicationContext.getBean("transferServiceId");
		transfer.transferMoney("jack", "rose", 1000);
	}

}
