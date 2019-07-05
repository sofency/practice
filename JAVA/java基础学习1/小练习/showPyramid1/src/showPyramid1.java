/**
 * @Auther: sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import java.util.Scanner;
public class showPyramid1 {
    public static void main(String[] args){
            System.out.println("please enter the floors of pyramid");
            Scanner input=new Scanner(System.in);
            int floorOfPyramid=input.nextInt();//获取层数
            System.out.println("pyramid is as follows");
            for (int count = 1;count<=floorOfPyramid;count++)
            {
                for(int cntNull=1;cntNull<=(floorOfPyramid-count)*2;cntNull++)
                {
                    System.out.print(" ");
                }
                for(int cntNumberBack=count;cntNumberBack>1;cntNumberBack-- )
                {
                    System.out.print(cntNumberBack+" ");
                }
                for(int cntNumberForward=1;cntNumberForward<=count;cntNumberForward++) {
                    System.out.print(cntNumberForward + " ");
                }

                System.out.println(" ");
            }
        }
}

