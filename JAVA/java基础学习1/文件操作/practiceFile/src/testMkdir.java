import java.io.File;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class testMkdir {
    public static void main(String[] args) {
        File file=new File("D:\\电影\\小视频\\苍老师");
        //file.mkdir();//创建失败 因为没有小视频目录 即只能一级一级的创建目录
        file.mkdirs();//所有的文件目录都创建
    }
}
