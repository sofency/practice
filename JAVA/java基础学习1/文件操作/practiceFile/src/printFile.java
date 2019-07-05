import java.io.File;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class printFile {
    public static void main(String[] args) {
        File file=new File("E:\\数据结构\\数据结构VIP教程代码");
        printFile(file,0);
    }
    static void printFile(File file,int level){

        for (int i = 0; i <level ; i++) {
            System.out.print("--");
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            File[] files=file.listFiles();
            for(File tem:files){
                printFile(tem,level+1);
            }
        }
    }
}
