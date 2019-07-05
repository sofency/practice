package study;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: study
 * @Version: 1.0
 */
import java.util.Scanner;
public class testThis {//构造器
    int eatTime, singTime, backTime;//成员变量

    testThis(int eatTime, int singTime) {
       this.eatTime= eatTime;//后者是局部变量，前者是成员变量
        this.singTime = singTime;
    }

    testThis(int eatTime, int singTime, int backTime) {
        this(eatTime, singTime);//构造器只能放第一句
        this.backTime = backTime;
    }
    void sing(){
        System.out.println("你同学说你唱歌贼难听");
    }

    void eat(){
        System.out.println("赶紧回家吃饭");
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入现在的时间");
        int backTime=input.nextInt();
        testThis stu=new testThis(12,16,backTime);
        if(stu.eatTime==stu.backTime){
            System.out.println("现在是吃饭时间");
            stu.eat();
        }
        if(stu.singTime>stu.eatTime&&stu.singTime<stu.backTime)
        {
            System.out.println("现在是唱歌时间");
            stu.sing();
        }
    }
}
