package bankaccount;


import java.sql.*;
import java.util.Scanner;

public class AccountBalanceChecker {
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "lalli@2007");
           Scanner sc = new Scanner(System.in);

            System.out.print("Enter Account Number: ");
            int accountNumber = sc.nextInt();
             
            PreparedStatement ps= con.prepareStatement("SELECT acc_no, holder_name, balance FROM accounts WHERE acc_no = ?");
            ps.setInt(1, accountNumber);
         
            System.out.println("\nFetching account details...\n");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("========================================");
                System.out.println("         ACCOUNT DETAILS");
                System.out.println("========================================");
                System.out.println("Account Number : " + rs.getInt("acc_no"));
                System.out.println("Holder Name    : " + rs.getString("holder_name"));
                System.out.println("Balance        : " + rs.getDouble("balance"));
                System.out.println("========================================");
            }
                
            con.close();
        }
    }




    
           