/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */

import javax.swing.JOptionPane;
    public class ComputeAreaWithConsoleInput{
        public static void main(String[] args){

            String input=JOptionPane.showInputDialog("Enter a number for radius:");
            double radius=Double.parseDouble(input);

            double area=radius *radius*3.14159;
            String output="The area for the circle of radius "+radius+" is "+area;
            JOptionPane.showMessageDialog(null,output);
        }
    }

