package org.comstudy21;

public class Helloworld {
	String name;
	
	public Helloworld(String name){ //������
		this.name = name; 
	}
	
	public void sayHello(){
		System.out.printf("Hello %s\n", name);
	}

}
