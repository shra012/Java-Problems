/**
 * 
 */
package com.ogrds.cache;

import java.io.Serializable;

/**
 * @author 965922
 *
 */
public class StudentPojo implements Serializable {

	private int collegeId;
	private int studentId;
	private String collegeName;
	private String studentName;
	
	public StudentPojo(int collegeId, int studentId, String collegeName, String studentName) {
		this.collegeId = collegeId;
		this.studentId = studentId;
		this.collegeName = collegeName;
		this.studentName = studentName;
	}
	public StudentPojo() {
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
