// Assignment #: Arizona State University Spring 2023 CSE205 #6
//         Name: Arnav Babel
//    StudentID: 1225345329
//      Lecture: MWF 12:20-1:10
//  Description: creates the GUI and lets the used add and drop classes  

//Note: when you submit on gradescope, you need to comment out the package line
//package yourPackageName;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class CoursePane extends HBox
{
    //GUI components
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private VBox checkboxContainer;

    //Step 1.1: declare any necessary instance variables here
    private Label labelLeft, labelRight, bottomLeft, bottomRight, lbSubject, lbCourseNum, lbInstructor, lbLeft;
    private TextField tfCourseNum, tfInstructor;
    private ComboBox<String> courses;
    private Button addBtn, dropBtn;
    private int numCourses;
    private ArrayList<CheckBox> checkBoxHolder;
    private ArrayList<CheckBoxHandler> checkBoxHandler;
    private CheckBox chBox;
    private CheckBoxHandler cbHandler;

    //constructor
    public CoursePane()
    {
        //step 1.2: initialize instance variables
        lbSubject = new Label("Subject");
        lbCourseNum = new Label("Course Num");
        lbInstructor = new Label("Instructor");
        tfCourseNum = new TextField();
        tfInstructor = new TextField();
        courses = new ComboBox<String>();
        courses.getItems().addAll("ACC", "AME", "BME", "CHM", "CSE", "DAT", "EEE");
        courses.setValue("CSE");
        addBtn = new Button("Add =>");
        dropBtn = new Button("Drop <=");
        numCourses = courseList.size();

        labelLeft = new Label("Add Course(s)");
        labelLeft.setTextFill(Color.BLUE);
        labelLeft.setFont(Font.font(null, 14));

        labelRight = new Label("Course(s) Enrolled");
        labelRight.setTextFill(Color.BLUE);
        labelRight.setFont(Font.font(null, 14));

        bottomLeft = new Label("No course entered");
        bottomLeft.setTextFill(Color.GRAY);
        bottomLeft.setFont(Font.font(null, 10));

        bottomRight = new Label("Total course(s) enrolled: ");
        bottomRight.setTextFill(Color.GRAY);
        bottomRight.setFont(Font.font(null, 10));

        //set up the layout. Note: CoursePane is a HBox and contains
        //leftPane, centerPane and rightPane. Pick proper layout class
        //and use nested sub-pane if necessary, then add each GUI components inside.

        //step 1.3: create and set up the layout of the leftPane, leftPane contains a top label, the center sub-pane
        //and a label show at the bottom
        GridPane leftCenter = new GridPane();
        leftCenter.add(lbSubject, 0, 0);
        leftCenter.add(courses, 1, 0);
        leftCenter.add(lbCourseNum, 0, 1);
        leftCenter.add(tfCourseNum, 1, 1);
        leftCenter.add(lbInstructor, 0, 2);
        leftCenter.add(tfInstructor, 1, 2);
        leftCenter.setAlignment(Pos.CENTER);
        leftCenter.setHgap(10);
        leftCenter.setVgap(10);

        BorderPane leftPane = new BorderPane();
        leftPane.setTop(labelLeft);
        leftPane.setCenter(leftCenter);
        leftPane.setBottom(bottomLeft);
        leftPane.setStyle("-fx-border-color: black");
        leftPane.setPadding(new Insets(10,10,10,10));

        //step 1.4: create and set up the layout of the centerPane which holds the two buttons
		TilePane centerPane = new TilePane(Orientation.VERTICAL);
        centerPane.getChildren().addAll(addBtn, dropBtn);
        centerPane.setPadding(new Insets(150,10,10,10));
        centerPane.setVgap(10);

        //step 1.5: create and set up the layout of the rightPane, rightPane contains a top label,
        //checkboxContainer and a label show at the bottom
        BorderPane rightPane = new BorderPane();
        rightPane.setTop(labelRight);
        checkboxContainer = new VBox();
        rightPane.setCenter(checkboxContainer);
        rightPane.setBottom(bottomRight);
        rightPane.setStyle("-fx-border-color: black");
        rightPane.setPadding(new Insets(10,10,10,10));

        //CoursePane is a HBox. Add leftPane, centerPane and rightPane inside
        this.setPadding(new Insets(10, 10, 10, 10));
        this.getChildren().addAll(leftPane, centerPane, rightPane);

        //Step 3: Register the GUI component with its handler class
        ButtonHandler buttonHandler = new ButtonHandler();
        addBtn.setOnAction(buttonHandler);
        dropBtn.setOnAction(buttonHandler);

    } //end of constructor

    //step 2.1: Whenever a new Course is added or one or several courses are dropped/removed, this method will
    //1) clear the original checkboxContainer;
    //2) create a CheckBox for each Course object inside the courseList, and also add it inside the checkboxContainer;
    //3) register the CheckBox with the CheckBoxHandler.
    public void updateCheckBoxContainer()
    {
        checkboxContainer.getChildren().clear();
        checkBoxHolder = new ArrayList<CheckBox>();
        checkBoxHandler = new ArrayList<CheckBoxHandler>();
        
        for (int i = 0; i < courseList.size(); i++) {
            chBox = new CheckBox(courseList.get(i).toString());
            checkboxContainer.getChildren().add(chBox);
            checkBoxHolder.add(chBox);
        }

        for (int i = 0; i < checkBoxHolder.size(); i++) {
            cbHandler = new CheckBoxHandler(courseList.get(i));
            checkBoxHolder.get(i).setOnAction(cbHandler);
            checkBoxHandler.add(cbHandler);
        }
    }

    //Step 2.2: Create a ButtonHandler class
   private class ButtonHandler implements EventHandler<ActionEvent>
   {
    public void handle(ActionEvent e)
    {        
        Button source = (Button) e.getSource();

        try {
            if (source.equals(addBtn) && !tfCourseNum.getText().isEmpty() && !tfInstructor.getText().isEmpty()) //checks to see if both text fields are empty
            {
                numCourses = courseList.size();
                String subject = courses.getValue();
                int courseNum = Integer.parseInt(tfCourseNum.getText());
                String instructorName = tfInstructor.getText();
                boolean isDuplicate = false;

                Course newCourse = new Course(subject, courseNum, instructorName);

                //need to check whether the course already exist inside the courseList or not
                for (int i = 0; i < courseList.size(); i++) {
                    if (courseList.get(i).getSubject().equals(subject) && courseList.get(i).getInstructor().equals(instructorName) && 
                        courseList.get(i).getCourseNum() == courseNum)
                    {
                        bottomLeft.setText("Duplicated course - Not added");
                        bottomLeft.setTextFill(Color.RED);
                        isDuplicate = true;
                        break;
					}
                }
                if (isDuplicate == false) //checks to see if there are duplicated courses in courseList
                {
                    courseList.add(newCourse);
                    updateCheckBoxContainer();
                    bottomLeft.setText("Course added successfully");
                    bottomRight.setText("Total courses enrolled: " + numCourses);
                }
                //Clear all the text fields and prepare for the next entry;
                }
                else if (source.equals(addBtn) && tfInstructor.getText().isEmpty() || source.equals(addBtn) && 
                         tfCourseNum.getText().isEmpty()) //">=" button is pressed, but one of the text field is empty
                {
                    bottomLeft.setText("At least one field is empty. Fill all fields");
                    bottomLeft.setTextFill(Color.RED);
                }
                else if (source.equals(dropBtn)) //when "Drop Course" button is pushed.)
                {
                    for (int i = 0; i < checkBoxHolder.size(); i++) {
                        if (checkBoxHolder.get(i).isSelected()) {
                            updateCheckBoxContainer();
                            numCourses = courseList.size();
                            bottomRight.setText("Total courses enrolled: " + numCourses);
                        }
                    }
                }
                else  //  for all other invalid actions, thrown an exception and it will be caught
                {
                    throw new Exception();
                }

                //clears the text fields
                tfCourseNum.clear();
                tfInstructor.clear();

            } //end of try

            catch(NumberFormatException ex)
            {
                bottomLeft.setText("Error! Course number must be an integer");
                bottomLeft.setTextFill(Color.RED);
            }

            catch(Exception exception)
            {
                //----
            }
        } //end of handle() method
    } //end of ButtonHandler class

    ////Step 2.3: A ComboBoxHandler
    private class ComboBoxHandler implements EventHandler<ActionEvent>
    {
       //----

    }//end of ComboBoxHandler

    //Step 2.4: A CheckBoxHandler
    private class CheckBoxHandler implements EventHandler<ActionEvent>
    {
        // Pass in a Course object so that we know which course is associated with which CheckBox
        private Course oneCourse;

        //constructor
        public CheckBoxHandler(Course oneCourse)
        {
           this.oneCourse = oneCourse;
        }
        public void handle(ActionEvent e)
        {
            courseList.remove(oneCourse);
        }
    }//end of CheckBoxHandler
} //end of CoursePane class