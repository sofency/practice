package manyThread2;

/**
 * ʵ��Callable�ӿ� ��дcall����
 * 
 *  �����̵߳ķ���
 *   ���õ��Ǽ̳�Thread  ��ʵ��Runnable�ӿ� ��д run()����
 *   juc ��������ʵ��callable�ӿ�
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import manyThread.WebDownloader;


public class CallableTest implements Callable<Boolean>{

	private String url;
	private String name;
	
	public CallableTest(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	@Override
	public Boolean call() throws Exception {//�����׳��쳣
		
		WebDownloader wd=new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}
	
	public static void main(String[] args) {
		CallableTest web=new CallableTest("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1620058605,1337880345&fm=26&gp=0.jpg", "robit.jpg");
		CallableTest web1=new CallableTest("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562934968737&di=4ba8369abbcb86cfab4810a64973802c&imgtype=0&src=http%3A%2F%2Fphotocdn.sohu.com%2F20150704%2Fmp21233559_1435973214912_2.jpeg", "dooar.jpeg");
		CallableTest web2=new CallableTest("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562934968737&di=440538ec3b1891ad81994a9f67e4127f&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201507%2F30%2F20150730165928_Cn2w8.jpeg", "null.jpeg");
		
		
		
		//����ִ�з���
		ExecutorService service=Executors.newFixedThreadPool(3);//�����̵߳ĸ���
		//�ύִ��
		Future<Boolean> result1=service.submit(web);
		Future<Boolean> result2=service.submit(web1);
		Future<Boolean> result3=service.submit(web2);
		
		//��ȡ���
		try {
			boolean r1=result1.get();
			boolean r2=result2.get();
			boolean r3=result3.get();
			//�رշ���
			service.shutdownNow();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
