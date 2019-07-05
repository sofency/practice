import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class testDate {
    public static void main(String[] args) {
//将时间对象按照"格式字符指定的格式转化为指定的格式" 转成相应的字符串
        DateFormat df=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        String str=df.format(new Date(4000000));//将4000000转化成df的格式进行输出
        System.out.println(str);

        DateFormat df2=new SimpleDateFormat("yyyy年mm月dd日 hh时mm分ss秒");

        Date date= null;
        try {
            date = df2.parse("2019年05月20日 19时29分59秒");//已无效 日期错位
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);

        //利用D 获取本时间对象是当年所处年份的多少天
        DateFormat df3=new SimpleDateFormat("D");
        String str3=df3.format(new Date());
        System.out.println(str3);

    }
}
