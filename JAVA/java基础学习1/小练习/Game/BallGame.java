package Game;

import java.awt.*;
import javax.swing.*;
public class BallGame extends JFrame{
	
	 Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");//加载球的图片
	 Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");//加载桌面的图片
	
	 double x=100;//小球的横坐标
	 double y=100;//小球的纵坐标
	 boolean right=true;
	 
	 public void paint(Graphics g) {
		 System.out.println("窗口被画了一次");
		 g.drawImage(desk,0,0,null);//先画桌面
		 g.drawImage(ball,(int)x,(int)y,null);//再画小球
		 if(right) {
			 x=x+10;
		 }else {
			 x=x-10;
		 }
		 if(x>856-40-30) {//30是小球的直径。40是边框的距离
			 right=false;
		 }
		 if(x<40){
			 right=true;
			 
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
		BallGame game=new BallGame();//定义对象
		game.launchFrame();
	}
	

}
