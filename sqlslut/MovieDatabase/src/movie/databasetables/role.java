
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


public class role {

	getConnection gc=new getConnection();
    public void insert() {
        int status = 0;

        try {
            try (Connection con = gc.getConnection()) {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = con.prepareStatement("/*inserting in role table */\n"
                        + "insert into role values (0001, 'lead actor', 0001, 0002),\n"
                        + "(0003, 'director' , 0001, 0012),\n"
                        + "(0004, 'writer', 0001, 0013),\n"
                        + "(0005, 'lead actor', 0002, 0011),\n"
                        + "(0006, 'co-actor', 0002, 0011),\n"
                        + "(0007, 'director', 0002, 0014),\n"
                        + "(0008, 'actor', 0003, 0004),\n"
                        + "(0009, 'writer', 0003, 0015),\n"
                        + "(0010, 'director', 0003, 0016),\n"
                        + "(0013, 'lead actor', 0004, 0003),\n"
                        + "(0014, 'director', 0004, 0017);");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("14 rows inserted into role table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                
                pstmt.close();
                con.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    public void update(int role_id, String role_desc, int role_movie_id, int role_person_id) {
        int status = 0;
        try {
            Connection con = gc.getConnection(); //establishing the database connection
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("update role set role_desc=?, role_movie_id=?,role_person_id=? where role_id=?"); //update query
            pstmt.setString(1, role_desc);
            pstmt.setInt(2, role_movie_id);
            pstmt.setInt(3, role_person_id);
            pstmt.setInt(4, role_id);
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

    public void delete(int id) {
        int status = 0;
        try {
            Connection con = gc.getConnection(); //establishing the database connection 
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("delete from role where role_id=?"); //delete query
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

    public void read() {

        JSONObject record = new JSONObject();
        try {
            try (Connection con = gc.getConnection()) {
                PreparedStatement pstmt = null;
                pstmt = con.prepareStatement("select * from role");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    record.put("role_id", rs.getString(1));
                    record.put("role_desc", rs.getString(2));
                    record.put("role_movie_id", rs.getString(3));
                    record.put("role_person_id", rs.getString(4));
                    System.out.println(record);
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
