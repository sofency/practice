/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import com.sun.jndi.ldap.sasl.SaslInputStream;

import java.util.Scanner;
public class MinuteToYearAndDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of minutes :");
        int minutes = input.nextInt();
        int eachYearMinutes = 60 * 24 *365;
        int eachDayMinutes = 60 * 24;
        int years = minutes / eachYearMinutes;
        int remainderMinutes = minutes % eachYearMinutes;
        int days = remainderMinutes / eachDayMinutes;
        System.out.println(minutes+" minutes is approxmately "+years+" years and "+days+" days");
    }
}
