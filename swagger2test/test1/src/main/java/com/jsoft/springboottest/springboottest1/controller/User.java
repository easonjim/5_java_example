package com.jsoft.springboottest.springboottest1.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="User",description="用户实体")
public class User {
	private long id;
	private String name;
	private int age;
	@ApiModelProperty(value = "编号",required=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@ApiModelProperty(value = "名称",required=true,example="Jim")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ApiModelProperty(value = "年龄",required=true,example="18")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
