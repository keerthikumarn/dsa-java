package com.lld.design.courseregistration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRegistrationSystem {

	private static CourseRegistrationSystem instance;
	private final Map<String, Course> courses;
	private final Map<String, Student> students;
	private final List<Registration> registrations;

	private CourseRegistrationSystem() {
		this.courses = new HashMap<>();
		this.students = new HashMap<>();
		this.registrations = new ArrayList<>();
	}

	public static CourseRegistrationSystem getInstance() {
		if (instance == null) {
			instance = new CourseRegistrationSystem();
		}
		return instance;
	}

	public Student registerStudent(String name, String email) {
		Student student = new Student(name, email);
		students.put(student.getId(), student);
		return student;
	}

	public Course addCourse(String code, String name, String instructor, int capacity) {
		Course course = new Course(code, name, instructor, capacity);
		courses.put(course.getCode(), course);
		return course;
	}

	public synchronized void enroll(String studentId, String courseCode) {
		Student student = students.get(studentId);
		Course course = courses.get(courseCode);
		if (student == null || course == null) {
			throw new IllegalArgumentException("Student or Course not found");
		}
		course.enroll(student);
		student.enroll(course);
	}

	public synchronized void drop(String studentId, String courseCode) {
		Student student = students.get(studentId);
		Course course = courses.get(courseCode);
		if (student == null || course == null) {
			throw new IllegalArgumentException("Student or Course not found");
		}
		course.drop(student);
		student.drop(course);
	}

	public List<Course> getAvailableCourses() {
		return courses.values().stream().filter(Course::isCourseAvailable).toList();
	}

	public List<Course> searchCourses(String query) {
		List<Course> result = new ArrayList<>();
		for (Course course : courses.values()) {
			if (course.getCode().contains(query) || course.getName().contains(query)) {
				result.add(course);
			}
		}
		return result;
	}

	public void addCourse(Course course) {
		courses.put(course.getCode(), course);
	}

}
