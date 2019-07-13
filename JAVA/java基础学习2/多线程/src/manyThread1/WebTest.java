package manyThread1;

import manyThread.WebDownloadTest;

/**
 * 开始三个线程 一起下载
 * @author sofency
 * 使用Runnable 进行执行关联线程执行
 */
public class WebTest {
	public static void main(String[] args) {
		WebDownloadTest web=new WebDownloadTest("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1620058605,1337880345&fm=26&gp=0.jpg", "robit.jpg");
		WebDownloadTest web1=new WebDownloadTest("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562934968737&di=4ba8369abbcb86cfab4810a64973802c&imgtype=0&src=http%3A%2F%2Fphotocdn.sohu.com%2F20150704%2Fmp21233559_1435973214912_2.jpeg", "dooar.jpeg");
		WebDownloadTest web2=new WebDownloadTest("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562934968737&di=440538ec3b1891ad81994a9f67e4127f&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201507%2F30%2F20150730165928_Cn2w8.jpeg", "null.jpeg");
		
		
		new Thread(web).start();//关联线程进行下载
		new Thread(web1).start();
		new Thread(web2).start();
	
	
	}

}
