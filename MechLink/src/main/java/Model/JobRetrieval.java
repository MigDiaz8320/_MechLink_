package Model;

import java.sql.*;

public class JobRetrieval {
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
    public static String RetrieveOpenJobs(){
        StringBuilder JobList = new StringBuilder();
        String sql = "SELECT Job_ID, UserName, Address, Car_Model, Description, Date_Posted FROM Jobs WHERE Accepted = 0";
        try (Connection conn = connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
//                System.out.println(rs.getInt("Job_ID") +  "\t" +
//                        rs.getString("UserName") + "\t" +
//                        rs.getString("Address")+ "\t" +
//                        rs.getString("Car_Model")+ "\t" +
//                        rs.getString("Description")+ "\t" +
//                        rs.getString("Date_Posted"));
                JobList.append(rs.getInt("Job_ID")).append(";").append(rs.getString("UserName")).append(";").append(rs.getString("Address")).append(";").append(rs.getString("Car_Model")).append(";").append(rs.getString("Description")).append(";").append(rs.getString("Date_Posted")).append("|");
            }
            System.out.println(JobList);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return JobList.toString();
    }
}
