import java.util.Scanner;

public class RegisterCommand implements Command {

    @Override
    public boolean execute() {
        Scanner scanner = new Scanner(System.in);
        boolean registrationSuccess = false;

        do {
            System.out.print("To return to the previous menu, enter '0' as the username:\nEnter new username: ");
            String username = scanner.nextLine();

            if (username.equals("0")) {
                return false; // Return to previous menu
            }
            System.out.print("Enter password: ");
            String password = scanner.nextLine();


            registrationSuccess = UserManagerSingleton.getInstance().register(EntityFactory.create(Student.class,username,password));

        } while (!registrationSuccess);
        return false; // Do not return to the previous menu
    }
}