import java.util.Scanner;

public class WelcomeScreen {

    public  WelcomeScreen() {
        System.out.println("\nTravel Reimbursement System ! Please Make A Selection:\n"
                + "1) Employees Who Need To Submit a Reimbursement Request\n"
                + "2) Admin Login \n"
                + "Enter: To Exit System!");

        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                System.out.println("We will now create your travel reimbursement request!");
                break;
            case 2:
                System.out.println("Welcome Admin, Please use your personal credentials to log into the system");
                break;
            default:
                System.out.println("EXIT!");
                break;
        }

           sc.close();




    }



}
