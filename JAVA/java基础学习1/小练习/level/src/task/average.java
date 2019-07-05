package task;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: task
 * @Version: 1.0
 */

import java.util.Scanner;
public class average {
    public static void main(String[] args) {
        double[] arr = new double[10];//定义数组
        double sum=0;//用来存储总和
        Scanner input=new Scanner(System.in);
        System.out.print("Enter 10 numbers: ");
        for (int i = 0; i < 10; i++) {
            arr[i]=input.nextDouble();
        }
        System.out.println("the ten numbers'average is "+average(arr));
    }
    public static int average(int[] array){
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        return sum/array.length;
    }
    public static double average(double[] array){
        double sum=0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        return sum/array.length;
    }
}
