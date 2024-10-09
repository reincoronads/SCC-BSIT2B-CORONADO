package gymmembershipv1;

import java.util.Scanner;

public class GymMembershipV1 {

public static void main(String[] args) {
        
     Scanner sc = new Scanner(System.in);
        String response;
        
        do {
            System.out.println("**WELCOME TO GYM MEMBERSHIP**");
            System.out.println("1. Membership");
            System.out.println("2. Active List");
            System.out.println("3. Reports");
            System.out.println("4. Exit");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();

            switch(action){
                case 1:
                    addMenu();
                    break;
                case 2:      
                    break;    
               case 3:
                    break;     
               case 4:
                    break;
            }

            System.out.println("Do you want to continue? (Y/N): ");
            response = sc.next();
        
        }while(response.equalsIgnoreCase("y"));
    
    }

public static void addMenu(){
    
    Scanner sc = new Scanner(System.in);
    
        System.out.println("    1. Member");
        System.out.println("    2. Coach");
        System.out.print("    Select Action: ");
        int action = sc.nextInt();
        
        switch(action){
            case 1:
                memberCRUD();
                break;
                
        }
        
}

public static void memberCRUD(){
    Scanner sc = new Scanner(System.in);
    
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.print("Select Action: ");
            int action = sc.nextInt();

            switch(action){
                case 1:
                    addMembers();
                    break;
                case 2:
                    viewMembers();
                    break;

        }
}

//Add moore Attributes
public static void addMembers(){
    
        Scanner sc = new Scanner(System.in);
        
        config conf = new config();
        System.out.print("Member First Name: ");
        String fname = sc.next();
        System.out.print("Member Last Name: ");
        String lname = sc.next();
        System.out.print("Member Type: ");
        String type = sc.next();
        System.out.print("Member Status: ");
        String status = sc.next();

        String sql = "INSERT INTO member (Fname, Lname, Type, Status) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, type, status);

    }

public static void viewMembers() {
        config conf = new config();
         
        String votersQuery = "SELECT * FROM member";
        String[] votersHeaders = {"ID", "First Name", "Last Name", "Type", "Status"};
        String[] votersColumns = {"Id", "Fname", "Lname", "Type", "Status"};

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }

}
