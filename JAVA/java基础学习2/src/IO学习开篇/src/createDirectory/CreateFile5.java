package createDirectory;

import java.io.File;

import javax.naming.directory.DirContext;

/**
 * 使用面向对象查看文件的大小
 * 递归查看文件的大小
 * @author sofency
 *
 */
public class CreateFile5 {
	public static void main(String[] args) {
		//递归打印所有文件
		countFIle file=new countFIle("H:\\eclipse_workspace\\IO学习开篇");
		System.out.println(file.getSize());
		
		
		
		countFIle file1=new countFIle("H:\\eclipse_workspace\\IO学习开篇\\src");
		System.out.println(file1.getSize());//统计该文件的大小
		System.out.println(file1.getNumFile());//统计该文件下文件的数目
	}
	

}

class countFIle{
	private String pathFile;//文件的路径
	private long size;//文件的大小
	private File srcFile;//源文件
	private int numDir;
	private int numFile;
	
	
	public int getNumDir() {
		return numDir;
	}

	public int getNumFile() {
		return numFile;
	}

	//统计文件的多少  统计文件夹的多少
	public long getSize() {
		return size;
	}

	public countFIle(String pathFile) {
		super();
		this.pathFile = pathFile;
		this.srcFile=new File(pathFile);//获取源文件
		Count(srcFile);//计算文件的大小
	}
	
	private  void Count(File file) {
		//获取大小
		if(file.exists()&&file!=null) {
			if(file.isFile()) {//如果是文件的话则将文件的大小和size累加
				size+=file.length();
				this.numFile++;
			}else {
				this.numDir++;
				for (File src : file.listFiles()) {//
					Count(src);
				}
			}
		}
	}
}