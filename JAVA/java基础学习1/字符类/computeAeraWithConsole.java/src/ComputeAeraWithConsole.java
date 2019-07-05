/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class ComputeAeraWithConsole {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        DecimalFormat df =new DecimalFormat("0.0000");
        DecimalFormat df1 =new DecimalFormat("0.0");
        System.out.println("Enter the radius and lenth of a cylinder:");
        double radius=input.nextDouble();
        double pi=3.14159;
        double height=input.nextDouble();
        double area=pi * radius * radius;
        System.out.println("the area is "+df.format(area));
        double bulk=area * height;
        System.out.println(String.format("the volume is " + df1.format(bulk)));
    }
}
