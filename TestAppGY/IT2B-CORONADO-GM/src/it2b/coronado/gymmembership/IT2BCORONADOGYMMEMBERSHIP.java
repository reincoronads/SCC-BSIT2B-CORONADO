package it2b.coronado.gymmembership;

import java.util.Scanner;

public class IT2BCORONADOGYMMEMBERSHIP {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String response;
        
        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.println("Enter Action: ");
            int action = sc.nextInt();

            switch(action){

                case 1:
                    addMembers();
                    break;

                case 2:
                    viewMembers();
                    break;    

               case 3:
                    break;     

               case 4:
                    break;

               case 5:
                    break; 
            }

            System.out.println("Do you want to continue? (Y/N): ");
            response = sc.next();
        
        }while(response.equalsIgnoreCase("y"));
      
    }
    
     public static void addMembers(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Student First Name: ");
        String fname = sc.next();
        System.out.print("Student Last Name: ");
        String lname = sc.next();
        System.out.print("Student Email: ");
        String email = sc.next();
        System.out.print("Student Status: ");
        String status = sc.next();

        String sql = "INSERT INTO members (F_NAME, L_NAME, EMAIL, STATUS) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, email, status);

    }
     
     public static void viewMembers() {
        config conf = new config();
         
        String votersQuery = "SELECT * FROM members";
        String[] votersHeaders = {"ID", "First Name", "Last Name", "Email", "Status"};
        String[] votersColumns = {"id", "F_NAME", "L_NAME", "EMAIL", "STATUS"};

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    
}
