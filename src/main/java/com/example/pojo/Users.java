package com.example.pojo;

public class Users {
	private Integer id;
	private String name;
	private Integer sex;
	private Integer course_id;

	public Users(String name,Integer sex,Integer course_id){
		this.name=name;
		this.sex=sex;
		this.course_id=course_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
}
