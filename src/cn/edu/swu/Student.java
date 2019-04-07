package cn.edu.swu;

public class Student {
	private Integer id;
	private String studentName;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Student(Integer id, String studentName, Integer age) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.age = age;
	}
	public Student() {
	}

}

