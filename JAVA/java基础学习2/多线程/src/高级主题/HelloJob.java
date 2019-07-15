
package 高级主题;


import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

    public HelloJob() {
    }

    
    public void execute(JobExecutionContext context)
        throws JobExecutionException {
    	System.out.println("------start------");
        System.out.println("Hello World! - " + new Date());
        System.out.println("------end--------");
    }

}
