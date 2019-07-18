package webServer;

public class Girl {

	private String id;
	private  String name;
	private  String age;

	public Girl(String id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Girl() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String string) {
		this.age = string;
	}

	@Override
	public String toString() {
		return "Girl [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
