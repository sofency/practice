package test1;

public class user {
	private int uid;
	private String name;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "user [Uid=" + uid + ", name=" + name + "]";
	}
	public user() {
		
	}
	public user(int uid,String name) {
		super();
		this.uid = uid;
		this.name = name;
	}
}
