package Ask;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainPage {
    Question question_main = new Question();
    User user = new User();

    public void mainMenu(){
        System.out.println("Menu: ");
        System.out.println("\t 1-log in");
        System.out.println("\t 2-Sign up");
        System.out.println("Enter a number in range(1-2): ");
        Scanner input = new Scanner(System.in);
        int mainChoice= input.nextInt();
        switch (mainChoice){
            case 1:
                signIn();
            case 2:
                signUp();
            default:
                System.out.println("invalid, try again");
        }
    }

    private void readFiles(String user){
        Scanner input = new Scanner(System.in);
        boolean ah = false;
        try {
            FileReader users = new FileReader("users.txt");
            Scanner myReader = new Scanner(users);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals(user))
                {
                    System.out.println("good");
                    ah=true;
                    break;
                }
                else if (!(data.equals(user)))
                {
                    ah=false;
                }
            }
            if (ah==false) {
                System.out.println("invalid data,try again");
                System.exit(0);
            }
        }
        catch (Exception e) {
            System.out.println("system 00");

        }
    }


    private void signIn(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you username: ");
        String username=input.next();
        readFiles(username);
        System.out.println("Enter your password");
        String password =input.next();
        readFiles(password);

        System.out.println("Menu: ");
        System.out.println("\t 1-print questions to me.");
        System.out.println("\t 2-print questions from me.");
        System.out.println("\t 3-answer question");
        System.out.println("\t 4-delete question");
        System.out.println("\t 5-ask question ");
        System.out.println("\t 6-list system users");
        System.out.println("\t 7-feed");
        System.out.println("\t 8-logout");
        System.out.println("Enter a number in range(1-8): ");
        // questions files
        int choice2=input.nextInt();
        switch (choice2){
            case 1:
                question_main.question_To_me();
            case 2:
                question_main.question_From_me();
            case 3:
                question_main.answer_question();
            case 4:
                question_main.delete_question();
            case 5:
                question_main.askQuestion();
            case 6:
                user.user_list();
            case 7:

            case 8:
                mainMenu();
            default:
                System.out.println("Error");
                System.exit(0);
        }
    }

    private void signUp(){
        Scanner input = new Scanner(System.in);
        System.out.println("your name: ");
        String name = input.next();
        System.out.println("E-mail: ");
        String email = input.next();
        System.out.println("username: ");
        String username = input.next();
        System.out.println("password: ");
        String password = input.next();
        try {
            FileWriter myWriter = new FileWriter("users.txt");
            myWriter.write(name);
            myWriter.write(email);
            myWriter.write(username);
            myWriter.write(password);
        }
        catch (IOException e){
            System.out.println("file not found");
        }
        user.userFlow();
        signIn();
    }

}
