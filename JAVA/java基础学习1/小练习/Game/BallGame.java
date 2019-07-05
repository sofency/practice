package Game;

import java.awt.*;
import javax.swing.*;
public class BallGame extends JFrame{
	
	 Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");//�������ͼƬ
	 Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");//���������ͼƬ
	
	 double x=100;//С��ĺ�����
	 double y=100;//С���������
	 boolean right=true;
	 
	 public void paint(Graphics g) {
		 System.out.println("���ڱ�����һ��");
		 g.drawImage(desk,0,0,null);//�Ȼ�����
		 g.drawImage(ball,(int)x,(int)y,null);//�ٻ�С��
		 if(right) {
			 x=x+10;
		 }else {
			 x=x-10;
		 }
		 if(x>856-40-30) {//30��С���ֱ����40�Ǳ߿�ľ���
			 right=false;
		 }
		 if(x<40){
			 right=true;
			 
		 }
	 }
	 
	 //���ڼ���
	void launchFrame() {//���崰��
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
	
	//�ػ�����
	while(true)	{
		repaint();
		try {
			Thread.sleep(40);//40ms ,һ�뻭25�δ���
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	}
	//main�ǳ�������
	public static void main(String[] args) {
		BallGame game=new BallGame();//�������
		game.launchFrame();
	}
	

}
