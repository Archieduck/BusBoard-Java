package training.busboard;
import java.io.*;
import java.util.Scanner;

public class TakeUserInPut {
    
    private Scanner sc = new Scanner(System.in);
    
    
    public String takeUserInput(){
        String input = sc.nextLine();
        return input;
    }
}
