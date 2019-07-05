import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 文件的修改及创建文件夹和文本文件
 * @Version: 1.0
 */
public class createFile {
    public static void main(String[] args)throws IOException{
        File file=new File("D:\\sofency.txt");
        file.createNewFile();//在上述的路径下创建不存在的文件
        PrintWriter input =new PrintWriter("D:\\sofency.txt");
        input.print("sofency is cool");
        input.close();
        System.out.println(file.exists());

        File file1=new File("H:\\JAVA\\test");
        file1.mkdir();//在绝对路径下创建目录确保上面写的路径下没有创建的目录(directory)文件
        System.out.println(file1.exists());

        File file2=new File("H:\\JAVA\\test");
        boolean test = file2.renameTo(new File("H:\\JAVA\\Test"));//文件修改名字后面放的是绝对路径
        System.out.println(test);//测试是否修改成功


        //列出电脑的根目录盘符
        File[] root=File.listRoots();
        for (int i = 0; i < root.length; i++) {
            System.out.print(root[i]+" ");
        }
        System.out.println();

        //列出Test文件下的所有文件的绝对路径
        File filelist=new File("H:\\JAVA\\Test");
        File[] fl=filelist.listFiles();
        for (int i = 0; i < fl.length; i++) {
            System.out.println(fl[i]);
        }

        //返回某一目录的空间大小
        File filespace=new File("H:\\JAVA\\Test");
        System.out.println(filespace.getTotalSpace());
        System.out.println(filespace.getUsableSpace());
    }
}
