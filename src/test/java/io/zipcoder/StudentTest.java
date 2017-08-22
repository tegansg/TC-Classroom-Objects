package io.zipcoder;

import org.junit.Test;
import org.junit.Assert;

public class StudentTest {
	
	@Test
	public void getFirstNameTest()
	{
		Student student = new Student("Tegan", "Salter-George");
		
		String expected = "Tegan";
		String actual = student.getFirstName();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void setFirstNameTest()
	{
		Student student = new Student("Tegan", "Salter-George");
		student.setFirstName("New Tegan");
		
		String expected = "New Tegan";
		String actual = student.getFirstName();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getLastNameTest()
	{
		Student student = new Student("Tegan", "Salter-George");
		
		String expected = "Salter-George";
		String actual = student.getLastName();
	
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setLastNameTest()
	{
		Student student = new Student("Tegan", "Salter-George");
		student.setFirstName("New Salter-George");
		
		String expected = "New Salter-George";
		String actual = student.getFirstName();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getTotalExamsTest()
	{
		Student student = new Student("Tegan", "Salter-George", 5);
		
		int expected = 5;
		int actual = student.getTotalExams();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setTotalExamsTest()
	{
		Student student = new Student("Tegan", "Salter-George");
		
		
		boolean actualTrue = student.setTotalExams(5);
		int expected = 5;
		int actual = student.getTotalExams();
		
		Assert.assertTrue(actualTrue);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setTotalExamsTrueTest()
	{
		Student student = new Student("Tegan", "Salter-George", 3);
		student.takeExam(75);
		student.takeExam(32);
		student.takeExam(35);
		
		Boolean actual = student.setTotalExams(5);
		int expected1 = 5;
		int actual1 = student.getTotalExams();
		
		
		String expected2 = "Test Scores:"
						+ "\nTest 1 -> 75"
						+ "\nTest 2 -> 32"
						+ "\nTest 3 -> 35";
		String actual2 = student.printExamScores();
		
		Assert.assertTrue(actual);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2); 
	}
	
	@Test
	public void setTotalExamsFalseTest()
	{
		Student student = new Student("Tegan", "Salter-George", 3);
		student.takeExam(75);
		student.takeExam(32);
		student.takeExam(35);
		
		Boolean actual = student.setTotalExams(2);
		
		Assert.assertFalse(actual);
	}
	
	
	@Test
    public void getExamsTakenTest() 
    {
		Student student = new Student("Tegan", "Salter-George", 5);
		student.takeExam(75);
		student.takeExam(32);
		student.takeExam(35);
		
		int expected = 3;
		int actual = student.getExamsTaken();
		
		Assert.assertEquals(expected, actual);
    }
    
	
	@Test
    public void takeExamTrueTest()
    {
		Student student = new Student("Tegan", "Salter-George", 5);
		student.takeExam(75);
		student.takeExam(32);
		student.takeExam(35);
		
		boolean actualTrue = student.takeExam(75);
		
		String expected = "Test Scores:"
						+ "\nTest 1 -> 75"
						+ "\nTest 2 -> 32"
						+ "\nTest 3 -> 35"
						+ "\nTest 4 -> 75";
		String actual = student.printExamScores();
		
		Assert.assertTrue(actualTrue); // test returns boolean
		Assert.assertEquals(expected, actual); // test adds test to test repertoire
    }
	
	@Test
    public void takeExamFalseTest()
    {
		Student student = new Student("Tegan", "Salter-George", 3);
		student.takeExam(75);
		student.takeExam(32);
		student.takeExam(35);
		
		boolean actualFalse = student.takeExam(75);
		
		String expected = "Test Scores:"
						+ "\nTest 1 -> 75"
						+ "\nTest 2 -> 32"
						+ "\nTest 3 -> 35";
		String actual = student.printExamScores();
		
		Assert.assertFalse(actualFalse); // test returns boolean
		Assert.assertEquals(expected, actual); // test adds test to test repertoire
    }
	
	
	@Test
    public void printExamScoresTest() 
    {
		Student student = new Student("Tegan", "Salter-George", 5);
		student.takeExam(75);
		student.takeExam(32);
		student.takeExam(35);
		
		String expected = "Test Scores:"
						+ "\nTest 1 -> 75"
						+ "\nTest 2 -> 32"
						+ "\nTest 3 -> 35";
		String actual = student.printExamScores();
		
		Assert.assertEquals(expected, actual);
    }
	
	@Test
    public void printExamScoresNullTest() 
    {
		Student student = new Student("Tegan", "Salter-George", 5);
		
		String expected = "No exams taken";
		String actual = student.printExamScores();
	
		Assert.assertEquals(expected, actual);
    }
	
	
	@Test
    public void changeScoreForExamTrueTest()
    {
		Student student = new Student("Tegan", "Salter-George", 5);
		student.takeExam(75);
		student.takeExam(32);
		student.takeExam(35);
		
		
		boolean actualTrue = student.changeScoreForExam(2, 45);
		
		String actual = student.printExamScores();
		String expected = "Test Scores:"
						+ "\nTest 1 -> 75"
						+ "\nTest 2 -> 45"
						+ "\nTest 3 -> 35";
		
		Assert.assertTrue(actualTrue);
		Assert.assertEquals(expected, actual);
    }
	
	@Test
    public void changeScoreForExamFalseTest()
    {
		Student student = new Student("Tegan", "Salter-George", 5);
		student.takeExam(75);
		student.takeExam(32);
		student.takeExam(35);
		
		
		boolean actualFalse = student.changeScoreForExam(4, 45);
		
		String actual = student.printExamScores();
		String expected = "Test Scores:"
						+ "\nTest 1 -> 75"
						+ "\nTest 2 -> 32"
						+ "\nTest 3 -> 35";
		
		Assert.assertFalse(actualFalse);
		Assert.assertEquals(expected, actual);
    }
    
	@Test
    public void getAverageTest()
    {
		Student student = new Student("Tegan", "Salter-George", 5);
		student.takeExam(75);
		student.takeExam(50);
		student.takeExam(25);
		
		Double expected = 50.0;
		Double actual = student.getAverage();
		
		Assert.assertEquals(expected, actual);
		
    }
    
	@Test
    public void getAverageBeNiceTest()
    {
		Student student = new Student("Tegan", "Salter-George", 5);
		
		Double expected = 100.0;
		Double actual = student.getAverage();
		
		Assert.assertEquals(expected, actual);
    }
    
    
}	

