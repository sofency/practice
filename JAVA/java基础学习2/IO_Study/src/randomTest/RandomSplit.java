package randomTest;

import java.io.IOException;

public class RandomSplit {
	public static void main(String[] args) throws IOException {
		SplitFile splitFile=new SplitFile("src/stream/CopyFile.java", "dest", 128);
		splitFile.split();
		splitFile.merge("sofency.java");//����ɢ���ļ��ϲ���sofency.java��
	} 

}
