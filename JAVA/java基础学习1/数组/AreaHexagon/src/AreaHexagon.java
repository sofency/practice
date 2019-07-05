/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */

import java.text.DecimalFormat;
import java.util.Scanner;
public class AreaHexagon {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        DecimalFormat size=new DecimalFormat("0.00");//限制输出结果的小数点
        System.out.println("Enter the side:");
        double s=input.nextDouble();
        double area =6*s*s/(4*Math.tan(Math.PI/6));
        System.out.println("the area of the hexagon is "+size.format(area));
    }
}

