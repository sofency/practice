package 在线咨询;

public class TalkTeatcher {
	public static void main(String[] args) {
		new Thread(new TalkReceive(9999,"学生")).start();
		new Thread(new TalkSend(5555, "localhost", 10000)).start();
	}
}
