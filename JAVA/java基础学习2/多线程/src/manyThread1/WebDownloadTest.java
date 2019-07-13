package manyThread1;

import manyThread.WebDownloader;

public class WebDownloadTest implements Runnable{//以免放置要继承其他的父类  一次解决单继承的局限性

	private String url;
	private String name;
	
	
	public WebDownloadTest(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		WebDownloader wd=new WebDownloader();
		wd.download(url, name);
	}
}
