
package movie.databasetables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class movie_studio {
    public void insert(Connection conn) {
        int status = 0;

        try {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = conn.prepareStatement("insert into movie_studio values (0001, 1, 1),\n"
                        + "(0002, 2, 2),\n"
                        + "(0003, 3, 3),\n"
                        + "(0004, 4, 4),\n"
                        + "(0005, 5, 5),\n"
                        + "(0006, 6, 3),\n"
                        + "(0007, 7, 3),\n"
                        + "(0008, 8, 7),\n"
                        + "(0009, 9, 3),\n"
                        + "(0010, 10, 3),\n"
                        + "(0011, 11, 2);");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("11 rows inserted into movie_studio table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public void update(Connection conn, int movie_studio_id, int studio_movie_id, int studio_studio_id) {
        int status = 0;
        try {
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = conn.prepareStatement("update movie_studio set studio_movie_id=?, studio_studio_id=? where movie_studio_id=?"); //update query
            pstmt.setInt(1, studio_movie_id);
            pstmt.setInt(2, studio_studio_id);
            pstmt.setInt(3, movie_studio_id);
            status = pstmt.executeUpdate(); //executing the query
            pstmt.close();
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


    public void delete(Connection conn, int id) {
        int status = 0;
        try {
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            pstmt1.executeUpdate();
            pstmt = conn.prepareStatement("delete from movie_studio where movie_studio_id=?"); //delete query
            pstmt.setInt(1, id);
            status = pstmt.executeUpdate();

            pstmt.close();

            if (status > 0) { //checking if record has been deleted or not
                System.out.println("Deleted record successfully1");
            } else {
                System.out.println("Couldn't delete record some error occured!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(actor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void read(Connection conn) {

        JSONObject record = new JSONObject();
        try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("select * from movie_studio");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    record.put("movie_studio_id", rs.getString(1));
                    record.put("studio_movie_id", rs.getString(2));
                    record.put("studio_studio_id", rs.getString(3));
                    System.out.println(record);
                }

                pstmt.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
