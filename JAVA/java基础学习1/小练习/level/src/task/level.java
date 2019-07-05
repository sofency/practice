package task;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: task
 * @Version: 1.0
 */
import java.util.Scanner;
public class level {
    public static void main(String[] args) {
        double[] score=new double[20];//假定有20个学生
        Scanner input=new Scanner(System.in);//获取成绩
        System.out.print("Enter the number of students:");
        int number=input.nextInt();
        System.out.print("Enter "+number+" scores :");
        for (int i = 0; i < number; i++) {
            score[i]=input.nextDouble();
        }
        double max=max(score);
        for (int i = 0; i < number; i++) {
            System.out.println("student "+i+" score is "+(int)score[i]+" and grade is "+whatLevel(max,score[i]));
        }
    }
    public  static double max(double[] score){
        double maxNumber=score[0];
        for (int i = 1; i < score.length; i++) {
            if(maxNumber<score[i]){
                maxNumber=score[i];
            }
        }
        return maxNumber;
    }
    public static char whatLevel(double best,double score){
        if(score>=best-10){
            return 'A';
        }
        else if(score>=best-20){
            return 'B';
        }
        else if(score>=best-30){
            return 'C';
        }
        else if(score>=best-40){
            return 'D';
        }
        else
            return 'F';
    }
}
