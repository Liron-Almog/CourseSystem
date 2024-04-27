import java.util.ArrayList;
import java.util.List;

public class ManagerCourse {
    private static ManagerCourse instance;
    private final List<Course> courses;

    private ManagerCourse() {
        this.courses = new ArrayList<>();
    }

    public static ManagerCourse getInstance() {
        if (instance == null) {
            instance = new ManagerCourse();
        }
        return instance;
    }

    public boolean addCourse(Course newCourse) {
        for (Course course : courses) {
            if (course.getId().equals(newCourse.getId())) {
                System.out.println("Course with ID " + newCourse.getId() + " already exists:");
                System.out.println(course); // Print existing course data
                return false;
            }
            if (course.getName().equalsIgnoreCase(newCourse.getName())) {
                System.out.println("Course with name '" + newCourse.getName() + "' already exists:");
                System.out.println(course); // Print existing course data
                return false;
            }
        }

        courses.add(newCourse);
        System.out.println("Course '" + newCourse.getName() + "' added successfully.");
        return true;
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public int getCourseCount() {
        return courses.size();
    }

    public Course getCourseByNumber(int number) {

        int index = number - 1;

        if (index >= 0 && index < this.courses.size()) {
            return courses.get(index);
        } else {
            System.out.println("Course number " + number + " does not exist.");
            return null;
        }
    }

    public void printAllCourses() {
        if (courses.isEmpty()) {
            throw new IllegalStateException("There are no courses available to print.");
        }
        System.out.println("All Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
    }
    public boolean hasSpaceForMoreStudents(int index) {

        return this.courses.get(index-1).getParticipantCounter() < this.courses.get(index-1).getNumberOfParticipants();
    }

    public void decPlaceInCourseByName(String name) {

        for (Course course : courses)
            if (course.getName().equals(name))
                course.setParticipantCounter(course.getParticipantCounter() - 1);

    }
}
