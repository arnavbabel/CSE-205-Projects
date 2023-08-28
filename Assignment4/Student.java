/* Assignment #: 4
 Name: Arnav Babel
 StudentID: 1225345329
 Lecture: 12:20-1:10
Description: The Student class gets the user's input for 
             the Student's information and what class they are taking
*/

public class Student {

    //private instance variables
    private int id; //the id of the student
    private String major; //the major of the student
    private Course course; //the course the student is taking

    //constructor(s)
    public Student() { //initializes the instance variables
        id = 0;
        major = "?";
        course = new Course();
    }
    public Student(int id, String major, Course course) { //initializes the instance variables to the constructors
        this.id = id;
        this.major = major;
        this.course = course;
    }

    //getter method(s)
    public int getId() { //returns the ID number
        return this.id;
    }
    public String getMajor() { //returns the major
        return this.major;
    }
    public Course getCourse() { //returns the course information
        return this.course;
    }

    //setter method(s)
    public void setId(int someId) { //sets the student ID number to this.id
        this.id = someId;
    }
    public void setMajor(String someMajor) { //sets the major to this.major
        this.major = someMajor;
    }
    public void setCourse(int courseId, String instructor, String subject) { //sets the course information to the param. values
        this.course.setCourseId(courseId);
        this.course.setInstructor(instructor);
        this.course.setSubject(subject);
    }

    //toString()
    public String toString() { //prints the output
        return "\nStudent information:" + 
               "\nStudent Id:\t" + id +
               "\nMajor:\t\t" + major +
               "\n" + course.toString();
    }
}
