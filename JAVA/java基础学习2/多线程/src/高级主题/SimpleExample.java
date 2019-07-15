package �߼�����;

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
   
   //����scheduler�Ĺ���
    SchedulerFactory sf = new StdSchedulerFactory();
    //�ӹ����л�ĵ�����
    Scheduler sched = sf.getScheduler();


    // computer a time that is on the next round minute
    Date runTime = evenSecondDateAfterNow();


    // ��Ҫִ�е������class�ļ��Ž���
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

    // ��������  ����runTime֮��ִ��
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    // ������������ ��ִ�й���
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
