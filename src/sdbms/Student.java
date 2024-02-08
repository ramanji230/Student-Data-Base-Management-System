package sdbms;

// 4.)Been Class-->because we useing getter and setter methods
public class Student {

	private String id;
	private int age;
	private String name;
	private int marks;
	private static int count=101;

	public Student( int age, String name, int marks) {
		this.id="JSP"+count;
		count++;
		this.age=age;
		this.name=name;
		this.marks=marks;
	}
	//public --> 4 getter & 3 setter
	//public -->tostring();


	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks=marks;
	}

	public String toString() {
		return"ID:"+id+" Age:"+age+" Name:"+name+" Marks:"+marks;
	}
}
