

package movie.databasetables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import movie.DatabaseConnection.getConnection;
import org.json.simple.JSONObject;

public class song {

    static Connection con;

    public static void insert() {
        int status = 0;

        try {
            try (Connection con = getConnection.getConnection()) {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = con.prepareStatement("insert into song values (0001, 'My funeral' , 3 , 'https://www.youtube.com/watch?v=TUEWnM6nGPo'),\n"
                        + "(0002, 'Take Your best shot', 2, 'https://www.youtube.com/watch?v=Us39YXM5IEM'),\n"
                        + "(0003, 'Du Hast', 3, 'https://www.youtube.com/watch?v=W3q8Od5qJio'),\n"
                        + "(0004, 'Zick Zack', 4, 'https://www.youtube.com/watch?v=hBTNyJ33LWI'),\n"
                        + "(0005, 'Get Down on it', 4, 'https://www.youtube.com/watch?v=qchPLaiKocI'),\n"
                        + "(0006, 'Take my heart', 4, 'https://www.youtube.com/watch?v=aJPYQLp_jsk'),\n"
                        + "(0007, 'We all die young', 4, 'https://www.youtube.com/watch?v=R-WqWaZxXSo'),\n"
                        + "(0008, 'Stay Clean', 2, 'https://www.youtube.com/watch?v=eilzQSthLCY'),\n"
                        + "(0009, 'Breathe', 4, 'https://www.youtube.com/watch?v=rmHDhAohJlQ');");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("9 rows inserted into song table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
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
            pstmt = con.prepareStatement("delete from song where song_id=?"); //delete query
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

    public static void update(int song_id, String song_name, int song_length, String song_url) {
        int status = 0;
        try {
            con = getConnection.getConnection(); //establishing the database connection
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("update song set song_name=?, song_length=?, song_url=? where song_id=?"); //update query
            pstmt.setString(1, song_name);
            pstmt.setInt(2, song_length);
            pstmt.setString(3, song_url);
            pstmt.setInt(4, song_id);
            status = pstmt.executeUpdate(); //executing the query
            pstmt.close();
            con.close();

            if (status > 0) { //checking if record has been updated or not
                System.out.println("Updated record successfully!");
            } else {
                System.out.println("Couldn't update record, some error occured!");

            }

        } catch (SQLException ex) { //catching the exception
            Logger.getLogger(actor.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void read() {

        JSONObject record = new JSONObject();
        try {
            try (Connection con = getConnection.getConnection()) {
                PreparedStatement pstmt = null;
                pstmt = con.prepareStatement("select * from song");

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    record.put("song_id", rs.getString(1));
                    record.put("song_name", rs.getString(2));
                    record.put("song_length", rs.getString(3));
                    record.put("song_url", rs.getString(4));
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
