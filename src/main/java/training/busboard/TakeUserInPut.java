package training.busboard;
import java.util.Scanner;
import java.lang.invoke.StringConcatFactory;

public class TakeUserInPut {

    
    public void takeUserInput(){

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter you code");

    String userName = myObj.nextLine();  // Read user input
    System.out.println("Username is: " + userName);  // Output user input
    }
}
