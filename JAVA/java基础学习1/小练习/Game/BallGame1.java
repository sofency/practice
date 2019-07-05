package Game;

import java.awt.*;
import javax.swing.*;
public class BallGame1 extends JFrame{
	
	 Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");//�������ͼƬ
	 Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");//���������ͼƬ
	
	 double x=100;//С��ĺ�����
	 double y=100;//С���������
	
	 double degree=Math.PI/3;
	 
	 public void paint(Graphics g) {
		 System.out.println("���ڱ�����һ��");
		 g.drawImage(desk,0,0,null);//�Ȼ�����
		 g.drawImage(ball,(int)x,(int)y,null);//�ٻ�С��
		 
		 x=x+10*Math.cos(degree);
		 y=y+10*Math.sin(degree);
		 
		 if(y>500-40-30||y<80){//500�Ǵ��ڸ߶ȣ�40�����ӱ߿򣬱������߶�Ҳ��40�����ֱ��30,
			 degree=-degree;
		 }
		 
		 if(x<40||x>856-40-30) {
			 degree=Math.PI-degree;
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
		BallGame1 game=new BallGame1();//�������
		game.launchFrame();
	}
	

}
