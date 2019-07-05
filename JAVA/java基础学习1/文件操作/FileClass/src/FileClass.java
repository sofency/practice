import java.io.File;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: FileClass
 * @Version: 1.0
 */
public class FileClass {
    public static void main(String[] args) {
        File file=new File("H:\\download");
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.canRead());//表示文件存在
        System.out.println(file.canWrite());//是否可写
        System.out.println(file.isHidden());//是否是被隐藏的文件
        System.out.println(file.isDirectory());//表示文件存在且可写
        System.out.println(file.getName());//得到文件的名字
        System.out.println(file.getParent());//得到父目录
    }
}
