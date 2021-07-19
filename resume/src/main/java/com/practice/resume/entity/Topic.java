package com.practice.resume.entity;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name ="topic")
@ApiModel(description = "Details about the topic")
public class Topic {

	@Id
	@Column(name="id")
	@ApiModelProperty(notes = "Topic id")
	String id;
    @Column(name="description")
    @ApiModelProperty(notes = "Topic level")
	String description;
    @Column(name="course")
    @ApiModelProperty(notes = "Topic name")
	String course;
	
	public Topic() {
		
	}
	public Topic(String id, String description, String course) {
		super();
		this.id = id;
		this.description = description;
		this.course = course;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	
}
