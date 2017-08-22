package io.zipcoder;

import org.junit.Test;
import org.junit.Assert;

public class ClassroomTest {
	
	//test the constructors
	
	
	@Test
	public void addStudentTrueTest()
	{
		Classroom classroom = new Classroom();
		Student student = new Student("Tegan", "Salter-George", 5);
		
		boolean actual = classroom.addStudent(student);
		
		Assert.assertTrue(actual);
		
	}
	
	@Test
	public void addStudentFalseTest()
	{
		Classroom classroom = new Classroom(1);
		Student student1 = new Student("Tegan", "Salter-George", 5);
		Student student2 = new Student("Issy", "Irvine", 6);
		
		boolean actual1 = classroom.addStudent(student1);
		boolean actual2 = classroom.addStudent(student2);
		
		Assert.assertTrue(actual1);
		Assert.assertFalse(actual2);
	}
	
	@Test
	public void removeStudentTest()
	{
		Classroom classroom = new Classroom(5);
		Student student1 = new Student("Tegan", "Salter-George", 5);
		Student student2 = new Student("Issy", "Irvine", 6);
		
		classroom.addStudent(student1);
		classroom.addStudent(student2);
		
		Student expected = student2;
		Student actual = classroom.removeStudent("Issy", "Irvine");
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void removeStudentNullTest()
	{
		Classroom classroom = new Classroom(5);
		Student student1 = new Student("Tegan", "Salter-George", 5);
		Student student2 = new Student("Issy", "Irvine", 6);
		
		classroom.addStudent(student1);
		classroom.addStudent(student2);
	
		Student actual = classroom.removeStudent("Izzy", "Irvine");
		
		Assert.assertNull(actual);
	}
	
	@Test
	public void getClassAverageTest()
	{
		Classroom classroom = new Classroom(5);
		Student student1 = new Student("Tegan", "Salter-George", 5);
		Student student2 = new Student("Issy", "Irvine", 6);
		student1.takeExam(75); //average of 50
		student1.takeExam(25);
		student1.takeExam(50);
		
		student2.takeExam(70); //average of 80
		student2.takeExam(90);
		
		classroom.addStudent(student1);
		classroom.addStudent(student2);
		
		Double expected = 65.0;
		Double actual = classroom.getClassAverage();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getClassAverageBeNiceTest()
	{
		Classroom classroom = new Classroom(5);
		
		Double expected = 100.0;
		Double actual = classroom.getClassAverage();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getClassroomScoresTest()
	{
	
	Student bart = new Student("Bart", "Simpson", 5); bart.takeExam(72);
	Student homer = new Student("Homer", "Simpson", 5); homer.takeExam(1);
	Student lisa = new Student("Lisa", "Simpson", 5); lisa.takeExam(100);
	Student milhouse = new Student("Milhouse", "Van Houten", 3); milhouse.takeExam(87);

	Student[] students = {bart, homer, lisa, milhouse};
	Classroom classroom = new Classroom(students);

	
	String expected = "Students:"
					+ "\nBart Simpson -> 72.0"
					+ "\nHomer Simpson -> 1.0"
					+ "\nLisa Simpson -> 100.0"
					+ "\nMilhouse Van Houten -> 87.0";
	String actual = classroom.getClassScores();
	
	Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getClassroomScoresNoneTest()
	{
		Classroom classroom = new Classroom(4);
		String expected = "No Students";
		String actual = classroom.getClassScores();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void sortStudentsByScoreTest()
	{
		Student lisa = new Student("Lisa", "Simpson", 5); lisa.takeExam(100);
		Student bart = new Student("Bart", "Simpson", 5); bart.takeExam(72);
		Student homer = new Student("Homer", "Simpson", 5); homer.takeExam(1);
		Student milhouse = new Student("Milhouse", "Van Houten", 3); milhouse.takeExam(100);

		Student[] students = {lisa, bart, homer, milhouse};
		Classroom classroom = new Classroom(students);
		
		classroom.sortStudentsByScore();
		
		String expected = "Students:"
				+ "\nLisa Simpson -> 100.0"
				+ "\nMilhouse Van Houten -> 100.0"
				+ "\nBart Simpson -> 72.0" // make same as Homer's and test if sorts alphbetically
				+ "\nHomer Simpson -> 1.0";
		
		String actual = classroom.getClassScores();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void sortStudentsByScoreFirstNamesTest()
	{
		Student lisa = new Student("Lisa", "Simpson", 5); lisa.takeExam(100);
		Student bart = new Student("Bart", "Simpson", 5); bart.takeExam(100);
		Student homer = new Student("Homer", "Simpson", 5); homer.takeExam(100);

		Student[] students = {lisa, bart, homer};
		Classroom classroom = new Classroom(students);
		
		classroom.sortStudentsByScore();
		
		String expected = "Students:"
				+ "\nBart Simpson -> 100.0"
				+ "\nHomer Simpson -> 100.0"
				+ "\nLisa Simpson -> 100.0";
		
		String actual = classroom.getClassScores();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void gradeClassTest()
	{
		Student bart = new Student("Bart", "Simpson", 5); bart.takeExam(72);
		Student homer = new Student("Homer", "Simpson", 5); homer.takeExam(1);
		Student lisa = new Student("Lisa", "Simpson", 5); lisa.takeExam(100);
		Student milhouse = new Student("Milhouse", "Van Houten", 3); milhouse.takeExam(100);

		Student[] students = {bart, homer, lisa, milhouse};
		Classroom classroom = new Classroom(students);
		
		
	}
}