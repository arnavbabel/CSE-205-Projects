/* Assignment #: 4
 Name: Arnav Babel
 StudentID: 1225345329
 Lecture: 12:20-1:10
Description: The Course class gets the user's input for
             the course that they are taking
 */

public class Course {

    //private instance variables
    private int courseId; //Id of the course
    private String instructor; //Instructor of the course
    private String subject; //Subject of the course
    
    //constructor(s)
    public Course() { //initializes the instance variables
        courseId = 0;
        instructor = "?";
        subject = "?";
    }
    public Course(int courseId, String instructor, String subject) { //initializes the instance variables to the constructors
        this.courseId = courseId;
        this.instructor = instructor;
        this.subject = subject;
    }

    //getter method(s)
    public int getCourseId() { //returns the course ID
        return this.courseId;
    }
    public String getInstructor() { //returns the Instructor
        return this.instructor;
    }
    public String getSubject() { //returns the Subject
        return this.subject;
    } 

    //setter method(s)
    public void setCourseId(int someCourseId) { //sets the courseId to this.courseId
        this.courseId = someCourseId;
    }
    public void setInstructor(String someInstructor) { //sets the instructor to this.instructor
        this.instructor = someInstructor;
    }
    public void setSubject(String someSubject) { //sets the subject to this.subject
        this.subject = someSubject;
    }

    //toString()
    public String toString() { //prints the output
        return "\nCourse information:" + 
               "\nCourse ID:\t" + this.courseId + 
               "\nInstructor:\t" + this.instructor + 
               "\nSubject:\t" + this.subject + "\n";
    }

    //miscellaneous
    
}
