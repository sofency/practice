import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class FileGUI {
    public static void main(String[] args)throws Exception {
        JFileChooser fileChooser=new JFileChooser();
        if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File file=fileChooser.getSelectedFile();
            Scanner input=new Scanner(file);

            while(input.hasNext()){
                System.out.println(input.nextLine());
            }
            input.close();
        }
        else{
            System.out.println("no File selected");
        }

    }
}
