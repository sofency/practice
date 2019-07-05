package package4;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: package4
 * @Version: 1.0
 */
import java.util.Scanner;
public class analyseGrade {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);//构建输入对象
        double sum=0;//总分
        double avg=0;//平均分
        int number=0;//人数
        int overAvg=0,lowAvg=0;
        double[] arr=new double[100];//假设最多有100个学生
        boolean flag=true;
        System.out.println("请输入学生的成绩");
        while(flag){
            arr[number]=input.nextDouble();
            if(arr[number]<0) flag=false;//如果输入的是负数则退出循环
            else {
                sum += arr[number];
                number++;
            }
        }
        avg=sum/number;//平均分数
        for (int i = 0; i < number; i++) {
            if(arr[i]>=avg) overAvg++;
            else lowAvg++;
        }
        System.out.println(avg);
        System.out.println("一共有"+overAvg+"个同学大于或等于平均分,共有"+lowAvg+"个同学低于平均分");
    }
}
