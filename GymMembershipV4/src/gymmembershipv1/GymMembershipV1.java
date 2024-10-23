package gymmembershipv1;

import java.util.Scanner;

public class GymMembershipV1 {

public static void main(String[] args) {
        
     Scanner sc = new Scanner(System.in);
     
        String response;
        
        do {
            System.out.println("========================================");
            System.out.println("|   WELCOME TO ONLINE GYM MEMBERSHIP   |");
            System.out.println("========================================");
            System.out.println("|  1. Manage Clients                   |");
            System.out.println("|  2. Manage Coaches                   |");
            System.out.println("|  3. Manage Programs                  |");
            System.out.println("|  4. Membership                       |");
            System.out.println("|  5. Exit                             |");
            System.out.println("========================================");
            System.out.print("Please select an action (1-5): ");


            int action = sc.nextInt();

            switch(action){
                case 1:
                    ManageClient.Menu();
                    break;
                case 2:
                    ManageCoach.Menu();
                    break;    
               case 3:
                    ManageProgram.Menu();
                    break;     
               case 4:
                    ManageMembership.Menu();
                    break;
               case 5:
                    System.exit(0); 
                    break;    
               default:
                    System.out.println("\nError Input! Try Again: ");     
            }

            System.out.println("Do you want to continue? (Y/N): ");
            response = sc.next();
        
        }while(response.equalsIgnoreCase("y"));
    
    }

}
