package ������ѯ;

public class TalkTeatcher {
	public static void main(String[] args) {
		new Thread(new TalkReceive(9999,"ѧ��")).start();
		new Thread(new TalkSend(5555, "localhost", 10000)).start();
	}
}
