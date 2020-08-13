package Ask;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
    private Scanner input = new Scanner(System.in);
    private int user_id = 1;
    private boolean anonymous = true;
    private String anonymous_string;

    public void user_list(){}

    public void userFlow() {
        user_id++;
        System.out.println("your id is:" + user_id);
        System.out.println("if you want to allow anonymous questions enter 1, else enter -1 ");
        int in = input.nextInt();
        switch (in) {
            case 1:
                anonymous = true;
                anonymous_string="anonymous allowed";
            case -1:
                anonymous = false;
                anonymous_string="anonymous not allowed";
        }

        try {
            FileWriter user_file = new FileWriter("user.txt");
            user_file.write(user_id);
            user_file.write(anonymous_string);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
