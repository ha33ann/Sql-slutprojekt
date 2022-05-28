
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


public class studio {
    static Connection con;

    public static void insert() {
        int status = 0;

        try {
            try (Connection con = getConnection.getConnection()) {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = con.prepareStatement("insert into studio values (0001, 'Castle Rock Entertainment', '127A Smithfield Road, Frederiksted, Virgin Islands, United States'),\n"
                        + "(0002, 'Paramount Pictures', 'Forze d\\'Agro, Messina, Sicily, Italy, United States'),\n"
                        + "(0003, 'Warner Bros', 'Chicago, Illinois, United States of America'),\n"
                        + "(0004, 'Orion-Nova Productions', 'New York Country Courthouse, New York City, America'),\n"
                        + "(0005, 'Universal Pictures', 'United States'),\n"
                        + "(0006, 'New Line Cinema', 'Hinuera Valley, New Zealand, United States'),\n"
                        + "(0007, 'Miramax', '1435 Flower Street, Glendale, California, USA'),\n"
                        + "(0008, 'Produzioni Europee Associate (PEA)', 'Carazo, Burgos, Castilla y Leon, Spain'),\n"
                        + "(0009, 'The Steve Tisch Company', 'Chippewa Square, USA'),\n"
                        + "(0010, 'Fox 2000 Picture', 'USA, Germany'),\n"
                        + "(0011, 'Legendary Entertainment', 'USA,  Japanese, French');");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("11 rows inserted into studio table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


        public static void update(int studio_id, String studio_name, String studio_location) {
        int status = 0;
        try {
            con = getConnection.getConnection(); //establishing the database connection
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("update studio set studio_name=?, studio_location=? where studio_id=?"); //update query

            pstmt.setString(1, studio_name);
            pstmt.setString(2, studio_location);
            pstmt.setInt(3, studio_id);
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
            pstmt = con.prepareStatement("delete from studio where studio_id=?"); //delete query
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
                pstmt = con.prepareStatement("select * from studio");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    record.put("studio_id", rs.getString(1));
                    record.put("studio_name", rs.getString(2));
                    record.put("studio_location", rs.getString(3));
                    System.out.println(record);
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
