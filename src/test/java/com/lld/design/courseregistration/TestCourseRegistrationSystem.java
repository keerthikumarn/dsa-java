package com.lld.design.courseregistration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCourseRegistrationSystem {

	private CourseRegistrationSystem courseRegistrationSystem;

	@BeforeEach
	void setUp() throws Exception {
		courseRegistrationSystem = CourseRegistrationSystem.getInstance();
	}

	@Test
	void testSingletonInstance() {
		CourseRegistrationSystem instance1 = CourseRegistrationSystem.getInstance();
		CourseRegistrationSystem instance2 = CourseRegistrationSystem.getInstance();
		assertSame(instance1, instance2);
	}

	@Test
	void testRegisterStudent() {
		Student student = courseRegistrationSystem.registerStudent("Keerthi Kumar", "keerthi@no-reply.com");
		assertNotNull(student);
		assertEquals("Keerthi Kumar", student.getName());
		assertEquals("keerthi@no-reply.com", student.getEmail());
	}

	@Test
	void testAddCourse() {
		Course course = courseRegistrationSystem.addCourse("CS101", "Intro to CS", "Dr. Smith", 3);
		assertNotNull(course);
		assertEquals("CS101", course.getCode());
	}

	@Test
	void testEnrollAndDropStudent() {
		Student student = courseRegistrationSystem.registerStudent("JavaDev", "javadev@no-reply.com");
		Course course = courseRegistrationSystem.addCourse("MATH101", "Math Basics", "Prof. Math", 2);

		assertDoesNotThrow(() -> courseRegistrationSystem.enroll(student.getId(), course.getCode()));
		assertEquals(1, course.getEnrolledStudents().size());
		assertTrue(course.getEnrolledStudents().contains(student));

		assertDoesNotThrow(() -> courseRegistrationSystem.drop(student.getId(), course.getCode()));
		assertEquals(0, course.getEnrolledStudents().size());
	}

	@Test
	void testEnrollInvalidStudentOrCourse() {
		assertThrows(IllegalArgumentException.class, () -> courseRegistrationSystem.enroll("invalid", "CS101"));
	}

	@Test
	void testDropInvalidStudentOrCourse() {
		assertThrows(IllegalArgumentException.class, () -> courseRegistrationSystem.drop("invalid", "CS101"));
	}

	@Test
	void testGetAvailableCourses() {
		Course available = courseRegistrationSystem.addCourse("PHY101", "Physics", "Dr. Newton", 2);
		Course fullCourse = courseRegistrationSystem.addCourse("CHEM101", "Chemistry", "Dr. Curie", 1);
		Student s1 = courseRegistrationSystem.registerStudent("Cool", "coolboy@example.com");
		Student s2 = courseRegistrationSystem.registerStudent("Bad", "badboy@example.com");
		courseRegistrationSystem.enroll(s1.getId(), "CHEM101");
		List<Course> availableCourses = courseRegistrationSystem.getAvailableCourses();
		assertTrue(availableCourses.contains(available));
		assertFalse(availableCourses.contains(fullCourse));
	}

	@Test
	void testSearchCourses() {
		courseRegistrationSystem.addCourse("CS102", "Data Structures", "Prof. Trees", 2);
		courseRegistrationSystem.addCourse("CS103", "Algorithms", "Prof. Algo", 2);
		List<Course> results = courseRegistrationSystem.searchCourses("CS10");
		assertEquals(2, results.size());
		results = courseRegistrationSystem.searchCourses("Structures");
		assertEquals(1, results.size());
	}

	@Test
	void testAddCourseObject() {
		Course course = new Course("BIO101", "Biology", "Dr. Life", 2);
		courseRegistrationSystem.addCourse(course);
		List<Course> courses = courseRegistrationSystem.searchCourses("BIO101");
		assertEquals(1, courses.size());
		assertEquals("Biology", courses.get(0).getName());
	}

}
