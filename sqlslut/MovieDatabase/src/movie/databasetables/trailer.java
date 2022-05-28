
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


public class trailer {

    static Connection con;

    public static void insert() {
        int status = 0;

        try {
            try (Connection con = getConnection.getConnection()) {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = con.prepareStatement("insert into trailer values (0001, '2' , 'https://www.imdb.com/video/vi3877612057/?playlistId=tt0111161?ref_=ext_shr_lnk', 1),\n"
                        + "(0002, '1' , 'https://www.imdb.com/video/vi1348706585/?playlistId=tt0068646?ref_=ext_shr_lnk', 2),\n"
                        + "(0003, '0', 'https://www.imdb.com/video/vi324468761/?playlistId=tt0468569?ref_=ext_shr_lnk', 3),\n"
                        + "(0004, '2', 'https://www.imdb.com/video/vi2924462873/?playlistId=tt0050083?ref_=ext_shr_lnk', 4),\n"
                        + "(0005, '2', 'https://www.imdb.com/video/vi1158527769/?playlistId=tt0108052?ref_=ext_shr_lnk', 5),\n"
                        + "(0006, '1', 'https://www.imdb.com/video/vi718127897/?playlistId=tt0167260?ref_=ext_shr_lnk', 6),\n"
                        + "(0007, '1', 'https://www.imdb.com/video/vi2620371481/?playlistId=tt0110912?ref_=ext_shr_lnk', 7),\n"
                        + "(0008, '3', 'https://www.imdb.com/video/vi3416964889/?playlistId=tt0060196?ref_=ext_shr_lnk', 8),\n"
                        + "(0009, '3',null, 9),\n"
                        + "(0010, '2', 'https://www.imdb.com/video/vi781228825/?playlistId=tt0137523?ref_=ext_shr_lnk', 10),\n"
                        + "(0011, '1', 'https://www.imdb.com/video/vi2959588889/?playlistId=tt1375666?ref_=ext_shr_lnk', 11);");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("11 rows inserted into trailer table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    public static void update(int trailer_id, int trailer_length, String trailer_url, int trailer_movie_id) {
        int status = 0;
        try {
            con = getConnection.getConnection(); //establishing the database connection
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("update trailer set trailer_length=?, trailer_url=?, trailer_movie_id=? where trailer_id=?"); //update query
            pstmt.setInt(1, trailer_length);
            pstmt.setString(2, trailer_url);
            pstmt.setInt(3, trailer_movie_id);
            pstmt.setInt(4, trailer_id);
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
            pstmt = con.prepareStatement("delete from trailer where trailer_id=?"); //delete query
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
                pstmt = con.prepareStatement("select * from trailer");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    record.put("trailer_id", rs.getString(1));
                    record.put("trailer_length", rs.getString(2));
                    record.put("trailer_url", rs.getString(3));
                    record.put("trailer_movie_id", rs.getString(4));
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
