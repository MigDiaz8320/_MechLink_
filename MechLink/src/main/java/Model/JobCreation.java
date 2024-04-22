package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JobCreation {
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

    public static void createJob (LocalDate datePosted, String location, String carModel, String jobDescription){
        String userName = CurrentUser.getCurrentUserName();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedDate = datePosted.format(formatter);
        String sql = "INSERT INTO Jobs(UserName, Accepted, Completed, Address, Car_Model, Description, Date_Posted) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setInt(2, 0);
            pstmt.setInt(3, 0);
            pstmt.setString(4,location);
            pstmt.setString(5,carModel);
            pstmt.setString(6, jobDescription);
            pstmt.setString(7, formattedDate);
            pstmt.executeUpdate();
            System.out.println(userName + location + carModel + formattedDate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
