package gymmembershipv1;

import java.util.Scanner;

public class ManageProgram {
    
    public static void Menu(){
        
    Scanner sc = new Scanner(System.in);
    
        System.out.println("======================================");
        System.out.println("|            PROGRAM MENU             |");
        System.out.println("======================================");
        System.out.println("| 1. Add Program                      |");
        System.out.println("| 2. View Program                     |");
        System.out.println("| 3. Update Program                   |");
        System.out.println("| 4. Delete Program                   |");
        System.out.println("======================================");
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
        System.out.print("Program Name: ");
        String pname = sc.nextLine();
        System.out.print("Program Description: ");
        String pdesc = sc.nextLine();
        System.out.print("Program Duration: ");
        String pduration = sc.nextLine();

        String sql = "INSERT INTO tbl_program (P_NAME, P_DESC, P_DURATION) VALUES (?, ?, ?)";


        conf.addRecord(sql, pname, pdesc, pduration);

    }

    public static void delete(){
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        
        String sql = "DELETE FROM tbl_program WHERE P_ID = ?";
        conf.deleteRecord(sql, id);

    }


    public static void edit(){
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter ID to edit: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("New Name: ");
        String pname = sc.nextLine();
        System.out.print("New Description: ");
        String pdesc = sc.nextLine();
        System.out.print("New Duration: ");
        String pduration = sc.nextLine();
        
        String qry = "UPDATE tbl_program SET P_NAME = ?, P_DESC = ?, P_DURATION = ? WHERE P_ID = ?";
       
        conf.updateRecord(qry, pname, pdesc, pduration, id);
        
    }

    public static void view() {
        config conf = new config();
         
        String votersQuery = "SELECT * FROM tbl_program";
        String[] votersHeaders = {"PROGRAM ID", "PROGRAM NAME", "DESCRIPTION", "DURATION"}; // DISPLAY RANI (DI MO MATTER)
        String[] votersColumns = {"P_ID", "P_NAME", "P_DESC", "P_DURATION"}; // SHOULD EXACTLY MATCH UNSAY NAA SA DATABASE

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    
}
