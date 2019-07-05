package experiment;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: experiment
 * @Version: 1.0
 */
import java.util.Random;//导入random类
import java.util.Scanner;//导入输入类
import java.util.Date;//导入时间类 鉴别多少秒猜出正确答案


public class GuessNumber {
    public static void main(String[] args) {

        Random random=new Random();
        int number= random.nextInt(100);
        Guess(number);
    }

    public static void Guess(int number){
        System.out.println("请输入猜的数字:");
        Date startTime=new Date();//起始时间
        //Date endTime;
        boolean time=true;
        Scanner input = new Scanner(System.in);
        while(time) {
            int GuessNumber = input.nextInt();
            if (GuessNumber == number) {
                Date endTime=new Date();
                long period = (endTime.getTime() - startTime.getTime()) / 1000;
                time = false;

                if(period<10){
                    System.out.println("excellent!");
                }else if(period<20){
                    System.out.println("amazing");
                }else{
                    System.out.println("very good");
                }

                System.out.println("you take " + period + " seconds for guessing the right number");
            } else if(GuessNumber>number){
                System.out.println(" bigger！error guess,try again");
            }
            else{
                System.out.println(" smaller！error guess,try again");
            }
        }
    }
}
