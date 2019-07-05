import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class deleteStringInFile {
    public static void main(String[] args) throws IOException{
        //首先创建文件并且在文件中写入数据
        File file=new File("D:\\test.txt");
        PrintWriter input=new PrintWriter("D:\\test.txt");
        input.print("welcome to www.sofencyandalice.top");
        input.close();//存储到文件中

        Scanner change=new Scanner(file);
        String str=change.nextLine();
        String str2=str.replaceAll("andalice","");
        System.out.println(str2);

        change.close();//读取文件流关闭

        file.delete();//先删除再创建 效率低暂时未找到其他办法进行更新D:\\poem


        System.out.println(file.delete());//删除失败
        System.out.println(file.exists());
        System.out.println(file);

        File file1=new File("D:\\test.txt");
        file1.createNewFile();
        System.out.println(file1.exists());

        PrintWriter input1=new PrintWriter("D:\\test.txt");
        input1.print(str2);
        input1.close();

        //改名
        boolean st=file1.renameTo(new File("D:\\Test.txt"));
        System.out.println(st);

        System.out.println(System.getProperty("user.dir"));//显示文件的
    }
}
