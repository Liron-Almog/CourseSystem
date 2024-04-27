import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<Option> options = new ArrayList<>();
    private String title;

    public Menu(String title) {
        this.title = title;
    }

    public void add(String name, Command command) {
        options.add(new Option(name, command));
    }

    private void printOptions() {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i).getName());
        }
    }

    public void activate() {
        Scanner scanner = new Scanner(System.in);
        int optionIndex;
        boolean exitFromMenu = false;
        do {
            printOptions();
            System.out.print("Enter your choice (1-" + options.size() + "): ");
            optionIndex = scanner.nextInt();
            if (optionIndex >= 1 && optionIndex <= options.size()) {
                exitFromMenu = options.get(optionIndex - 1).getCommand().execute();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (!exitFromMenu);
    }

    private static class Option {
        private String name;
        private Command command;

        public Option(String name, Command command) {
            this.name = name;
            this.command = command;
        }

        public String getName() {
            return name;
        }

        public Command getCommand() {
            return command;
        }
    }
}
