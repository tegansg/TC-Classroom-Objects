package io.zipcoder;

import java.lang.Comparable;

public class Student implements Comparable<Student> {
    
	private String firstName;
    private String lastName;
    private int[] testScores;
    private int totalExams;
    private int examsTaken;

    /**
     * Constructor for a student with just their first and last name.
     * You must make a default amount of tests here.
     * @param firstName
     * @param lastName
     */
    public Student(String firstName, String lastName) 
    {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.totalExams = 0;
    	this.examsTaken = 0;
    }

    /**
     * How we're going to construct our students when we know how many tests they're going to take
     * @param firstName
     * @param lastName
     * @param totalExams
     */
    public Student(String firstName, String lastName, int totalExams) 
    {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.totalExams = totalExams;
    	this.examsTaken = 0;
    	this.testScores = new int[totalExams];
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
    	this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
    	this.lastName = lastName;
    }

    public int getTotalExams() 
    {
        return totalExams;
    }
    
    public String getFullName()
    {
    	return this.getFirstName() + " " + this.getLastName();
    }

    public boolean setTotalExams(int totalExams) 
    {
    	this.totalExams = totalExams;
    	if(examsTaken == 0)
    	{
	    	this.testScores = new int[totalExams]; // this will cause issues in the future.
	    	return true;
    	}
    	else if (examsTaken<totalExams)
    	{
    		int[] newTestScores = new int[totalExams];
    		for(int i=0; i<examsTaken; i++)
    		{
    			newTestScores[i] = testScores[i];
    		}
    		this.testScores = newTestScores;
    		return true;
    	}
    	return false;
    }
    

    public int getExamsTaken() 
    {
        return examsTaken;
    }


    /**
     * What we want here is a string that, if a student hasn't taken any tests, returns a `no tests taken` string.
     * Otherwise, we want to return something kind of like:
     * Test Scores:
     * Test 1 -> 100
     * Test 2 -> 89
     * Test 3 -> 54
     * @return The test scores in a nice string representation.
     */
    public String printExamScores() 
    {	
    	String response = "Test Scores:";
    	if(examsTaken==0)
    	{
    		return "No exams taken" ;
    	}
    	for(int x=0; x<examsTaken; x++)
    	{
    		response += String.format("\nTest %d -> %d", x+1, testScores[x]);
    	}
        return response;
    }

    /**
     * This function should add the grade in the correct position in the testScores array.
     * Make sure the score is between 0 and 100, and that the student isn't taking more tests than they're supposed to.
     * If there is a problem, print an error message and return false.
     * Otherwise, return true and put the score in the right spot.
     * @param score
     * @return A boolean based on if the operation worked or not.
     */
    public boolean takeExam(int score) 
    {	
    	if(examsTaken<totalExams && score<=100 && score>=0)
    	{
    		this.testScores[examsTaken] = score;
    		this.examsTaken += 1;
    		return true;
    	}
    	System.out.print("Test has not been added to student's tests");	
        return false;
    }

    /**
     * Change the score for one of the students tests.
     * Be aware that the new score must be between 0 and 100, and that they have already taken that test
     * since it doesn't make sense to change the grade on an exam that they haven't taken it.
     * @param examNum Which test the we want to change.
     * @param newScore What we want to change it to.
     * @return A boolean based on if the operation worked or not.
     */
    public boolean changeScoreForExam(int examNum, int newScore)
    {
    	if(examNum<=examsTaken && newScore<=100 && newScore>=0)
    	{
    		testScores[examNum-1] = newScore;
    		return true;
    	}
    	return false;
    }

    /**
     * Return the average for all of the exams that the student has taken.
     * If they haven't taken any, be nice and give them 100.0.
     * @return The average for all the exams a student has taken.
     */
    public double getAverage() {
    	double num = 0;
    	
    	if(examsTaken==0)
    	{
    		return 100.0;
    	}
    	
    	for(int x=0; x<examsTaken; x++)
    	{
    		num += testScores[x];
    	}
    	return num/examsTaken;
    }
    
	public int compareTo(Student other) {
		// Compare by average
		return Double.compare(getAverage(), other.getAverage());
	}
	
	public int compareToFullName(Student other) 
	{
		// Compare full names - by last name first.

		// if last names are equal compare by firstnames, otherwise compare by last names.
		int i = lastName.compareTo(other.lastName) == 0? firstName.compareTo(other.firstName): lastName.compareTo(other.lastName); 

		return i;
	}
	
}
