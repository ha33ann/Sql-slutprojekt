
package movie.databasetables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;


public class genre {

    public void insert(Connection conn) {
        int status = 0;

        try {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = conn.prepareStatement("insert into genre values (0001, 'Drama', 'Drama film is a genre that relies on the emotional and relational development of realistic characters'),\n"
                        + "(0002, 'Crime', 'Films that focus on crime'),\n"
                        + "(0003, 'Action', 'Action film is a film genre in which the protagonist or protagonists end up in a series of challenges that typically include violence, extended fighting, physical feats, and frantic chases.'),\n"
                        + "(0004, 'Comic Book', 'Film adaptions from comic books and graphic novels'),\n"
                        + "(0005, 'Sci-Fi', 'Films of speculative fiction, typically dealing with imaginative concepts such as futuristic science and tech'),\n"
                        + "(0006, 'Mystery', 'Is a type of fiction in which a detective, or other professional, solves a crime or series of crimes'),\n"
                        + "(0007, 'Adventure', 'An adventure is an event or series of events that happens outside the course of the protagonist''s ordinary life, usually accompanied by danger, often by physical action.'),\n"
                        + "(0008, 'Comedy', 'Comedy is a genre of film in which the main emphasis is on humor. ');");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("8 rows inserted into genre table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    public void update(Connection conn, int genre_id, String genre_type, String genre_desc) {
        int status = 0;
        try {
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = conn.prepareStatement("update genre set genre_type=?, genre_desc=? where genre_id=?"); //update query
            pstmt.setString(1, genre_type);
            pstmt.setString(2, genre_desc);
            pstmt.setInt(3, genre_id);
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
            pstmt = conn.prepareStatement("delete from genre where genre_id=?"); //delete query
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
                pstmt = conn.prepareStatement("select * from genre");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    record.put("genre_id", rs.getString(1));
                    record.put("genre_type", rs.getString(2));
                    record.put("genre_desc", rs.getString(3));
                    System.out.println(record);
                }

                pstmt.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
