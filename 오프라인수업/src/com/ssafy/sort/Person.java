package com.ssafy.sort;

public class Person  implements Comparable<Person> {
	
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	//=====comparable하지 않게 해봣어=====//
	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.getName());
		
		//내림차순
		//return this.name.compareTo(o.getName()-1); 마이너스 해도됨
//		return o.getName().compareTo(this.name);
		//나이순으로 정렬하고싶은데,,
		
	}
	
}
