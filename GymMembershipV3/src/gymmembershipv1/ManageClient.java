package gymmembershipv1;

import java.util.Scanner;

public class ManageClient {
    
    public static void Menu(){
        
    Scanner sc = new Scanner(System.in);
    
        System.out.println("=====================================");
        System.out.println("|           CLIENT MENU             |");
        System.out.println("=====================================");
        System.out.println("| 1. Add Client                     |");
        System.out.println("| 2. View Clients                   |");
        System.out.println("| 3. Update Client                  |");
        System.out.println("| 4. Delete Client                  |");
        System.out.println("=====================================");
        System.out.print("Select an action (1-4): ");

        int action = sc.nextInt();

        switch(action){
            case 1:
                add();
                break;
            case 2:
                view();
                break;
            case 3:
                view();
                edit();
                view();
                break;    
            case 4:
                view();
                delete();
                view();
                break;
            default:
                System.out.println("\nError Input! Try Again: ");
                   
        }
    }
    
    public static void add(){
    
        Scanner sc = new Scanner(System.in);
        
        config conf = new config();
        System.out.print("Member First Name: ");
        String fname = sc.next();
        System.out.print("Member Last Name: ");
        String lname = sc.next();
        System.out.print("Member Email: ");
        String email = sc.next();
        System.out.print("Member Phone Number: ");
        String phone = sc.next();

        String sql = "INSERT INTO tbl_clients (F_NAME, L_NAME, EMAIL, PHONE) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, email, phone);

    }

    public static void delete(){
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        
        String sql = "DELETE FROM tbl_clients WHERE C_ID = ?";
        conf.deleteRecord(sql, id);

    }


    public static void edit(){
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter ID to edit: ");
        int id = sc.nextInt();
        
        System.out.print("Enter New First Name: ");
        String Fname = sc.next(); // Use nextLine() to capture the entire input
        
        System.out.print("Enter New Last Name: ");
        String Lname = sc.next(); // Use nextLine() to capture the entire input
        
        System.out.print("Enter Email: ");
        String email = sc.next(); // Use nextLine() to capture the entire input
        
        System.out.print("Enter Phone: ");
        String phone = sc.next(); // Use nextLine() to capture the entire input
        
        String qry = "UPDATE tbl_clients SET F_NAME = ?, L_NAME = ?, EMAIL = ?, PHONE = ? WHERE C_ID = ?";
       
        conf.updateRecord(qry, Fname, Lname, email, phone, id);
        
    }

    public static void view() {
        config conf = new config();
         
        String votersQuery = "SELECT * FROM tbl_clients";
        String[] votersHeaders = {"ID", "First Name", "Last Name", "Email", "Phone Number"}; // DISPLAY RANI (DI MO MATTER)
        String[] votersColumns = {"C_ID", "F_NAME", "L_NAME", "EMAIL", "PHONE"}; // SHOULD EXACTLY MATCH UNSAY NAA SA DATABASE

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    
}
