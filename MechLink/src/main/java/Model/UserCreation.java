package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UserCreation {

    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:MechlinkData.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createUser (String firstName, String lastName, String address, String phoneNumber, String zipCode,String userName, String password, boolean selectedType){
            String sql = "INSERT INTO Logins(userName, password, isMechanic) VALUES(?,?,?)";

            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, userName);
                pstmt.setString(2, password);
                //Sets isMechanic to 1 if mechanic, 0 if client
                if (selectedType){
                    pstmt.setInt(3, 1);
                }else{
                    pstmt.setInt(3, 0);
                }
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        if(selectedType){
            String mechSQL = "INSERT INTO Mechanics(first_name, last_name, zipcode, userName) VALUES(?,?,?,?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, String.valueOf(zipCode));
                pstmt.setString(4, userName);
                pstmt.executeUpdate();
                System.out.println(firstName + lastName + zipCode + userName);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            String clientSQL = "INSERT INTO Clients(first_name, last_name, zipcode, userName) VALUES(?,?,?,?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, String.valueOf(zipCode));
                pstmt.setString(4, userName);
                pstmt.executeUpdate();
                System.out.println(firstName + lastName + zipCode + userName);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
        //