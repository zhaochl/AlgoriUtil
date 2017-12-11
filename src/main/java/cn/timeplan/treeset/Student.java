package cn.timeplan.treeset;

////同姓名同年龄的学生视为同一个学生
public class Student implements Comparable<Student>{
	private int age;
	private String name;

	public Student(String name, int age) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Student stu) {
		int num = new Integer(this.age).compareTo(new Integer(stu.age));
		return num == 0 ? this.name.compareTo(stu.name) : num;
	}

	public String toString() {
		return name + "::" + age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
