package Game;

import java.awt.*;
import javax.swing.*;
public class BallGame1 extends JFrame{
	
	 Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");//加载球的图片
	 Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");//加载桌面的图片
	
	 double x=100;//小球的横坐标
	 double y=100;//小球的纵坐标
	
	 double degree=Math.PI/3;
	 
	 public void paint(Graphics g) {
		 System.out.println("窗口被画了一次");
		 g.drawImage(desk,0,0,null);//先画桌面
		 g.drawImage(ball,(int)x,(int)y,null);//再画小球
		 
		 x=x+10*Math.cos(degree);
		 y=y+10*Math.sin(degree);
		 
		 if(y>500-40-30||y<80){//500是窗口高度，40是桌子边框，标题栏高度也是40，球的直径30,
			 degree=-degree;
		 }
		 
		 if(x<40||x>856-40-30) {
			 degree=Math.PI-degree;
		 }
		 
	 }
	 
	 //窗口加载
	void launchFrame() {//定义窗口
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
	
	//重画窗口
	while(true)	{
		repaint();
		try {
			Thread.sleep(40);//40ms ,一秒画25次窗口
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
    }
	//main是程序的入口
	public static void main(String[] args) {
		BallGame1 game=new BallGame1();//定义对象
		game.launchFrame();
	}
	

}
