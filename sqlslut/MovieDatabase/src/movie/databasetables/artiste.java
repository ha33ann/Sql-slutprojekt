/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Lenovo
 */
public class artiste {
    static Connection con;
    public static void insert() {
        int status = 0;

        try {
            try (Connection con = getConnection.getConnection()) {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = con.prepareStatement("insert into artiste values (0001, 'Edsel Dope', 'Florida USA', 48),\n"
                        + "(0002, 'Solar Lodger', 'Canada', null),\n"
                        + "(0003, 'Pat Benatar', 'New York City USA', 69),\n"
                        + "(0004, 'Till Lindemann', 'East Germany', 59),\n"
                        + "(0005, 'James \"J.T.\" Taylor', 'South Carolina, US', 68),\n"
                        + "(0006, 'Lemmy', 'Staffordshire England', 70);");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("6 rows inserted into artiste table successfully1");
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
            pstmt = con.prepareStatement("delete from artiste where artiste_id=?"); //delete query
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
                pstmt = con.prepareStatement("select * from artiste");

                ResultSet rs = pstmt.executeQuery();
                JSONArray array = new JSONArray();
                while (rs.next()) {
                    record.put("artiste_id", rs.getString(1));
                    record.put("artiste_name", rs.getString(2));
                    record.put("artiste_country", rs.getString(3));
                    record.put("artiste_age", rs.getString(4));
                    System.out.println(record);
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public static void update(int artiste_id, String artiste_name, String artiste_country, int artiste_age) {
        int status = 0;
        try {
            con = getConnection.getConnection(); //estabishing the database connection
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("update artiste set artiste_name=?, artiste_country=?, artiste_age=? where artiste_id=?"); //update query
            pstmt.setString(1, artiste_name);
            pstmt.setString(2, artiste_country);
            pstmt.setInt(3, artiste_age);
            pstmt.setInt(4, artiste_id);
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
}