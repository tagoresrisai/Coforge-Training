package com.coforge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "student_id", length = 5)
	private int student_id;
	
	@Column(name = "student_name", length = 20)
	private String student_name;
	
	@ManyToMany
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id")
			)
	private List<Course> courses;
	
	
	public Student() {
		super();
	}

	public Student(int student_id, String student_name) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public List<Course> getCourses() {
	    return courses;
	}

	public void setCourses(List<Course> courses) {
	    this.courses = courses;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + "]";
	}
	

}
