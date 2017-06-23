package com.jsoft.testmybatis.bean;

import java.util.List;

import org.apache.ibatis.type.Alias;

/*@Alias("Klass")*/
public class Klass {

	private int id;
	private String name;
	private List<Student> students;

	public Klass() {
	}

	public Klass(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Klass [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
