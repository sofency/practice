package com.sofency.entry;

public class img {
	private  int imgid;
	private String imgurl;
	
	public img() {
		super();
	}
	public img(int imgid, String imgurl) {
		super();
		this.imgid = imgid;
		this.imgurl = imgurl;
	}
	public int getImgid() {
		return imgid;
	}
	public void setImgid(int imgid) {
		this.imgid = imgid;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	@Override
	public String toString() {
		return "img [imgid=" + imgid + ", imgurl=" + imgurl + "]";
	}
	
}
