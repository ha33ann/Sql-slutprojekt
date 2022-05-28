

package movie.databasetables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import movie.DatabaseConnection.getConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class poster {

    static Connection con;

    public static void insert() {
        int status = 0;

        try {
            try (Connection con = getConnection.getConnection()) {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = con.prepareStatement("insert into poster values (0001, 'The Shawshank Redemption', 1),\n"
                        + "(0002, 'The Godfather', 2),\n"
                        + "(0003, 'The Dark Knight',3),\n"
                        + "(0004, '12 Angry Men',4),\n"
                        + "(0005, 'Schindlers List',5),\n"
                        + "(0006, 'The Lord of the Rings' ,6),\n"
                        + "(0007, 'Pulp Fiction',7),\n"
                        + "(0008, null, 8),\n"
                        + "(0009, null, 9),\n"
                        + "(0010, null, 10);");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("10 rows inserted into poster table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update(int poster_id, String poster_title, int poster_movie_id) {
        int status = 0;
        try {
            con = getConnection.getConnection(); //establishing the database connection
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("update poster set poster_title=?, poster_movie_id=? where poster_id=?"); //update query
            pstmt.setString(1, poster_title);
            pstmt.setInt(2, poster_movie_id);
            pstmt.setInt(3, poster_id);
            status = pstmt.executeUpdate(); //executing the query
            pstmt.close();
            con.close();

            if (status > 0) { //checking if record has been updated or not
                System.out.println("Updated record successfully1");
            } else {
                System.out.println("Couldn't update record some error occured!");

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
            pstmt = con.prepareStatement("delete from poster where poster_id=?"); //delete query
            pstmt.setInt(1, id);
            status = pstmt.executeUpdate();

            pstmt.close();
            con.close();

            if (status > 0) { //checking if record has been deleted or not
                System.out.println("Deleted record successfully1");
            } else {
                System.out.println("Couldn't delete record some error occured!");
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
                pstmt = con.prepareStatement("select * from poster");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    record.put("poster_id", rs.getString(1));
                    record.put("poster_title", rs.getString(2));
                    record.put("poster_movie_id", rs.getString(3));
                    System.out.println(record);
                }

                pstmt.close();
                con.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
