import java.io.File;
import java.util.Scanner;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class fileRead {
    public static void main(String[] args) throws Exception {
        //创建文件实例 通俗来讲就是制定打开文件的相对路径
        File file=new File("score.txt");
        /*
        * file.exits()判断文件是否存在
        * */

        Scanner input=new Scanner(file);//读取文件

        StringBuilder str=new StringBuilder();
        while(input.hasNext()){//判断是否还有数据
            String first=input.nextLine();//获取一行数据
            str.append(first);
            str.append("\n");//将换行写入
        }
        System.out.println(str);


        Scanner input1=new Scanner(new File("test.txt"));
        int number=input1.nextInt();
        System.out.println(number);
        String line=input1.nextLine();
        System.out.println(line);//包含了" "空格字符
        System.out.println(line.charAt(1));//输出下表为1的字符
        input1.close();
        input.close();
    }
}
