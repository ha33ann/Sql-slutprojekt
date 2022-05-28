
package movie.databasetables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import movie.DatabaseConnection.getConnection;
import org.json.simple.JSONObject;


public class band {
    static Connection con;
    public static void insert() {
        int status = 0;

        try {
            try (Connection con = getConnection.getConnection()) {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = con.prepareStatement("insert into band values (0001, 'Dope', 11),\n"
                        + "(0002, 'Sing Street', 6),\n"
                        + "(0003, 'Steel Dragon', 7),\n"
                        + "(0004, 'The Weird Sisters', 2),\n"
                        + "(0005, 'Kool and the Gang',25),\n"
                        + "(0006, 'The Prodigy', 7),\n"
                        + "(0007, 'Rammstein', 6);");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("7 rows inserted into band table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        public static void update(int band_id, String band_name, int band_total_members) {
        int status = 0;
        try {
            con = getConnection.getConnection(); //establishing the database connection
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("update band set band_name=?, band_total_members=? where band_id=?"); //update query
            pstmt.setString(1, band_name);
            pstmt.setInt(2, band_total_members);
            pstmt.setInt(3, band_id);
            status = pstmt.executeUpdate(); //executing the query
            pstmt.close();
            con.close();

            if (status > 0) { //checking if record has been updated or not
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("Couldn't update record, some error occured!");

            }

        } catch (SQLException ex) { //catching the exception
            Logger.getLogger(actor.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void delete(int id) {
        int status = 0;
        try {
            Connection con = getConnection.getConnection(); //establishing the database connection 
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("delete from band where band_id=?"); //delete query
            pstmt.setInt(1, id);
            status = pstmt.executeUpdate();

            pstmt.close();
            con.close();

            if (status > 0) { //checking if record has been deleted or not
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Couldn't delete record, some error occured!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(actor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void read() {

        JSONObject record = new JSONObject();
        try {
            try (Connection con = getConnection.getConnection()) {
                PreparedStatement pstmt = null;
                pstmt = con.prepareStatement("select * from band");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    record.put("band_id", rs.getString(1));
                    record.put("band_name", rs.getString(2));
                    record.put("band_total_members", rs.getString(3));
                    System.out.println(record);
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
