package gymmembershipv1;

import java.util.Scanner;

public class ManageCoach {
    
     public static void Menu(){
        
    Scanner sc = new Scanner(System.in);
    
        System.out.println("=====================================");
        System.out.println("|            Coach MENU             |");
        System.out.println("=====================================");
        System.out.println("| 1. Add Coach                      |");
        System.out.println("| 2. View Coach                     |");
        System.out.println("| 3. Update Coach                   |");
        System.out.println("| 4. Delete Coach                   |");
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
        System.out.print("Coach First Name: ");
        String fname = sc.next();
        System.out.print("Coach Last Name: ");
        String lname = sc.next();
        System.out.print("Coach Email: ");
        String email = sc.next();
        System.out.print("Coach Phone Number: ");
        String phone = sc.next();
        System.out.print("Specialization: ");
        String specs = sc.next();

        String sql = "INSERT INTO tbl_coaches (F_NAME, L_NAME, EMAIL, PHONE, SPECS) VALUES (?, ?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, email, phone, specs);

    }

    public static void delete(){
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        
        String sql = "DELETE FROM tbl_coaches WHERE CO_ID = ?";
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
        
        System.out.print("Enter New Email: ");
        String email = sc.next(); // Use nextLine() to capture the entire input
        
        System.out.print("Enter New Phone: ");
        String phone = sc.next(); // Use nextLine() to capture the entire input
        
        System.out.print("New Specialization: ");
        String specs = sc.next();
        
        String qry = "UPDATE tbl_coaches SET F_NAME = ?, L_NAME = ?, EMAIL = ?, PHONE = ?, SPECS = ? WHERE CO_ID = ?";
       
        conf.updateRecord(qry, Fname, Lname, email, phone, specs, id);
        
    }

    public static void view() {
        config conf = new config();
         
        String votersQuery = "SELECT * FROM tbl_coaches";
        String[] votersHeaders = {"ID", "First Name", "Last Name", "Email", "Phone Number", "Specialization"}; // DISPLAY RANI (DI MO MATTER)
        String[] votersColumns = {"CO_ID", "F_NAME", "L_NAME", "EMAIL", "PHONE", "SPECS"}; // SHOULD EXACTLY MATCH UNSAY NAA SA DATABASE

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    
}
