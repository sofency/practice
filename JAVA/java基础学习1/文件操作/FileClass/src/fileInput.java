import java.io.File;
import java.io.PrintWriter;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class fileInput {
    public static void main(String[] args)throws Exception {
        File file=new File("score.txt");
        System.out.println(file.getAbsolutePath());
//        if(file.exists()){
//            System.out.println("File already exists");
//            System.exit(0);
//        }
        PrintWriter output=new PrintWriter(file);
        output.print("sofency");
        output.println(90);
        output.print("alice");
        output.println(99);
        output.print("hello");
        //反复运行时会检测是否有重写现象如果没有的话不会再次将上次写的内容再重新写入文件中
        output.close();//不关闭不会保存文件
    }

}
