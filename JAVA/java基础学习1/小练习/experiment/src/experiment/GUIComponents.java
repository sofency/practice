package experiment;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: experiment
 * @Version: 1.0
 */
import javax.swing.*;
public class GUIComponents {
    public static void main(String[] args) {
        JButton jtbOK=new JButton("OK");//设置按钮的名字
        JButton jtbCancel=new JButton("cancel");

        JLabel jlblName=new JLabel("Enter your name:");
        JTextField jtfName = new JTextField("type name here");


        JPanel panel=new JPanel();
        panel.add(jtbOK);
        panel.add(jtbCancel);
        panel.add(jlblName);
        panel.add(jtfName);

        JFrame frame = new JFrame();
        frame.add(panel);//添加面板到框架
        frame.setTitle("sofency");
        frame.setSize(450,100);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
