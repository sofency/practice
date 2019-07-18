package 在线咨询;

public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(8888, "localhost", 9999)).start();
		new Thread(new TalkReceive(10000,"老师")).start();
	}
}
