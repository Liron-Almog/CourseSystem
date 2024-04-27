    import java.io.IOException;
    import java.util.InputMismatchException;
    import java.util.Scanner;

    public class DeleteCommand implements Command {

        String username;
        public DeleteCommand(String username) {
            this.username = username;
        }

        @Override
        public boolean execute() {
            try {
                ((Student) UserManagerSingleton.getInstance().getUserByUserName(this.username)).print();
                Scanner scanner = new Scanner(System.in);
                // Ask for the course number to delete
                System.out.print("Enter the number of the course you want to delete: ");
                int courseNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                ((Student)UserManagerSingleton.getInstance().getUserByUserName(this.username)).deleteCourse(courseNumber);
                System.out.println("The Course deleted successfully.");
                return false; // Do not return to the previous menu
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                return false; // Do not return to the previous menu
            }

        }
    }