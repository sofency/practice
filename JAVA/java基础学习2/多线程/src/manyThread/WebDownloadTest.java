package manyThread;

public class WebDownloadTest extends Thread {

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
