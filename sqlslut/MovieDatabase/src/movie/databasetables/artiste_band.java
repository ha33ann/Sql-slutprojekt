/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.databasetables;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import movie.DatabaseConnection.getConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class artiste_band {
    getConnection gc=new getConnection();
    public void insert() {
        int status = 0;

        try {
        	getConnection gc=new getConnection();
            try (Connection con = gc.getConnection()) {
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = con.prepareStatement("insert into artiste_band values (0001, 'lead vocals', 0001, 0001),\n"
                        + "(0002, 'lead guitar and singer', 0002, 0004),\n"
                        + "(0003, 'bass', 0003, 0001),\n"
                        + "(0004, 'drums', 0004, 0007),\n"
                        + "(0005, 'lead vocals', 0005, 0005),\n"
                        + "(0006, 'lead guitar', 0006, 0005);");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("6 rows inserted into artiste_band table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
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
            pstmt = con.prepareStatement("delete from artiste_band where artiste_band_id=?"); //delete query
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
    public void read() {

        JSONObject record = new JSONObject();
        try {
            try (Connection con = gc.getConnection()) {
                PreparedStatement pstmt = null;
                pstmt = con.prepareStatement("select * from artiste_band");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    record.put("artiste_band_id", rs.getString(1));
                    record.put("band_role", rs.getString(2));
                    record.put("artiste_artiste_id", rs.getString(3));
                    record.put("band_band_id", rs.getString(4));
                    System.out.println(record);
                }

                pstmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        public void update(int artiste_band_id, String band_role, int artiste_artiste_id, int band_band_id) {
        int status = 0;
        try {
            Connection con = gc.getConnection(); //establishing the database connection
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("update artiste_band set band_role=?, artiste_artiste_id=?, band_band_id=? where artiste_band_id=?"); //update query
            pstmt.setString(1, band_role);
            pstmt.setInt(2, artiste_artiste_id);
            pstmt.setInt(3, band_band_id);
            pstmt.setInt(4, artiste_band_id);
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
