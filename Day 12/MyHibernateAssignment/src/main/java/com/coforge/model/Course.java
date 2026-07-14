package com.coforge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.ManyToMany;

@Entity
@Table(name="course")
public class Course {
	@Id
	@Column(name = "course_id", length = 5)
	private int course_id;
	
	@Column(name = "course_name", length = 20)
	private String course_name;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int course_id, String course_name) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
	}
	
	public List<Student> getStudents() {
	    return students;
	}

	public void setStudents(List<Student> students) {
	    this.students = students;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + "]";
	}
	
	

}
