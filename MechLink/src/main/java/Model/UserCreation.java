package Model;

import View.LoginView;
import View.SignUpView;

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

    public static void createUser(String userName, String password, String firstName, String lastName, String zipCode, boolean isMechanic) {
        String sql = "INSERT INTO Logins(userName, password, isMechanic) VALUES(?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            // Sets isMechanic to 1 if mechanic, 0 if client
            pstmt.setInt(3, isMechanic ? 1 : 0);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (isMechanic) {
            System.out.println("True");
            String mechSQL = "INSERT INTO Mechanics(first_name, last_name, zipcode, userName) VALUES(?,?,?,?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(mechSQL)) {
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, zipCode);
                pstmt.setString(4, userName);
                pstmt.executeUpdate();
                System.out.println(firstName + lastName + zipCode + userName);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            String clientSQL = "INSERT INTO Clients(first_name, last_name, zipcode, userName) VALUES(?,?,?,?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(clientSQL)) {
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, zipCode);
                pstmt.setString(4, userName);
                pstmt.executeUpdate();
                System.out.println(firstName + lastName + zipCode + userName);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        // Changes currentUser to match new user in database
        CurrentUser.setCurrentUserName(userName);
        CurrentUser.setIsMechanic(isMechanic);
        System.out.println(CurrentUser.CurrentUserData());
    }


}