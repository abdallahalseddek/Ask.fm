package Ask;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Question {
   private Scanner input = new Scanner(System.in);
    private int user_id= 1;
    private int question_id= 1;
    private String question;

    public void question_To_me(){}

    public void question_From_me(){}

    public void answer_question(){}

    public void delete_question(){}

    public void askQuestion(){

        question_id++;
        System.out.println("Enter user id or -1 to cancel");
        user_id=input.nextInt();
        if (user_id==-1){
            System.exit(0);
        } else {
            try {
                FileReader fileReader = new FileReader("users.txt");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Enter your question: ");
        question = input.next();

        try {
            FileWriter fileWriter = new FileWriter("question.txt");
            fileWriter.write("question id(" + question_id +") " + question);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
