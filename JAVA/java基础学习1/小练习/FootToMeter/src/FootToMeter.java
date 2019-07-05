/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class FootToMeter {
    public static void main(String[] args) {
        Scanner input = new  Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Enter a value for feet: ");
        double foot = input.nextDouble();
        double meter = foot * 0.305;
        System.out.println((int)foot+" feet is "+ df.format(meter)+" meters");
    }
}
