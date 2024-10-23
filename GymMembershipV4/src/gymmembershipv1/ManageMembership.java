package gymmembershipv1;

import java.util.Scanner;

public class ManageMembership {
    
    public static void Menu(){
        
    Scanner sc = new Scanner(System.in);
    
        System.out.println("=========================================");
        System.out.println("|           MEMBERSHIP MENU             |");
        System.out.println("=========================================");
        System.out.println("| 1. Add Member                         |");
        System.out.println("| 2. View Members                       |");
        System.out.println("| 3. Update Member                      |");
        System.out.println("| 4. Delete Member                      |");
        System.out.println("=========================================");
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
        System.out.print("Enter Client ID: ");
        int c_id = sc.nextInt();
        
        System.out.print("Enter Program ID: ");
        int p_id = sc.nextInt();
        
        System.out.print("Enter Coach ID: ");
        int co_id = sc.nextInt();
        
        System.out.print("Member Start Date: ");
        String start_date = sc.next();
        
        System.out.print("Member End Date: ");
        String end_date = sc.next();
        
        System.out.print("Member Status: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_membership (C_ID, P_ID, CO_ID, START_DATE, END_DATE, STATUS) VALUES (?, ?, ?, ?, ?, ?)";

        conf.addRecord(sql, c_id, p_id, co_id, start_date, end_date, status);

    }

    public static void delete(){
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        
        String sql = "DELETE FROM tbl_membership WHERE M_ID = ?";
        conf.deleteRecord(sql, id);

    }


    public static void edit(){
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter ID to edit: ");
        int id = sc.nextInt();
        
        System.out.print("New Client ID: ");
        int c_id = sc.nextInt();
        
        System.out.print("New Program ID: ");
        int p_id = sc.nextInt();
        
        System.out.print("New Coach ID: ");
        int co_id = sc.nextInt();
        
        System.out.print("New Start Date: ");
        String start_date = sc.next();
        
        System.out.print("New End Date: ");
        String end_date = sc.next();
        
        System.out.print("New Status: ");
        String status = sc.next();
        
        String qry = "UPDATE tbl_membership SET C_ID = ?, P_ID = ?, CO_ID = ?, START_DATE = ?, END_DATE = ?, STATUS = ? WHERE M_ID = ?";
       
        conf.updateRecord(qry, c_id, p_id, co_id, start_date, end_date, status, id);
        
    }

    public static void view() {
        config conf = new config();
         
        String votersQuery = "SELECT * FROM tbl_membership";
        String[] votersHeaders = {"Member ID", "Client ID", "Program ID", "Coach ID", "Start Date" , "End Date", "Status"}; // DISPLAY RANI (DI MO MATTER)
        String[] votersColumns = {"M_ID", "C_ID", "P_ID", "CO_ID", "START_DATE", "END_DATE", "STATUS"}; // SHOULD EXACTLY MATCH UNSAY NAA SA DATABASE

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    
}
