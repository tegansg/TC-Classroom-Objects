package io.zipcoder;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private Student[] students;
    private int studentsEnrolled;
    private int maxStudents;

    /**
     * Empty constructor.  You get to decide what max students should default to.
     */
    public Classroom() 
    {
    	this.maxStudents = 30;
    	this.students = new Student[maxStudents];
    	this.studentsEnrolled = 0;
    }

    /**
     * Constructor where the caller defines what maxStudents is.
     * @param maxStudents
     */
    public Classroom(int maxStudents) 
    {
    	this.maxStudents = maxStudents;
    	this.students = new Student[maxStudents];
    	this.studentsEnrolled = 0;
    }

    /**
     * Constructor that builds a class from an existing Student array.
     * @param students
     */
    public Classroom(Student[] students) 
    {
    	this.students = students;
    	this.maxStudents = students.length;
    	this.studentsEnrolled = numberOfStudents(students);
    	
    }
    
    private int numberOfStudents(Student[] students)
    {
    	int number = 0;
    	for(int x=0; x<students.length; x++)
    	{
    		if(!students[x].equals(null))
    		{
    			number += 1;
    		}
    	}
    	return number;
    }

    /**
     * Adds a student to the class, and returns true.
     * If you cannot add any more students, then return false and print an error statement.
     * @param student
     * @return
     */
    public boolean addStudent(Student student) 
    {	
    	if(studentsEnrolled<maxStudents)
    	{
	    	this.students[studentsEnrolled] = student;
			this.studentsEnrolled += 1;
			return true;
    	}
        return false;    
    }

    /**
     * Returns the student with the firstName and lastName, and removes them from the array.
     * If there is no student, return null.
     * NOTE: You're going to want to move some students around in the array so that there are no empty spaces in the
     * middle.
     * @param firstName
     * @param lastName
     * @return
     */
    public Student removeStudent(String firstName, String lastName) 
    {
    	String fullName = firstName + " " + lastName;
        for(int x=0; x<studentsEnrolled; x++)
        {
        	if(students[x].getFullName().equals(fullName))
        	{
        		for(int i=x; i<studentsEnrolled-1; i++)
        		{
        			students[i]=students[i+1];
        		}
        		Student response = students[x];
        		students[studentsEnrolled-1] = null;
        		return response;
        	}
        }
    	return null;
    }

    /**
     * Return the average score of all of the student's average scores.
     */
    public double getClassAverage()
    {
    	double num = 0;
    	
    	if(studentsEnrolled==0) // add a condition
    	{
    		return 100.0;
    	}
    	
    	for(int x=0; x<studentsEnrolled; x++)
    	{
    		num += students[x].getAverage();
    	}
    	return num/studentsEnrolled;
    }

    /**
     * Return a string of student names and their averages, like.
     *
     * Students:
     * Bart Simpson -> 72.4
     * Homer Simpson -> 0.1
     * Lisa Simpson -> 100.0
     * Milhouse Van Houten -> 87.6
     *
     * If there are no students in the array, return No Students.
     *
     * @return
     */
    public String getClassScores(){
    	String response = "Students:";
    	if(studentsEnrolled==0)
    	{
    		return "No Students";
    	}
    	
    	for(int x=0; x<studentsEnrolled; x++)
    	{
    		String fullname = students[x].getFullName();
    		double avg = students[x].getAverage();
    		response += String.format("\n%s -> %.1f", fullname, avg);
    	}
        return response;
    }

    
    /**
     * Sorts the Students array from highest average to lowest, and ties are broken alphabetically.
     */
    
    
    public void sortStudentsByScore() 
    {
    	List<Student> myList = new ArrayList<Student>(studentsEnrolled);
    	myList.add(students[0]);
    	
    	for(int i = 1; i < studentsEnrolled; i++) 
    	{
    		Student student = students[i];
    		int index = findNewIndex(student, myList, i);
    		myList.add(index, student);
    	}

    	this.students = (Student[]) myList.toArray(students); // resets array	
    }
    
    
    public int findNewIndex(Student student, List<Student> myList, int x)
    {	
		
		for(int i = 0; i < x; i++) 
		{
			Student student2 = myList.get(i);
			
 			if((student.compareTo(student2) > 0) // if students averages are higher
 				||
 				(student.compareTo(student2) == 0 && student.compareToFullName(student2)<0)) 
 				// if the students average is equal to the average in question and comes before the other student in the alphabet
 			{
				return i; //add before
			}		
 			
		}
		return x; // add at end
    	
    }
    
    
 
    
    
    
//	if(students[x+1].getAverage()>=highestSoFar.getAverage())
//	{
//		highestSoFar = students[x+1];
//	}
	

    /**
     * CHALLENGE METHOD: Don't stress on this.  It's just a little something to challenge you.
     * Must return a string like in `getClassScore`, except it should look like this:
     * Grades:
     * Lisa Simpson -> A
     * Milhouse Van Houten -> B
     * Bart Simpson -> C
     * Homer Simpson -> F
     *
     * And if there are no student's, just return No students.
     *
     * The way the grading is done is by a bell curve where, ideally, the grades should be distributed like this:
     * 10% get A
     * 25% get B
     * 30% get C
     * 25% get D
     * 10% get F
     *
     * Don't stress too much on the grading, but show that you can separate students into those
     * sections and then print that out.
     *
     * @return
     */
    public String gradeClass() {
        return null;
    }
}
