

package movie.databasetables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class movie_genre {
    public void insert(Connection conn) {
        int status = 0;

        try {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = conn.prepareStatement("insert into movie_genre values (0001, 1, 0001),\n"
                        + "(0002, 2, 0002),\n"
                        + "(0003, 2, 0001),\n"
                        + "(0004, 3, 0002),\n"
                        + "(0005, 3, 0003),\n"
                        + "(0006, 3, 0004),\n"
                        + "(0007, 4, 0002),\n"
                        + "(0008, 4, 0001),\n"
                        + "(0009, 5, 0001),\n"
                        + "(0010, 5, 0002),\n"
                        + "(0011, 6, 0003),\n"
                        + "(0012, 6, 0005),\n"
                        + "(0013, 7, 0004),\n"
                        + "(0014, 7, 0003),\n"
                        + "(0015, 7, 0005),\n"
                        + "(0016, 8, 0001),\n"
                        + "(0017, 8, 0006),\n"
                        + "(0018, 9, 0007),\n"
                        + "(0019, 9, 0001),\n"
                        + "(0020, 9, 0005),\n"
                        + "(0021, 10, 0008),\n"
                        + "(0022, 10, 0002);");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("22 rows inserted into movie_genre table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public void update(Connection conn, int movie_genre_id, int genre_movie_id, int genre_genre_id) {
        int status = 0;
        try {
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = conn.prepareStatement("update movie_genre set genre_movie_id=?, genre_genre_id=? where movie_genre_id=?"); //update query
            pstmt.setInt(1, genre_movie_id);
            pstmt.setInt(2, genre_genre_id);
            pstmt.setInt(3, movie_genre_id);
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
            pstmt = conn.prepareStatement("delete from movie_genre where movie_genre_id=?"); //delete query
            pstmt.setInt(1, id);
            status = pstmt.executeUpdate();

            pstmt.close();

            if (status > 0) { //checking if record has been deleted or not
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Couldn't delete record, some error occured!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(actor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void read(Connection conn) {

        JSONObject record = new JSONObject();
        try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("select * from movie_genre");

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    record.put("movie_genre_id", rs.getString("movie_genre_id"));
                    record.put("genre_movie_id", rs.getString("genre_movie_id"));
                    record.put("genre_genre_id", rs.getString("genre_genre_id"));
                    System.out.println(record);
                }

                pstmt.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
