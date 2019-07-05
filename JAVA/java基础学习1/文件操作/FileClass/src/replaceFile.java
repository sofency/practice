import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class replaceFile {
    public static void main(String[] args) throws Exception{
        if(args.length!=4){
            System.out.println("error input");
            System.exit(0);
        }
        //replace the strings of the sourceFile and store into the targetFile
        File sourceFile=new File(args[0]);

        File targetFile=new File(args[1]);

        Scanner input=new Scanner(sourceFile);
        PrintWriter output=new PrintWriter(targetFile);

        while(input.hasNext()){
            String s1=input.nextLine();
            String s2=s1.replaceAll(args[2],args[3]);
            output.println(s2);
        }
        input.close();
        output.close();
    }
}
