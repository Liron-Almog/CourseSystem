import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Student extends Entity {

    private List<Course> myCourses;

    public Student(String userName, String password) {
        super(userName, password);
        addCourseStrategy = new StudentAddCourseStrategy();
        this.myCourses = new ArrayList<>();
    }

    public Student() {
        super();
    }

    public void addCourse(Course course) {
        myCourses.add(course);
    }
    public void print()
    {
        int index = 1;
        for (Course course : myCourses) {
            System.out.println(index + ". " + course);
            index++;
        }
    }
    public int numberOfCourses()
    {
        return this.myCourses.size();
    }

    public void deleteCourse(int courseNumber) {

        if (courseNumber <= 0 || courseNumber > myCourses.size()) {
            throw new InputMismatchException("Invalid course number.");
        }
        Course temp = myCourses.get(courseNumber-1);
        ManagerCourse.getInstance().decPlaceInCourseByName(temp.getName());
        myCourses.remove(courseNumber - 1);
    }

}
