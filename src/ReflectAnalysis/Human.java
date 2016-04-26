package ReflectAnalysis;

public class Human {
	public String name;
	private int age;
	
	public Human(String name, int age){
		this.name = name;
		this.setAge(age);
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
}
