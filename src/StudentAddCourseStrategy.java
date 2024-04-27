import java.util.Scanner;

public class StudentAddCourseStrategy implements AddCourseStrategy {

    @Override
    public void addCourse(String currentUserName) {

        while (true) {
            try {
                ManagerCourse.getInstance().printAllCourses();
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter the number of the course you want to add: ");
                int courseNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Retrieve the chosen course
                Course chosenCourse = ManagerCourse.getInstance().getCourseByNumber(courseNumber);
                // Check if the chosen course is valid
                if (chosenCourse != null) {
                    if(!ManagerCourse.getInstance().hasSpaceForMoreStudents(courseNumber)){
                        System.out.println("The course is currently full. Do you want to receive a message when there is space available? (yes/no)");
                        String response = scanner.nextLine().trim().toLowerCase();

                        if (response.equals("yes")) {
                            // Logic to subscribe the user for notifications when there is space available
                            // You can implement this logic based on your application's requirements
                            // For example, you might have a method to add a user to a notification list for the course
                            // ManagerCourse.getInstance().addNotificationSubscriber(user, courseNumber);
                        }
                        break;
                    }
                    // Call the addCourse method of ManagerCourse to add the chosen course
                    ManagerCourse.getInstance().getCourseByNumber(courseNumber).incrementParticipantCounter();
                    ((Student) UserManagerSingleton.getInstance().getUserByUserName(currentUserName)).addCourse(chosenCourse);
                    System.out.println("Course added.");
                    break;
                } else {
                    System.out.println("Invalid course number. Course not added.");
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage()); // Print the exception message
            }
        }
    }
}
