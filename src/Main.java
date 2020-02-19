import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;
        boolean correctInput;

        //do-while loop that gives the user the option to print the logo however many times they want
        do {
            //do-while loop that verifies the user input -> only an odd number between 2 and 10000 will pass
            do {
                try {
                    do {
                        System.out.println("Please enter an odd number of your choosing(2 < n < 10 000); Type 0 to exit");
                        String input = in.next();
                        num = Integer.parseInt(input);

                        //breaks the loop, so that the use can exit the program
                        if(num == 0){
                            break;
                        }
                    } while (num % 2 == 0 || num < 2 || num > 10000);
                    correctInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect input type!");
                    correctInput = false;
                }
            } while (!correctInput);

            //creates an new DrawLogo object and uses the method "drawLogo" in order to draw the logo with num as the parameter
            if(num != 0){
                DrawLogo logo = new DrawLogo(num);
                logo.drawLogo();
            }

        } while(num != 0);

        //notifies the user that they have exited the program
        System.out.print("Thank you for using our logo creator!");
    }

}
