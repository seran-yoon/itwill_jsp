package org.comstudy21.saram.dto;

public class SaramDto {
	
	String id;
	String name;
	int age;
	
	public SaramDto() {
		this("","",0);
	}
	
	public SaramDto(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SaramDto [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
