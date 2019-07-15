package 高级主题;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;


public class SimpleExample {

  public void run() throws Exception {
   
   //创建scheduler的工厂
    SchedulerFactory sf = new StdSchedulerFactory();
    //从工厂中获的调度器
    Scheduler sched = sf.getScheduler();


    // computer a time that is on the next round minute
    Date runTime = evenSecondDateAfterNow();


    // 将要执行的任务的class文件放进来
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

    // 触发条件  即在runTime之后执行
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    // 触发条件触发 后执行工作
    sched.scheduleJob(job, trigger);

    // scheduler has been started)
    sched.start();

    try {
      
      Thread.sleep(5L * 1000L);
    
    } catch (Exception e) {
    	e.printStackTrace();
    }

 
   
    sched.shutdown(true);
  }

  public static void main(String[] args) throws Exception {

    SimpleExample example = new SimpleExample();
    example.run();

  }

}
