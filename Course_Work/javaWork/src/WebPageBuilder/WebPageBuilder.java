package WebPageBuilder;
import java.util.Scanner;

public class WebPageBuilder {
    public static void main(String[] args) {
        System.out.println("******************************************************"); // HEADING 
        System.out.println("                   WEBPAGE BUILDER V1.0               ");
        System.out.println("******************************************************");
        System.out.println("");
        System.out.println("This application helps you build a basic web page");
        System.out.println("by asking you a series of questions. Just awsner");
        System.out.println("each question, and I'll populate your new web page");
        System.out.println("with your responses.");
        System.out.println("");

        Scanner sc = new Scanner(System.in); // Starts the new scanner to read input 
        System.out.print("What is your name? ");
        String name = sc.nextLine();
        System.out.print("How old are you? ");
        int age = sc.nextInt();
        sc.nextLine(); // Clears eol white space 
        int ageMonths = age * 12;
        System.out.print("Where do you live? ");
        String location = sc.nextLine();
        System.out.print("When you grow up, you want to be.... ");
        String career = sc.nextLine();
        System.out.print("What are your two favorite integers? ");
        int faveNumber1 = sc.nextInt();
        int faveNumber2 = sc.nextInt();
        double quotient = (double) faveNumber1 / faveNumber2; // creates a double from two ints division 
        System.out.println("Here is the code for your web page: ");
        
        System.out.println("<html>"); // Output of all the awnser into a html file style code 
        System.out.printf("<head><title>%s's Web Page</title</head>\n", name);
        System.out.println("<body>");
        System.out.printf("<h1>Welcome to %s's Web Page</h1>\n", name);
        System.out.printf("<p> I am %d years (or %d months!) old and live in %s.</p>\n", age, ageMonths, location);
        System.out.printf("<p>When I grow up I want to be %s.</p>\n", career);
        System.out.printf("<p>My two favorite integers are %d and %d. Their quotient is %.3f.</p>\n", faveNumber1, faveNumber2, quotient);
        System.out.println("<p>Thank you for visiting my page!</p>");
        System.out.println("</body>");
        System.out.println("</html>");

        // End of program 


    }
    
}
